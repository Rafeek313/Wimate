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
# remove elements from tuple
dead=list(animal)
dead.remove("deer")
animal=tuple(dead)
print(animal)
# delete complete tuple
del animal
# print(animal) this will raise an error because the tuple no longer exists
# unpacking tuple
animal=("cat","pigeon","tiger")
(pet,bird,wild)=animal
print(pet)
print(bird)
print(wild)