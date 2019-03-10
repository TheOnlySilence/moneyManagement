from flask import Flask
from flask_cors import CORS
from flask_restful import Api
from backend.main.api import Home,Detail
from .main.database import db

def create_app():
    app = Flask(__name__)

    # avoid cross-site request forgery(CSRF)
    CORS(app)
    app.config.from_object('backend.config.setting.ProductionConfig')
    app.config.from_object('backend.config.secure')
    db.init_app(app)
    api = Api(app)
    api.add_resource(Home, '/<int:UID>/home')
    api.add_resource(Detail, '/<int:UID>/detail')

    return app