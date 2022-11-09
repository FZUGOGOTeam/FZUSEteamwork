from pymysql import Connection

# 中场评分权重       首发   替补  进球   助攻
midfield_Weight = [0.57, 0.30, 0.08, 0.05]
# 后场评分权重        首发   替补
backfield_Weight = [0.83, 0.17]
# 前场评分权重         首发   替补  进球   助攻
forecourt_Weight = [0.52, 0.26, 0.11, 0.11]
# 构建MySQL数据库的链接
conn = Connection(
    host="localhost",        # 主机名(IP)
    port=3306,               # 端口
    user="root",             # 账户
    password="Lan58648983",  # 密码
    autocommit=True          # 设置自动提交，不需要手动commit
)
# print(conn.get_server_info())   # 查看MySQL版本，确定是否链接到MySQL
# 执行非查询性质SQL
cursor = conn.cursor()  # 获取游标对象
# 选择数据库
conn.select_db("players")
# 使用游标对象，执行SQL并获取查询结果
cursor.execute("select name,location from info")
results = cursor.fetchall()
print(results)
info = results  # 记录下所需的球员的基本信息
# NAME = []
# for item in results:
#     NAME.append(item[0])
# print(NAME)
for item in results:
    cursor.execute(f"select * from record where name = '{item[0]}'")
    data = cursor.fetchall()
    score = 0   # 初始总评分为0分
    print(f"{item[0]}的历史数据为：")
    for element in data:
        if item[1] == "前锋":
            # 根据前场评分权重计算总评
            score += element[3] * forecourt_Weight[0]
            score += (element[2] - element[3]) * forecourt_Weight[1]
            score += element[4] * forecourt_Weight[2]
            score += element[5] * forecourt_Weight[3]
        if item[1] == "中场":
            # 根据中场评分权重计算总评
            score += element[3] * midfield_Weight[0]
            score += (element[2] - element[3]) * midfield_Weight[1]
            score += element[4] * midfield_Weight[2]
            score += element[5] * midfield_Weight[3]
        if item[1] == "后卫":
            # 根据后场评分权重计算总评
            score += element[3] * midfield_Weight[0]
            score += (element[2] - element[3]) * midfield_Weight[1]
        print(element)  # 每个赛季的数据
    print(f"{item[0]}的总评为：")
    print(round(1.3 * score))
    cursor.execute(f"update info set score={round(1.3*score)} where name='{item[0]}'")
# 关闭链接
conn.close()
