# Define here the models for your scraped items
#
# See documentation in:
# https://docs.scrapy.org/en/latest/topics/items.html

import scrapy


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

    pass
