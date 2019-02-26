from flask import Flask
from flask_cors import CORS


def create_app():
    app = Flask(__name__, template_folder='templates', static_folder='src', static_url_path='/frontend/src')

    # avoid cross-site request forgery(CSRF)
    CORS(app)

    # blueprint
    from .main import main
    app.register_blueprint(main)
    app.config.from_object('backend.config.setting.DevelopmentConfig')
    app.config.from_object('backend.config.secure')
    return app
