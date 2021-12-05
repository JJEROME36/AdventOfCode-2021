file = open("data.txt",'r')

data = []
shots = [] 
for line  in file:
    x = line.replace(',',' ').split()
    if x != []:
        data.append(x)

shots = data[0]
del data[0]
rowWin = 0
columnWin = 0
index = 0
boardIndex = 0

for sh in range(5,len(shots)):

    for dat in range(0,len(data),5):            
       
        for i in range(5):
            if rowWin == 5 or columnWin == 5:
                break
            rowWin = 0
            columnWin = 0
            for j in range(5):

                if data[dat + i][j] in shots[0:sh]:
                    rowWin += 1
                    if rowWin == 5:
                        index = sh 
                        boardIndex = dat
                        break

                if data[dat + j][i] in shots[0:sh]:
                    columnWin += 1
                    if columnWin == 5:
                        index = sh 
                        boardIndex = dat
                        break

    

sum = 0
for i in range(boardIndex, boardIndex + 5):
    for j in range(5):
       
       if  data[i][j] in shots[0:index]:
           data[i][j] = 0
       sum += int(data[i][j])

print(sum*int(shots[index-1]))          

    



