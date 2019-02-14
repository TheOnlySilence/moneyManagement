from flask import Flask, redirect, request, render_template, url_for, views
from sqlalchemy import create_engine


app = Flask(__name__)
base_url = 'http://127.0.0.1:5500'

engine = create_engine("mysql+pymysql://root:@127.0.0.1:3306/moneymanagement", max_overflow=5)
conn = engine.connect()

"""
@app.route('/<int:user_id>/',methods=['GET','POST'])
def home(user_id):
    if request.method == 'GET':
        return render_template('home.html',user_id=user_id)
    else:
        return redirect(base_url+f'/{user_id}/detail')
"""


def auth(func):
    def inner(*args, **kwargs):
        result = func(*args, **kwargs)
        return result

    return inner


class HomeView(views.MethodView):
    method = ['GET', 'POST']
    decorators = [auth, ]

    def get(self, user_id):
        return render_template('home.html', user_id=user_id)

    def post(self, user_id):
        return redirect(base_url + f'/{user_id}/detail')


app.add_url_rule('/<int:user_id>/', view_func=HomeView.as_view(name='home'))  # name = endpoint

"""
@app.route('/<int:user_id>/detail/', methods=['GET'])
def detail(user_id):
    return render_template('detail.html',info=user_id)
"""


class DetailView(views.MethodView):
    method = ['GET']
    decorators = [auth, ]

    def get(self, user_id):
        return render_template('detail.html', info=user_id)

    def post(self):
        return 'Detail.POST'


app.add_url_rule('/<int:user_id>/detail/', view_func=DetailView.as_view(name='detail'))  # name = endpoint


@app.route('/', methods=['GET', 'POST'])
def login():
    if request.method == 'GET':
        # template default store in templates file
        return render_template('login.html')
    else:
        user = request.form.get('user')
        # .....database operations
        if user == '12':
            # jump to other pages
            return redirect(base_url + f'/{user}/')
        else:
            return render_template('login.html', error='wrong user info')


if __name__ == '__main__':
    app.run(port='5500',debug=True)
