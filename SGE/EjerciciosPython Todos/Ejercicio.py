arrayNum = [1,2,3,4,3,2,1,0]

mitad = len(arrayNum) // 2 - 1

isCreciente = all(arrayNum[i] < arrayNum[i+1] for i in range(0, mitad))
print(isCreciente)

isDecreciente = all(arrayNum[i] > arrayNum[i+1] for i in range(mitad + 1, len(arrayNum) - 1))
print(isDecreciente)

if (isCreciente and isDecreciente):
    print("Es monte")
else:
    print("No es monte")