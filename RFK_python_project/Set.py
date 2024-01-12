'''
Created on 25-Sep-2023

@author: rafeek
'''
# Sets are written with curly brackets.
#set is unorder
animals={"dog","cat","tiger"}
print(animals)
#set doesnot allows duplicate
animals1={"dog","cat","lion","dog"}
print(animals1)
#The values True and 1 are considered the same value in sets, and are treated as duplicates:
animals2={"dog","cat","lion","dog",True,1,2}
print(animals2)
#length
print(len(animals2))
#for set
pets={"cat","parrot","pigeon","dog","pig"}
# print("pigeon" is pets)
print(len(pets))
for pet in pets:
    if pet == 3:
        break
    print(pet)
    continue
fruits={"apple","orange","musambi"}
fruits.add("pomogranete")
print(fruits)