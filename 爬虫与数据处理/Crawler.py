import requests
from bs4 import BeautifulSoup
import xlwings as xw
import json


def Pc():
    url1 = 'https://www.dongqiudi.com/team/50077677.html'
    html = None
    header = {
        'User-Agent': "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Safari/537.36",
    }

    response = requests.get(url=url1, headers=header)
    html = response.content.decode('UTF-8')
    soup = BeautifulSoup(html,'html.parser')
    li = soup.find_all('script')

    itt = json.loads(li)
    print(type(itt))


# 按间距中的绿色按钮以运行脚本。
if __name__ == '__main__':
    Pc()