import datetime
import threading
from pymysql import Connection

# 中场评分权重       首发   替补  进球   助攻
midfield_Weight = [0.57, 0.30, 0.08, 0.05]
# 后场评分权重        首发   替补
backfield_Weight = [0.83, 0.17]
# 前场评分权重         首发   替补  进球   助攻
forecourt_Weight = [0.52, 0.26, 0.11, 0.11]


def csl():
    # 获取现在时间
    now = datetime.datetime.now()
    print(f"{now.date().year}年{now.date().month}月{now.date().day}日CSL数据库开始更新")

    # 构建MySQL数据库的链接
    conn = Connection(
        host="124.222.161.184",  # 主机名(IP)
        port=3306,  # 端口
        user="gogo",  # 账户
        password="987654321",  # 密码
        autocommit=True  # 设置自动提交，不需要手动commit
    )
    # print(conn.get_server_info())   # 查看MySQL版本，确定是否链接到MySQL

    # 执行SQL语句
    cursor = conn.cursor()  # 获取游标对象
    # 选择数据库
    conn.select_db("snqz_databases")
    # 使用游标对象，执行SQL并获取查询结果
    cursor.execute("select count(*) from native_player_info")
    results = cursor.fetchall()
    counts = results[0][0]  # 取数据库行数
    errors = 0  # 错误个数每天重置为0
    # 获取名字与位置信息
    cursor.execute("select name,position from native_player_info")
    results = cursor.fetchall()
    # print(results)

    # 数据处理
    for item in results:
        try:
            cursor.execute(f"select * from native_player_matchdata where name = '{item[0]}'")
            data = cursor.fetchall()
            # print(data)  # 查看总体数据
            score = 0  # 初始总评分为0分
            # print(f"{item[0]}的历史数据为：")
            for element in data:
                if item[1] == "前锋":
                    # 根据前场评分权重计算总评
                    score += int(element[3]) * forecourt_Weight[0]
                    score += (int(element[2]) - int(element[3])) * forecourt_Weight[1]
                    score += int(element[4]) * forecourt_Weight[2]
                    score += int(element[5]) * forecourt_Weight[3]
                elif item[1] == "中场":
                    # 根据中场评分权重计算总评
                    score += int(element[3]) * midfield_Weight[0]
                    score += (int(element[2]) - int(element[3])) * midfield_Weight[1]
                    score += int(element[4]) * midfield_Weight[2]
                    score += int(element[5]) * midfield_Weight[3]
                elif item[1] == "后卫":
                    # 根据后场评分权重计算总评
                    score += int(element[3]) * midfield_Weight[0]
                    score += (int(element[2]) - int(element[3])) * midfield_Weight[1]
                elif item[1] == "门将":
                    # 根据后场评分权重计算总评
                    score += int(element[3]) * midfield_Weight[0]
                    score += (int(element[2]) - int(element[3])) * midfield_Weight[1]
                else:
                    # 防止特殊情况
                    score += int(element[3]) * midfield_Weight[0]
                    score += (int(element[2]) - int(element[3])) * midfield_Weight[1]
                # print(element)  # 每个赛季的数据
            # print(f"{item[0]}的总评为：")
            # print(round(1.3 * score))
            cursor.execute(f"update native_player_info set score={round(1.0 * score) + 20} where name='{item[0]}'")
            # print(f"{item[0]}总评录入完成")
        except Exception as error:
            errors += 1  # 错误个数+1
            log = f"{now.date().year}-{now.date().month}-{now.date().day}.txt"  # 定义日志文件名
            with open(log, 'a', encoding="utf-8") as file:  # with open()方法打开日志文件，如果没有就新生成一个文件，a追加内容
                file.write(f"{item[0]}数据处理异常：" + str(error) + '\n')  # 将错误写入日志文件

    # 关闭链接
    conn.close()
    print(f"{now.date().year}年{now.date().month}月{now.date().day}日中超数据库成功更新：({counts - errors}/{counts})")

    # 隔一天更新数据库
    time = threading.Timer(86400, csl)
    time.start()


# 获取现在时间
now_time = datetime.datetime.now()
# print(now_time)

# 获取明天时间
next_time = now_time + datetime.timedelta(days=+1)
next_year = next_time.date().year
next_month = next_time.date().month
next_day = next_time.date().day
# print(next_time, next_year, next_month, next_day)

# 获取明天设定时间，此处为凌晨3点
next_time = datetime.datetime.strptime(str(next_year) + "-" + str(next_month) + "-" + str(next_day) +
                                       " 03:00:00", "%Y-%m-%d %H:%M:%S")
# print(next_time)
# 获取昨天时间
# last_time = now_time + datetime.timedelta(days=-1)

# 获取距离明天3点时间，单位为秒
timer_start_time = (next_time - now_time).total_seconds()
# print(timer_start_time)

# 定时器,参数为(多少时间后执行，单位为秒，执行的方法)
# timer = threading.Timer(timer_start_time, csl)
timer = threading.Timer(0, csl)   # 立即执行，用于测试
timer.start()
