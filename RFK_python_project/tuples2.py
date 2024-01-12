'''
Created on 22-Sep-2023

@author: rafeek
'''
animal=("dog","horse","panda")
# print animal with index
print(animal[1])
print(animal[-1])
pet=list(animal)
pet[1]="cat"
# replace horse to cat
animal=tuple(pet) 
print(animal)
wild=list(animal)
# append tiger to animal tuple
wild.append("tiger")
wild.append("bear")
wild.append("deer")
animal=tuple(wild)
print(animal)
# print range of element in forward direction
print(animal[2:5])
# print range of element in backward direction
print (animal[-5:-1])
print(animal[:4])
print(animal[1:])
print(animal[:-2])
print(animal[-3:])