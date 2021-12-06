file = open("data.txt","r")

data = []

for line in file:
    data = line.split(",")

echstadium = []
stadium = [] 
for i in range(9):
    echstadium.append(data.count(str(i)))


for days in range(256):    
    tmp = 0 
    for i in range(9):
        if (8-i) == 0:
            echstadium[6] += echstadium[0]
            echstadium[8] += echstadium[0]
            tmp,echstadium[0] = echstadium[0],tmp
        else:
            tmp,echstadium[8-i] = echstadium[8-i],tmp


print(sum(echstadium))