class Config(object):
    DEBUG = False
    TESTING = False


class ProductionConfig(Config):
    secret_key = '895402142'


class DevelopmentConfig(Config):
    DEBUG = True


class TestingConfig(Config):
    TESTING = True

