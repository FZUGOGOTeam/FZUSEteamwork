# Define your item pipelines here
#
# Don't forget to add your pipeline to the ITEM_PIPELINES setting
# See: https://docs.scrapy.org/en/latest/topics/item-pipeline.html


# useful for handling different item types with a single interface
from itemadapter import ItemAdapter

import pymysql

class MyspiderPipeline:
    def open_spider(self, spider):
        self.conn = pymysql.connect(user="root", password="abcd546789", host="124.222.161.184", port=3306, database="snqz_databases")

    def process_item(self, item, spider):
        self.conn.query(
            "insert native_player_info(name,picsrc,age,birthday,clubName,country,height,number,position,preferredFoot,weight)"  # 需要插入的字段
            "values('{}','{}','{}','{}','{}','{}','{}','{}','{}','{}','{}')".format(
                item['player_name'],
        item['player_photo'],
        item['player_age'],
        item['player_birth'],
        item['player_club'],
        item['player_country'],
        item['player_height'],
        item['player_number'],
        item['player_position'],
        item['player_preferredfoot'],
        item['player_weight']
            ))

    def close_spider(self, spider):
        # 关闭爬虫时顺便将文件保存退出

        self.conn.close()  # 关闭连接