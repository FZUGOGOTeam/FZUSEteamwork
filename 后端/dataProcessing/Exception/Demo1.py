import datetime

try:
    num = 1/0
except Exception as error:
    now_time = datetime.datetime.now().strftime('%Y-%m-%d')  # 获取当前时间
    log = now_time+'.txt'  # 定义日志文件名
    with open(log, 'a', encoding="utf-8") as file:  # with open()方法打开日志文件，如果没有就新生成一个文件，a追加内容
        file.write('抛出异常：'+str(error)+'\n')   # 将错误写入日志文件
