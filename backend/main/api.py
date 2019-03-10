from flask import jsonify, make_response
from flask_restful import reqparse, Resource
from datetime import datetime
from .model import *


home = reqparse.RequestParser()
detail = reqparse.RequestParser()


class Home(Resource):
    def get(self, UID):
        home.add_argument('year', required=False, help='transactions for particular year, default is latest year',
                          default=2018)
        home.add_argument('month', required=False, help='transaction for particular month, default is latest month')

        args = home.parse_args()
        year = args['year']
        month = args['month']


        if existed(UID):
            if month:
                data = homeget_month(UID, year, month)
            else:
                month = int(str(homeget_latestMonth(UID, year)).split(sep='-')[1])
                data = homeget_month(UID, year, month)

            result = {}
            for i in data:
                TID = i[1]
                result[TID] = {'UID': i[0], 'date': i[2], 'time': i[3], 'company': i[4], 'category': i[5],
                               'amount': i[6]}

            result = jsonify(result)
            return make_response(result, 200)
            # return data
        else:
            data = jsonify({'auth': 0, 'description': 'user not existed'})
            return make_response(data, 404)

    def post(self, UID):
        if existed(UID):
            year = 2018
            yearData = homeget(UID, year)
            yearExpense = 0
            month = int(str(homeget_latestMonth(UID, year)).split(sep='-')[1])
            monthData = homeget_month(UID, year, month)
            monthExpense = 0
            categoryYearRatio = {}
            recentTrans = {}
            recentTransflag = 0
            monthTrans = {}
            Education = 0
            HealthCare = 0
            Apparel = 0
            Transportation = 0
            Entertainment = 0
            Insurance = 0
            Housing = 0
            Groceries = 0
            Food = 0
            currentTime = datetime.now()

            for i in yearData:
                if recentTransflag != 10:
                    TID = i[1]
                    recentTrans[TID] = {'date': i[2], 'time': i[3], 'company': i[4], 'amount': i[6]}
                    recentTransflag += 1
                yearExpense += i[6]

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

            categoryYearRatio['Education'] = int(Education/yearExpense*100)
            categoryYearRatio['HealthCare'] = int(HealthCare/yearExpense*100)
            categoryYearRatio['Apparel'] = int(Apparel/yearExpense*100)
            categoryYearRatio['Transportation'] = int(Transportation/yearExpense*100)
            categoryYearRatio['Entertainment'] = int(Entertainment/yearExpense*100)
            categoryYearRatio['Insurance'] = int(Insurance/yearExpense*100)
            categoryYearRatio['Housing'] = int(Housing/yearExpense*100)
            categoryYearRatio['Groceries'] = int(Groceries/yearExpense*100)
            categoryYearRatio['Food'] = int(Food/yearExpense*100)

            for i in monthData:
                monthExpense += i[6]
                TID = i[1]
                monthTrans[TID] = {'UID': i[0], 'date': i[2], 'time': i[3], 'company': i[4], 'category': i[5],
                                   'amount': i[6]}



            result = {'monthTrans': monthTrans, 'yearExpense': round(yearExpense, 2), "recentTrans": recentTrans,
                      'monthExpense': round(monthExpense, 2), 'categoryRatio': categoryYearRatio,
                      'currentTime':currentTime}

            return make_response(jsonify(result), 200)

        else:
            data = jsonify({'auth': 0, 'description': 'user not existed'})
            return make_response(data, 404)


class Detail(Resource):

    def get(self, UID):
        detail.add_argument('year', required=False, help='transactions for particular year, default is latest year',
                          default=2018)
        detail.add_argument('month', required=False, help='transaction for particular month, default is latest month')

        args = detail.parse_args()
        year = args['year']
        month = args['month']



        if existed(UID):
            if month:
                data = homeget_month(UID, year, month)
            else:
                month = int(str(homeget_latestMonth(UID, year)).split(sep='-')[1])
                data = homeget_month(UID, year, month)

            result = {}
            for i in data:
                TID = i[1]
                result[TID] = {'UID': i[0], 'date': i[2], 'time': i[3], 'company': i[4], 'category': i[5],
                               'amount': i[6]}

            result = jsonify(result)
            return make_response(result, 200)
            # return data
        else:
            data = jsonify({'auth': 0, 'description': 'user not existed'})
            return make_response(data, 404)

    def post(self, UID):
        currentTime = datetime.now()
        if existed(UID):
            year = 2018
            yearData = homeget(UID, year)
            yearExpense = 0
            month = int(str(homeget_latestMonth(UID, year)).split(sep='-')[1])
            monthData = homeget_month(UID, year, month)
            monthExpense = 0
            categoryYearRatio = {}
            recentTrans = {}
            recentTransflag = 0
            monthTrans = {}
            Education = 0
            HealthCare = 0
            Apparel = 0
            Transportation = 0
            Entertainment = 0
            Insurance = 0
            Housing = 0
            Groceries = 0
            Food = 0

            for i in yearData:
                if recentTransflag != 10:
                    TID = i[1]
                    recentTrans[TID] = {'date': i[2], 'time': i[3], 'company': i[4], 'amount': i[6]}
                    recentTransflag += 1
                yearExpense += i[6]

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

            categoryYearRatio['Education'] = int(Education / yearExpense * 100)
            categoryYearRatio['HealthCare'] = int(HealthCare / yearExpense * 100)
            categoryYearRatio['Apparel'] = int(Apparel / yearExpense * 100)
            categoryYearRatio['Transportation'] = int(Transportation / yearExpense * 100)
            categoryYearRatio['Entertainment'] = int(Entertainment / yearExpense * 100)
            categoryYearRatio['Insurance'] = int(Insurance / yearExpense * 100)
            categoryYearRatio['Housing'] = int(Housing / yearExpense * 100)
            categoryYearRatio['Groceries'] = int(Groceries / yearExpense * 100)
            categoryYearRatio['Food'] = int(Food / yearExpense * 100)

            for i in monthData:
                monthExpense += i[6]
                TID = i[1]
                monthTrans[TID] = {'UID': i[0], 'date': i[2], 'time': i[3], 'company': i[4], 'category': i[5],
                                   'amount': i[6]}

            result = {'monthTrans': monthTrans, 'yearExpense': round(yearExpense, 2), "recentTrans": recentTrans,
                      'monthExpense': round(monthExpense, 2), 'categoryRatio': categoryYearRatio,
                      'currentTime':currentTime}

            return make_response(jsonify(result), 200)

        else:
            data = jsonify({'auth': 0, 'description': 'user not existed'})
            return make_response(data, 404)


"""
some tools
"""


def existed(user_id):
    query = UserInfo.query.filter_by(UID=user_id).all()
    if query:
        return True
    else:
        return False


def homeget(user_id, year):
    query = db.session.query(TransactionInfo.UID, TransactionInfo.TID, TransactionInfo.T_date, TransactionInfo.T_time,
                             Company.company_name, Categories.categories, TransactionInfo.amount). \
        filter(TransactionInfo.UID == user_id). \
        filter(db.extract('year', TransactionInfo.T_date) == year). \
        filter(TransactionInfo.campany_id == Company.company_id). \
        filter(TransactionInfo.categories_id == Categories.categories_id). \
        order_by(db.desc(TransactionInfo.T_date)).order_by(db.desc(TransactionInfo.T_time)).all()

    return query


def homeget_month(user_id, year, month):
    query = db.session.query(TransactionInfo.UID, TransactionInfo.TID, TransactionInfo.T_date, TransactionInfo.T_time,
                             Company.company_name, Categories.categories, TransactionInfo.amount). \
        filter(TransactionInfo.UID == user_id). \
        filter(db.extract('year', TransactionInfo.T_date) == year). \
        filter(db.extract('month', TransactionInfo.T_date) == month). \
        filter(TransactionInfo.campany_id == Company.company_id). \
        filter(TransactionInfo.categories_id == Categories.categories_id). \
        order_by(db.desc(TransactionInfo.T_date)).order_by(db.desc(TransactionInfo.T_time)).all()

    return query


def homeget_latestMonth(user_id, year):
    query = db.session.query(TransactionInfo.T_date). \
        filter(TransactionInfo.UID == user_id). \
        filter(db.extract('year', TransactionInfo.T_date) == year). \
        order_by(db.desc(TransactionInfo.T_date)).first()

    return query


def category():
    query = db.session.query(Categories.categories).all()

    return query


