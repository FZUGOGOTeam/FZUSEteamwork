from pymysql import Connection

# 构建MySQL数据库的链接
conn = Connection(
    host="localhost",       # 主机名(IP)
    port=3306,              # 端口
    user="root",            # 账户
    password="Lan58648983"  # 密码
)
print(conn.get_server_info())   # 查看MySQL版本，确定是否链接到MySQL
# 执行非查询性质SQL
cursor = conn.cursor()  # 获取游标对象
# 选择数据库
conn.select_db("players")
# 使用游标对象，执行SQL
cursor.execute("select * from record")
# 获取查询结果
results = cursor.fetchall()  # 存储类型为元组
print(results)
# 关闭链接
conn.close()
