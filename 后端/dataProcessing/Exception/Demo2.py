import traceback


try:
	num = 1/0
except Exception:
	with open('C:/Users/vamos/Desktop/数据库日志.txt',"a") as f:
	    traceback.print_exc(file = f)
