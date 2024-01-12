'''
Created on 22-Sep-2023

@author: rafeek
'''
print("my first python program")
fruits=("orange","banana","apple")
x=fruits
y=("mango",);
x +=tuple(y)
print(x)
y +=tuple(x)
print(y)
print(len(tuple(y))) 
'''
length of tuple
'''
print(type(tuple(y)))