#!/usr/bin/env python
# coding: utf-8

# In[287]:


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


# In[288]:


df = pd.read_csv('0001.csv', names = ['TransID', 'UserID', 'Amount', 'CategoryID', 'Date', 'Time', 'CompanyID', 'PaymentType'], skipinitialspace=True)


# In[289]:


df.shape


# In[290]:


df.head(5)


# In[291]:


#df=pd.DataFrame(data)


# In[292]:


print(df.tail(5))


# In[293]:


train = df[2000:]
test = df[0:2000]


# In[294]:


df.Timestamp = pd.to_datetime(df.Date, format = '%Y-%m-%d')


# In[295]:


df.index = df.Timestamp 


# In[296]:


df = df.resample('M').sum()


# In[297]:


df.head(12)


# In[298]:


train.Timestamp = pd.to_datetime(train.Date,format='%Y-%m-%d') 
train.index = train.Timestamp 
train = train.resample('M').sum() 
test.Timestamp = pd.to_datetime(test.Date,format='%Y-%m-%d') 
test.index = test.Timestamp 
test = test.resample('M').sum()


# In[299]:


train.Amount.plot(figsize=(18,8), title= 'Monthly Amount', fontsize=14)
test.Amount.plot(figsize=(18,8), title= 'Monthly Amount', fontsize=14)
plt.show()


# In[ ]:





# In[324]:


y_hat_avg = test.copy()
model = ExponentialSmoothing(np.asarray(train['Amount']) ,damped=0, seasonal_periods=12 ,trend='add', seasonal='add',).fit()
y_hat_avg['predict'] = model.forecast(len(test))
plt.figure(figsize=(16,8))
plt.plot( train['Amount'], label='Train')
plt.plot(test['Amount'], label='Test')
plt.plot(y_hat_avg['predict'], label='predict')
plt.legend(loc='best')
plt.show()


# In[ ]:





# In[301]:


#rms = sqrt(mean_squared_error(test.Amount, y_hat_avg.Holt_Winter))
#print(rms)
#RMSE = 23.9614925662


# In[316]:


model.predict()


# In[321]:


pred = model.forecast(12)
print(pred)


# In[ ]:


pred_imonth = input+1


# In[320]:


pred[pred_imonth]


# In[ ]:





# In[ ]:





# In[ ]:





# In[ ]:





# In[ ]:





# In[ ]:





# In[ ]:





# In[ ]:




