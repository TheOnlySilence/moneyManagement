from flask import render_template, Blueprint, url_for, redirect, request, views,jsonify, abort
from sqlalchemy import create_engine
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy.orm import sessionmaker, relationship
from sqlalchemy import Column, Integer, String, ForeignKey, UniqueConstraint, Index, Float, text



main = Blueprint('main', __name__, template_folder='templates')


"""
SQLAlchemy
"""
engine = create_engine("mysql+pymysql://root:@127.0.0.1:3306/moneymanagement", max_overflow=5)

Base = declarative_base()


def init_db():
    Base.metadata.create_all(engine)


def drop_db():
    Base.metadata.drop_all(engine)


class Categories(Base):
    __tablename__ = 'categories'
    categories_id = Column(Integer, primary_key=True)
    categories = Column(String(32))


class Company(Base):
    __tablename__ = 'company'
    company_id = Column(Integer, primary_key=True)
    company_name = Column(String(32))
    location = Column(String(100))


class CreditCard(Base):
    __tablename__ = 'credit_card'
    UID = Column(Integer)
    card_num = Column(Integer, primary_key=True)
    cvv = Column(Integer)
    exp_date = Column(String(16))


class TransactionInfo(Base):
    __tablename__ = 'transaction_info'
    TID = Column(Integer, primary_key=True)
    UID = Column(Integer)
    amount = Column(Float)
    categories_id = Column(Integer)
    T_date = Column(String(10))
    T_time = Column(String(10))
    campany_id = Column(Integer)
    type_id = Column(Integer)


class TransType(Base):
    __tablename__ = 'trans_type'
    type_id = Column(Integer, primary_key=True)
    trans_type = Column(String(32))


class UserInfo(Base):
    __tablename__ = 'user_info'
    UID = Column(Integer, primary_key=True)
    firstname = Column(String(32))
    lastname = Column(String(32))
    type_id = Column(Integer)
    age = Column(Integer)
    gender = Column(String(1))


Session = sessionmaker(bind=engine)
session = Session()

"""
View
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
        return render_template('index.html', user_id=user_id)

    def post(self, user_id):
        #return redirect(base_url + f'/{user_id}/detail')
        return {'home':'POST'}


main.add_url_rule('/<int:user_id>/', view_func=HomeView.as_view(name='home'))  # name = endpoint


class DetailView(views.MethodView):
    method = ['GET']
    decorators = [auth, ]

    def get(self, user_id):
        return render_template('index.html', info=user_id)

    def post(self):
        return 'Detail.POST'


main.add_url_rule('/<int:user_id>/detail/', view_func=DetailView.as_view(name='detail'))  # name = endpoint


@main.route('/login/<int:user_id>', methods=['GET'])
def login():
    """
    if request.method == 'GET':
        return render_template('index.html')
    else:
        user = request.form.get('user')
        # .....database operations

        db_user = session.query(UserInfo.UID).filter_by(UID=user).all()
        # db_user = session.query(UserInfo).from_statement(text("SELECT * FROM user_info where UID=:user_id")).params(user_id=user).all()
        if db_user:
            # jump to other pages
            print(db_user)
            return True
        else:
            print(db_user)
            return render_template('login.html', error='wrong user info')

    """

    if not request.json or ('user_id' not in request.json):
        abort(400)
    else:
        user = request.form.get('user_id')
        db_user = session.query(UserInfo.UID).filter_by(UID=user).all()

        if db_user:
            return jsonify({'msg':True})
        else:
            return jsonify({'msg':False})


