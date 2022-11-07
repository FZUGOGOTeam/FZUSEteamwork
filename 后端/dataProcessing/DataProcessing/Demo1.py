import numpy as np

'''1.输入数据'''
print("请输入参评对象数目：")
n = eval(input())
print("请输入评价指标数目：")
m = eval(input())
print("请输入指标类型：1:极大型，2：极小型")
kind = input().split(" ")
print("请输入矩阵：")
X = np.zeros(shape=(n, m))
for i in range(n):
    X[i] = input().split(" ")
    X[i] = list(map(float, X[i]))
print("输入的矩阵为：\n{}".format(X))

'''2.标准化处理'''
def maxTomax(maxx, minx, x):
    x = list(x)
    ans = [[(e-minx)]/(maxx-minx) for e in x]
    return np.array(ans)
def minTomax(maxx, minx, x):
    x = list(x)
    ans = [[(maxx-e)]/(maxx-minx) for e in x]
    return np.array(ans)

A = np.zeros(shape=(n, 1))

for i in range(m):
    maxA = max(X[:, i])
    minA = min(X[:, i])
    if kind[i] == "1":
        v = maxTomax(maxA, minA, X[:, i])
    elif kind[i] == "2":
        v = minTomax(maxA, minA, X[:, i])
    if i == 0:
        A = v.reshape(-1, 1)
    else:
        A = np.hstack([A, v.reshape(-1, 1)])
print("标准化矩阵为：\n{}".format(A))

'''3.计算对比强度'''
V = np.std(A, axis=0)
print("对比强度为：\n{}".format(V))

'''4.计算冲突性'''
A2 = list(map(list, zip(*A))) # 矩阵转置
r = np.corrcoef(A2)   # 求皮尔逊相关系数
f = np.sum(1-r, axis=1)
print("冲突性为：\n{}".format(f))

'''5.计算信息承载量'''
C = V*f
print('信息承载量为：\n{}'.format(C))

'''6.计算权重'''
w = C/np.sum(C)
print('权重为：\n{}'.format(w))

'''7.计算得分'''
s = np.dot(A, w)
Score = 100*s/max(s)
for i in range(len(Score)):
    print(f"第{i+1}个测评对象的百分制得分为：{Score[i]}")