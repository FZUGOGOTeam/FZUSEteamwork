# Define your item pipelines here
#
# Don't forget to add your pipeline to the ITEM_PIPELINES setting
# See: https://docs.scrapy.org/en/latest/topics/item-pipeline.html


# useful for handling different item types with a single interface
from itemadapter import ItemAdapter
import pymysql

playerDataTableName = ['season', 'clubName', 'play_count', 'starter_count', 'goal', 'assists', 'yellow_card', 'red_card', 'player_name']


#"insert into native_player_info(name,picsrc,age,birthday,clubName,country,height,number,position,preferredFoot,weight) values(%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)"
class MyspiderPipeline:
    def open_spider(self, spider):
        self.conn = pymysql.connect(user="gogo", password="987654321", host="124.222.161.184", port=3306, database="snqz_databases")
        self.cur = self.conn.cursor()
    def process_item(self, item, spider):
        '''
        values = (
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
        )
        insert_sql = "insert into native_player_info(name,picsrc,age,birthday,clubName,country,height,number,position,preferredFoot,weight) values(%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)"
        '''
        values = (
            item[playerDataTableName[0]],
            item[playerDataTableName[1]],
            item[playerDataTableName[2]],
            item[playerDataTableName[3]],
            item[playerDataTableName[4]],
            item[playerDataTableName[5]],
            item[playerDataTableName[6]],
            item[playerDataTableName[7]],
            item[playerDataTableName[8]],
        )
        insert_sql = "insert into native_player_matchdata(season,clubName,play_count,starter_count,goal,assists,yellow_card,red_card,name) values(%s,%s,%s,%s,%s,%s,%s,%s,%s)"

        self.cur.execute(insert_sql, values)



    def close_spider(self, spider):
        # 关闭爬虫时顺便将文件保存退出
        self.conn.commit()
        self.conn.close()  # 关闭连接