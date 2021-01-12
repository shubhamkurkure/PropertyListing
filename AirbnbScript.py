#!/usr/bin/env python
# coding: utf-8

# In[1]:


import pandas as pd
import pymysql
import warnings
warnings.filterwarnings('ignore')

df = pd.read_csv("listings.csv")
df = df.where((pd.notnull(df)), None)

#Removed unnecessary Property Type
filter = ['Apartment', 'Bed & Breakfast', 'Boat', 'Camper/RV', 'Dorm', 'Guesthouse', 'Other', 'Condominium' ,'House']
df = df.query('property_type not in @filter')

df.insert(0, 'ID', range(1, 1 + len(df)))

#Modified Data 
df.loc[df['property_type'] == 'Entire Floor', 'property_type'] = 1
df.loc[df['property_type'] == 'Loft', 'property_type'] = 2
df.loc[df['property_type'] == 'Townhouse', 'property_type'] = 3
df.loc[df['property_type'] == 'Villa', 'property_type'] = 4
df.loc[df['host_is_superhost'] == 'f', 'host_is_superhost'] = 0
df.loc[df['host_is_superhost'] == 't', 'host_is_superhost'] = 1
df.loc[df['host_identity_verified'] == 'f', 'host_identity_verified'] = 0
df.loc[df['host_identity_verified'] == 't', 'host_identity_verified'] = 1

#Changed Price to removed dollar sign and decimal values
df['price'].astype(str) 
df['price'] = df['price'].str[1:-3]

# Connect to the database
connection = pymysql.connect(host='cs5200-spring2020-shubhamkurkure.cqj4ratuso1k.us-east-1.rds.amazonaws.com', user='shubhamkurkure', password='Friends123',db='cs5200_project')

# create cursor
cursor=connection.cursor()

temp_df =  df.drop_duplicates(subset="host_id")


#create person
for i in df.itertuples():
    sql = "INSERT IGNORE INTO person (id, first_name, email) VALUES (%s, %s, %s)"
    values = (i.host_id, i.host_name, i.host_name+"@gmail.com")
    cursor.execute(sql, values)
    connection.commit()
   
#create login
for i in temp_df.itertuples():
    sql = "INSERT INTO login (username, password, person_id) VALUES (%s, %s, %s)"
    values = (i.host_name, i.host_name, i.host_id)
    cursor.execute(sql, values)
    connection.commit()
    
    
#create host
for i in temp_df.itertuples():
    sql = "INSERT INTO hosts (id, superhost) VALUES (%s, %s)"
    values = (i.host_id, i.host_is_superhost)
    cursor.execute(sql, values)
    connection.commit()

#create property
for i in df.itertuples():
    sql = "INSERT INTO properties (price, name, property_type_id,  no_of_rooms, verified, max_no_of_person, description, host_id) VALUES (%s, %s, %s, %s, %s, %s, %s, %s)"
    values = (i.price, i.name, i.property_type, i.bedrooms, i.host_identity_verified,i.accommodates ,i.description ,i.host_id)
    cursor.execute(sql, values)
    connection.commit()

#insert images
for i in df.itertuples():
    sql = "INSERT INTO images (url, property_id) VALUES (%s, %s)"
    values = (i.picture_url, i.ID)
    cursor.execute(sql, values)
    connection.commit()
    
#insert address
for i in df.itertuples():
    sql = "INSERT INTO property_address (latitude, longitude, city, state, country, address, property_id) VALUES (%s, %s, %s, %s, %s, %s, %s)"
    values = (i.latitude, i.longitude, i.city, i.state, i.country, i.street, i.ID)
    cursor.execute(sql, values)
    connection.commit()

#insert availability
for i in df.itertuples():
    sql = "INSERT INTO availabilities (d_from, d_to , property_id) VALUES (%s, %s, %s)"
    values = ("2020-04-12" , "2020-12-12", i.ID)
    cursor.execute(sql, values)
    connection.commit()


# In[173]:




