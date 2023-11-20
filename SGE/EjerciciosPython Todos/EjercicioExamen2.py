import random 

bingo = [[0,0,0,0,0],
         [0,0,0,0,0],
         [0,0,0,0,0]]

for i in range(0,3):
    for j in range(0,5):
        for k in range(0,91):
            aleatorio = random.randrange(0,91)
            if (aleatorio == bingo[i][j]):
                print("contiene")
            else:
                bingo[i][j] = aleatorio
        
bingo = sorted(bingo)
print("Bingo ordenado de menor a mayor sin repetidos (Num entre 1 y 90)")
print(bingo)
