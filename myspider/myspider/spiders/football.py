import json

import scrapy
import re
from ..items import MyspiderItem

playerData = []

U21playerData = []
U23playerData = []

def isU21(str):
    return "U21" in str

def isU23(str):
    return "U23" in str

# 在懂球帝的球队详情界面 获得U21和U23球员的名字和id
def GetUnder21And23Player(script):
    # person_name  person_id
    flag = 0
    teamdata = "{"
    countleft = 0
    countright = 0
    player_name = ""
    player_id = ""
    for i in range(0, len(script) - 15):
        temp = ""
        for j in range(0, 14):
            temp += script[i + j]

        if temp == "teamMemberData":
            for j in range(i, len(script)):
                if script[j] == ']':
                    countright += 1
                elif script[j] == '[':
                    countleft += 1
                if countleft == countright and countleft != 0:
                    teamdata += "]}"
                    flag = 1
                    break
                teamdata += script[j]
        if flag == 1:
            break
    for i in range(0, len(teamdata) - 11):
        temp = ""
        for j in range(0, 9):
            temp += teamdata[i + j]
        if temp == "person_id":
            for j in range(i + 11, len(teamdata)):
                if teamdata[j + 1] == ",":
                    break
                player_id += teamdata[j]
        temp = ""
        for j in range(0, 11):
            temp += teamdata[i + j]
        if temp == "person_name":
            for j in range(i + 13, len(teamdata)):
                if teamdata[j + 1] == ",":
                    break
                player_name += teamdata[j]

            playerData.append({"name": player_name, "id": player_id})
            player_name = ""
            player_id = ""
    for item in playerData:
        if isU21(item["name"]) == True:
            U21playerData.append(item)
        if isU23(item["name"]) == True:
            U23playerData.append(item)

class FootballSpider(scrapy.Spider):
    name = 'football'
    allowed_domains = ['www.dongqiudi.com']
    start_urls = ['https://www.dongqiudi.com/team/50077677.html']

    def parse(self, response):
        items = MyspiderItem()
        script = response.xpath("//body//script/text()").get()
        GetUnder21And23Player(script)


