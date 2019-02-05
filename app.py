from flask import Flask, redirect, request, render_template, url_for
from flask_script import Manager

app = Flask(__name__)
manager = Manager(app=app)
app.config.from_object("settings.DevelopmentConfig")
base_url = 'http://127.0.0.1:5000'


@app.route('/<int:user_id>/',methods=['GET','POST'])
def home(user_id):
    if request.method == 'GET':
        return render_template('home.html',user_id=user_id)
    else:
        return redirect(base_url+f'/{user_id}/detail')


@app.route('/<int:user_id>/detail/', methods=['GET'])
def detail(user_id):
    return render_template('detail.html',info=user_id)


@app.route('/',methods=['GET','POST'])
def login():
    if request.method == 'GET':
        # template default store in templates file
        return render_template('login.html')
    else:
        # request for header
        # request.query_string

        # request for content
        user = request.form.get('user')
        pwd = request.form.get('pwd')

        # .....database operations
        if user == '12' and pwd == '':
            # jump to other pages
            return redirect(base_url+f'/{user}/')
        else:
            return render_template('login.html', error='wrong user info')


if __name__ == '__main__':
    manager.run()
