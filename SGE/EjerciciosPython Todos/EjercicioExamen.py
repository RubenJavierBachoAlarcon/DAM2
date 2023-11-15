import random

array1 = [0,0,0,0,0]
array2 = [0,0,0,0,0]
array3 = [0,0,0,0,0]

bingo = [[0,0,0,0,0],
         [0,0,0,0,0],
         [0,0,0,0,0]]

for i in range(0,5):
        aleatorio = random.randrange(0,91)
    
        array1[i] = aleatorio
maximoActual = max(array1)

for i in range(0,5):
        aleatorio = random.randrange(maximoActual,91)
        
        array2[i] = aleatorio
maximoActual = max(array2)

for i in range(0,5):
        aleatorio = random.randrange(maximoActual,91)
        if (i == aleatorio for i in array3 ):
                print("asdd")
        array3[i] = aleatorio

array1 = sorted(array1)
array2 = sorted(array2)
array3 = sorted(array3)

bingo = [array1,array2,array3]
print(bingo)
