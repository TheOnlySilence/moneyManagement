from flask import jsonify, make_response
from flask_restful import reqparse, Resource
from datetime import datetime
from .model import *
from .prediction import *

userInfo = reqparse.RequestParser()
creditCardInfo = reqparse.RequestParser()
transaction = reqparse.RequestParser()
categoryRatio = reqparse.RequestParser()
currentTime = reqparse.RequestParser()
test = reqparse.RequestParser()
pred = reqparse.RequestParser()
aveMonthlyExp = reqparse.RequestParser()


# UserInfo, CreditCardInfo, Transaction, CategoryRatio, CurrentTime, prediction
class User(Resource):
    def get(self, UID):
        user = existed(UID)
        if user:
            user_information = {'firstname': user[0][0],
                                'lastname': user[0][1],
                                'age': user[0][2],
                                'gender': user[0][3]}

            data = {'user_information': user_information}
            status = {'status': 'ok', 'status_message': 'Query was successful'}

            return {'data': data}, 200, {'status': status}
        else:
            data = {'auth': 0, 'description': 'user is not existed'}
            data = jsonify(data)
            return make_response(data, 404)

    def patch(self):
        pass


class CreditCardInfo(Resource):
    def get(self, UID):
        user = existed(UID)
        if user:
            credit_card = get_credit_card_info(UID)
            credit_card_info = {}
            n = 0
            for i in credit_card:
                credit_card_info[n] = {'card_number': i[0],
                                       'cvv': i[1],
                                       'exp_date': i[2]}
                n += 1

            data = {'credit_card_info': credit_card_info}
            status = {'status': 'ok', 'status_message': 'Query was successful'}

            return {'data': data}, 200, {'status': status}
        else:
            data = {'auth': 0, 'description': 'user is not existed'}
            data = jsonify(data)
            return make_response(data, 404)


class Transaction(Resource):
    def get(self, UID):
        transaction.add_argument('year', required=False,
                                 help='transactions for particular year, default is latest year')
        transaction.add_argument('month', required=False,
                                 help='transaction for particular month, default is latest month')
        transaction.add_argument('recent_transactions', required=False, help='look for recent transaction',
                                 default=False)

        transaction.add_argument('categ', required=False, help='look for particular category, default = all category',
                                 default=False)
        args = transaction.parse_args()
        year = args['year']
        month = args['month']
        recent_transactions = args['recent_transactions']
        categ_id = args['categ']
        user = existed(UID)
        if user:

            if not year:
                year = int(get_latest_year(UID)[0])

            if not month:
                month = int(str(get_latest_month(UID, year)).split(sep='-')[1])

            if recent_transactions:
                data = get_recent_transactions(UID, year, month)
            else:

                if categ_id:
                    data = get_transactions_by_categ(UID, year,month, categ_id)
                else:
                    data = get_transactions(UID, year, month)

            transactions = {}
            for i in data:
                TID = i[1]
                transactions[TID] = {'UID': i[0], 'date': i[2], 'time': i[3], 'company': i[4], 'category': i[5],
                                     'amount': i[6], 'type': i[7]}

            data = {'transactions': transactions, 'length': len(transactions)}
            status = {'status': 'ok', 'status_message': 'Query was successful'}

            return {'data': data}, 200, {'status': status}

        else:
            data = {'auth': 0, 'description': 'user is not existed'}
            data = jsonify(data)
            return make_response(data, 404)


class CategoryRatio(Resource):
    def get(self, UID):
        categoryRatio.add_argument('year', required=False,
                                   help='transactions for particular year, default is latest year')
        categoryRatio.add_argument('month', required=False,
                                   help='transaction for particular month, default is latest month')
        args = categoryRatio.parse_args()
        year = args['year']
        month = args['month']
        user = existed(UID)
        if user:
            expense = 0
            ratio = {}
            Education = 0
            HealthCare = 0
            Apparel = 0
            Transportation = 0
            Entertainment = 0
            Insurance = 0
            Housing = 0
            Groceries = 0
            Food = 0

            if not year:
                year = int(get_latest_year(UID)[0])

            if not month:
                month = int(str(get_latest_month(UID, year)).split(sep='-')[1])

            data = get_transactions(UID, year, month)
            for i in data:

                expense += i[6]

                if i[5] == 'Education':
                    Education += i[6]
                elif i[5] == 'HealthCare':
                    HealthCare += i[6]
                elif i[5] == 'Apparel':
                    Apparel += i[6]
                elif i[5] == 'Transportation':
                    Transportation += i[6]
                elif i[5] == 'Entertainment':
                    Entertainment += i[6]
                elif i[5] == 'Insurance':
                    Insurance += i[6]
                elif i[5] == 'Housing':
                    Housing += i[6]
                elif i[5] == 'Groceries':
                    Groceries += i[6]
                elif i[5] == 'Food':
                    Food += i[6]

            ratio['Education'] = int(Education / expense * 100)
            ratio['HealthCare'] = int(HealthCare / expense * 100)
            ratio['Apparel'] = int(Apparel / expense * 100)
            ratio['Transportation'] = int(Transportation / expense * 100)
            ratio['Entertainment'] = int(Entertainment / expense * 100)
            ratio['Insurance'] = int(Insurance / expense * 100)
            ratio['Housing'] = int(Housing / expense * 100)
            ratio['Groceries'] = int(Groceries / expense * 100)
            ratio['Food'] = int(Food / expense * 100)

            data = {'ratio': ratio}
            status = {'status': 'ok', 'status_message': 'Query was successful'}

            return {'data': data}, 200, {'status': status}
        else:
            data = {'auth': 0, 'description': 'user is not existed'}
            data = jsonify(data)
            return make_response(data, 404)


class CurrentTime(Resource):
    def get(self):
        time = datetime.now()
        result = jsonify(time)
        return make_response(result, 200)


class Prediction(Resource):

    def get(self,UID):
        pred.add_argument('month',required=True,help=' #th of the month needs to be predicted')
        args = pred.parse_args()
        month = args['month']
        user = existed(UID)

        if user:
            transData = ml_data(UID)
            predData = prediction(transData,month)
            data = {'prediction': predData}
            status = {'status': 'Created', 'status_message': 'Query was successful'}

            return {'data': data}, 200, {'status': status}

        else:
            data = {'auth': 0, 'description': 'user is not existed'}
            data = jsonify(data)
            return make_response(data, 404)

class AveMonthlyExp(Resource):
    def get(self,UID):
        aveMonthlyExp.add_argument('month',required=True,help='ave exp for which month')
        args = aveMonthlyExp.parse_args()
        month = args['month']
        user = existed(UID)
        earliest_year = get_earliest_year(UID,month)[0]
        latest_year = get_latest_year(UID)[0]
        years = latest_year - earliest_year + 1


        if(month == 1):
            days = 31
        elif(month == 2):
            days = 28
        elif(month == 3):
            days = 31
        elif(month == 4):
            days = 30
        elif(month == 5):
            days = 31
        elif(month == 6):
            days = 30
        elif(month == 7):
            days = 31
        elif(month == 8):
            days = 31
        elif(month == 9):
            days = 30
        elif(month == 10):
            days = 31
        elif(month == 11):
            days = 30
        elif(month == 12):
            days = 31
        
        sum = 0
        if user:
            exp = sum_monthly_exp(UID,month)
            for i in range(0,len(exp)):
                sum = sum + float(exp[i][0])

            avg = sum/years
            print(years)
            data = {'avg': avg}
            status = {'status': 'Created', 'status_message': 'Query was successful'}

            return {'data': data}, 200, {'status': status}

        else:
            data = {'auth': 0, 'description': 'user is not existed'}
            data = jsonify(data)
            return make_response(data, 404)


class test(Resource):
    def get(self):
        data = get_earliest_year(11)
        print(data)
        data = {'data':data}
        data = jsonify(data)
        return make_response(data, 200)


def existed(user_id):
    query = db.session.query(UserInfo.firstname, UserInfo.lastname, UserInfo.age, UserInfo.gender).filter(
        UserInfo.UID == user_id).all()
    return query


def get_credit_card_info(user_id):
    query = db.session.query(CreditCard.card_num, CreditCard.cvv, CreditCard.exp_date).filter(CreditCard.UID == user_id) \
        .all()

    return query


def get_transactions(user_id, year, month):
    query = db.session.query(TransactionInfo.UID, TransactionInfo.TID, TransactionInfo.T_date, TransactionInfo.T_time,
                             Company.company_name, Categories.categories, TransactionInfo.amount, TransType.trans_type). \
        filter(TransactionInfo.UID == user_id). \
        filter(db.extract('year', TransactionInfo.T_date) == year). \
        filter(db.extract('month', TransactionInfo.T_date) == month). \
        filter(TransactionInfo.campany_id == Company.company_id). \
        filter(TransactionInfo.categories_id == Categories.categories_id). \
        filter(TransactionInfo.type_id == TransType.type_id). \
        order_by(db.desc(TransactionInfo.T_date)).order_by(db.desc(TransactionInfo.T_time)).all()

    return query

def get_transactions_by_categ(user_id, year, month,categ_id):
    query = db.session.query(TransactionInfo.UID, TransactionInfo.TID, TransactionInfo.T_date, TransactionInfo.T_time,
                             Company.company_name, Categories.categories, TransactionInfo.amount, TransType.trans_type). \
        filter(TransactionInfo.UID == user_id). \
        filter(db.extract('year', TransactionInfo.T_date) == year). \
        filter(db.extract('month', TransactionInfo.T_date) == month). \
        filter(TransactionInfo.campany_id == Company.company_id). \
        filter(TransactionInfo.categories_id == Categories.categories_id). \
        filter(TransactionInfo.categories_id == categ_id). \
        filter(TransactionInfo.type_id == TransType.type_id). \
        order_by(db.desc(TransactionInfo.T_date)).order_by(db.desc(TransactionInfo.T_time)).all()

    return query

def get_recent_transactions(user_id, year, month):
    query = db.session.query(TransactionInfo.UID, TransactionInfo.TID, TransactionInfo.T_date, TransactionInfo.T_time,
                             Company.company_name, Categories.categories, TransactionInfo.amount, TransType.trans_type). \
        filter(TransactionInfo.UID == user_id). \
        filter(db.extract('year', TransactionInfo.T_date) == year). \
        filter(db.extract('month', TransactionInfo.T_date) == month). \
        filter(TransactionInfo.campany_id == Company.company_id). \
        filter(TransactionInfo.categories_id == Categories.categories_id). \
        filter(TransactionInfo.type_id == TransType.type_id). \
        order_by(db.desc(TransactionInfo.T_date)).order_by(db.desc(TransactionInfo.T_time)).limit(10).all()

    return query


def get_latest_month(user_id, year):
    query = db.session.query(TransactionInfo.T_date). \
        filter(TransactionInfo.UID == user_id). \
        filter(db.extract('year', TransactionInfo.T_date) == year). \
        order_by(db.desc(TransactionInfo.T_date)).first()

    return query


def get_latest_year(user_id):
    query = db.session.query(db.extract('year', TransactionInfo.T_date)). \
        filter(TransactionInfo.UID == user_id). \
        order_by(db.desc(TransactionInfo.T_date)).first()

    return query


def get_earliest_year(user_id,month):
    query = db.session.query(db.extract('year', TransactionInfo.T_date)). \
        filter(TransactionInfo.UID == user_id). \
            filter(db.extract('month', TransactionInfo.T_date) == month). \
        order_by(TransactionInfo.T_date).first()

    return query


def sum_monthly_exp(user_id,month):

    query = db.session.query(db.func.sum(TransactionInfo.amount)).\
                filter(db.extract('month',TransactionInfo.T_date) == month).\
                filter(TransactionInfo.UID == user_id).\
                group_by(db.extract('day',TransactionInfo.T_date)).all()
    return query

def ml_data(user_id):
    query = db.session.query(db.extract('year', TransactionInfo.T_date), db.extract('month', TransactionInfo.T_date),
                             db.func.sum(TransactionInfo.amount)). \
        group_by(db.extract('year', TransactionInfo.T_date),db.extract('month', TransactionInfo.T_date)).\
        filter(TransactionInfo.UID == user_id). \
        order_by(db.desc(TransactionInfo.T_date)).all()

    return query

def ml_data1(user_id):
    query = db.session.query(TransactionInfo.TID,TransactionInfo.amount,TransactionInfo.T_date).\
        filter(TransactionInfo.UID == user_id).all()

    return query