from scrapy import cmdline


cmdline.execute("scrapy crawl football -o football.csv".split())