import numpy as np
from functools import reduce
# 中场球员的权重矩阵
'''1.输入数据'''
n = 4
print(f"中场判断矩阵大小为：{n}")
# 判断矩阵
list1 = [1, 3, 7, 7]
list2 = [0.3, 1, 6, 6]
list3 = [0.1, 0.2, 1, 2]
list4 = [0.1, 0.2, 0.5, 1]
arr = [list1, list2, list3, list4]
A = np.array(arr)
print("中场判断矩阵为：\n{}".format(A))

'''2.一致性检验'''
# 求解特征向量的最大特征值
w, v = np.linalg.eig(A)
wIndex = np.argmax(w)
wMax = np.real(w[wIndex])
print("最大特征值数值：{}".format(wMax))
# 输出一致性指标CI
CI = (wMax - n)/(n-1)
print("CI数值：{}".format(CI))
# 输出平均随机一致性指标RI, 直接查表可得, 不同标准数值有所差别。
# RI数据来源：洪志国.层次分析法中高阶平均随机一致性指标(RI)的计算[J].计算机工程与应用,2002(12):45-47+150.
RI = [0, 0, 0.0001, 0.52, 0.89, 1.12, 1.26, 1.36,
      1.41, 1.46, 1.49, 1.52, 1.54, 1.56, 1.58, 1.59,
      1.5943, 1.6064, 1.6133, 1.6207, 1.6292]
print("RI数值：{}".format(RI[n]))
# 输出一致性比例CR
CR = CI/RI[n]
print("CR数值：{}".format(CR))
# 判断是否可以接受
if CR > 0.1:
    print("该判断矩阵A的一致性不可以接受.")
else:
    print("该判断矩阵A的一致性可以接受.")

    '''3.归一化处理'''
    lineSum = [sum(m) for m in zip(*A)]
    D = np.zeros((n, n))
    for i in range(n):
        for j in range(n):
            D[i][j] = A[i][j]/lineSum[j]
    print("归一化判断矩阵为：\n{}".format(D))

    '''4.计算权重'''
    # 算术平均法计算权重
    ans = np.zeros(n)
    for i in range(n):
        ans[i] = np.average(D[i])
    print("算术平均法权重计算结果为：\n{}".format(ans))
    # 几何平均法计算权重
    ans = np.zeros(n)
    for i in range(n):
        ans[i] = reduce(lambda x,y:x*y, A[i])
        ans[i] = pow(ans[i], 1/n)
    ans = [e/np.sum(ans) for e in ans]
    print("几何平均法权重计算结果为：\n{}".format(ans))
    # 特征值法计算权重
    ans = np.zeros(n)
    vIndex = np.argmax(v)  # 对应最大特征值的特征向量索引
    vMax = np.real(v[:, vIndex])
    ans = [e/np.sum(vMax) for e in vMax]
    print("特征值法权重计算结果为：\n{}".format(ans))