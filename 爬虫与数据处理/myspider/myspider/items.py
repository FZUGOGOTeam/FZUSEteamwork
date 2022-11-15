# Define here the models for your scraped items
#
# See documentation in:
# https://docs.scrapy.org/en/latest/topics/items.html

import scrapy

playerDataTableName = ['season', 'clubName', 'play_count', 'starter_count', 'goal', 'assists', 'yellow_card', 'red_card', '替补']
class MyspiderItem(scrapy.Item):
    # define the fields for your item here like:
    player_name = scrapy.Field()
    player_photo = scrapy.Field()
    player_club = scrapy.Field()
    player_country = scrapy.Field()
    player_height = scrapy.Field()
    player_position = scrapy.Field()
    player_age = scrapy.Field()
    player_weight = scrapy.Field()
    player_number = scrapy.Field()
    player_birth = scrapy.Field()
    player_preferredfoot = scrapy.Field()

    season = scrapy.Field()
    clubName = scrapy.Field()
    play_count = scrapy.Field()
    starter_count = scrapy.Field()
    goal = scrapy.Field()
    assists = scrapy.Field()
    yellow_card = scrapy.Field()
    red_card = scrapy.Field()
    pass
