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
resultIndex = []
resultBoard = []

for sh in range(5,len(shots)):
    for dat in range(0,len(data),5):     
        rowWin = 0
        columnWin = 0  
        for i in range(5):
            if rowWin == 5 or columnWin == 5:
                break
            rowWin = 0
            columnWin = 0
            for j in range(5):

                if data[dat + i][j] in shots[0:sh]:
                    rowWin += 1
                    if rowWin == 5 and dat not in resultBoard:
                        resultIndex.append(sh) 
                        resultBoard.append(dat)
                        break
                        

                if data[dat + j][i] in shots[0:sh]:
                    columnWin += 1
                    if columnWin == 5 and dat not in resultBoard:
                        resultIndex.append(sh)
                        resultBoard.append(dat)
                        break

sum = [0 for _ in range(len(resultBoard))]

for x in range(len(resultBoard)):
    for i in range(resultBoard[x], resultBoard[x] + 5):
        for j in range(5):         
            if  data[i][j] in shots[0:resultIndex[x]]:
                data[i][j] = 0
            sum[x] += int(data[i][j])
            
for i,j in enumerate(sum):
    sum[i] *= int(shots[resultIndex[i]-1])

result = resultIndex.index(max(resultIndex))

print(sum[result])



    