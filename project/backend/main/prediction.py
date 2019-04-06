#!/usr/bin/env python
# coding: utf-8

# In[ ]:


# input: lst, a python list of data
# input: month_pred, rth of the month needs to be predicted
# return: rtn, # of amount spent on the predicted month


def prediction(lst, month_pred):
    import numpy as np
    import pandas as pd
    import math
    from sklearn.model_selection import train_test_split
    from sklearn.model_selection import cross_val_score
    from sklearn.neighbors import KNeighborsClassifier
    from sklearn.linear_model import LinearRegression
    import matplotlib.pyplot as plt
    from statsmodels.tsa.api import ExponentialSmoothing
    from sklearn.metrics import mean_squared_error
    from math import sqrt

    df = pd.DataFrame(lst, columns=['year', 'month', 'amount'])

    years = lst[0][0] - lst[len(lst) - 1][0] + 1

    i = int(len(df) / years)

    df['year'] = df['year'].map(lambda x: str(x))

    df['month'] = df['month'].map(lambda x: str(x))

    df['year'] = df['year'].str.cat(df['month'], sep='-')

    df.columns = ['Date', 'month', 'amount']

    train = df[i:]
    test = df[0:i]

    df.Timestamp = pd.to_datetime(df.Date, format='%Y-%m')

    df.index = df.Timestamp

    df = df.resample('M').sum()

    train.Timestamp = pd.to_datetime(train.Date, format='%Y-%m-%d')
    train.index = train.Timestamp
    train = train.resample('M').sum()
    test.Timestamp = pd.to_datetime(test.Date, format='%Y-%m-%d')
    test.index = test.Timestamp
    test = test.resample('M').sum()

    #train.amount.plot(figsize=(18, 8), title='Monthly Amount', fontsize=14)
    #test.amount.plot(figsize=(18, 8), title='Monthly Amount', fontsize=14)
    #plt.show()

    y_hat_avg = test.copy()
    model = ExponentialSmoothing(np.asarray(train['amount']), damped=0, seasonal_periods=12, trend='add',
                                 seasonal='add', ).fit()
    y_hat_avg['predict'] = model.forecast(len(test))

    #plt.figure(figsize=(16, 8))
    #plt.plot(train['amount'], label='Train')
    #plt.plot(test['amount'], label='Test')
    #plt.plot(y_hat_avg['predict'], label='predict')
    #plt.legend(loc='best')
    #plt.show()
    
    pred = model.forecast(12)

    pred_imonth = int(month_pred) - 1

    rtn = pred[pred_imonth]

    return rtn
