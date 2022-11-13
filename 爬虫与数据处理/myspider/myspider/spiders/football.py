import json

import scrapy
import re
from ..items import MyspiderItem

playerData = []

U21playerData = []
U23playerData = []

playerInfo = []
tempPlayerInfo = []


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
    print(U21playerData)
    print(U23playerData)

class FootballSpider(scrapy.Spider):
    name = 'football'
    allowed_domains = ['www.dongqiudi.com']
    start_urls = ['https://www.dongqiudi.com/team/50077677.html']
    #/team/50077677.html


    def parse(self, response):  #从球队中爬取球员名字和ID
        items = MyspiderItem()
        script = response.xpath("//body//script/text()").get()
        GetUnder21And23Player(script)


            
        for item in U21playerData:
            player_url = 'https://www.dongqiudi.com/player/'+str(item["id"])+'.html'

            yield scrapy.Request(url=player_url, callback=self.parse_second)

        for item in U23playerData:
            player_url = 'https://www.dongqiudi.com/player/'+str(item["id"])+'.html'
            yield scrapy.Request(url=player_url, callback=self.parse_second)




    def parse_second(self, response):   #每一个球员的爬取

        data = response.xpath("string(//div[@class='player-info'])").get()
        print(data)
        tempPlayerInfo.clear()
        for i in range(0, len(data)):
            if data[i] == "：":
                temp = ""
                for j in range(i+1, len(data)):
                    if data[j] == " ":
                        i = j
                        break
                    temp += data[j]
                tempPlayerInfo.append(temp)

        data = response.xpath("string(//p[@class='china-name'])").get()
        tempPlayerInfo.append(data)
        print(data)
        data = response.xpath("//img[@class='player-photo']/@src").get()
        tempPlayerInfo.append(data)

        playerInfo.append({"name": tempPlayerInfo[9],"Picsrc": tempPlayerInfo[10],"age":tempPlayerInfo[4],"birthday": tempPlayerInfo[7], "clubName": tempPlayerInfo[0], "country": tempPlayerInfo[1],
                           "height":tempPlayerInfo[2],"number":tempPlayerInfo[6],"position":tempPlayerInfo[3],"preferredFoot": tempPlayerInfo[8],"weight":tempPlayerInfo[5]})
        items = MyspiderItem()
        items['player_name'] = tempPlayerInfo[9]
        items['player_photo'] = tempPlayerInfo[10]
        items['player_club'] = tempPlayerInfo[0]
        items['player_country'] = tempPlayerInfo[1]
        items['player_height'] = tempPlayerInfo[2]
        items['player_position'] = tempPlayerInfo[3]
        items['player_age'] = tempPlayerInfo[4]
        items['player_weight'] = tempPlayerInfo[5]
        items['player_number'] = tempPlayerInfo[6]
        items['player_birth'] = tempPlayerInfo[7]
        items['player_preferredfoot'] = tempPlayerInfo[8]
        yield items
        print(playerInfo)