def ordenarMatrizPorFile(matriz):
    for i in range(len(matriz)):
        for j in range(len(matriz[0])):
            for k in range(len(matriz[0])-1):
                if matriz[i][k] > matriz[i][k+1]:
                    aux = matriz[i][k]
                    matriz[i][k] = matriz[i][k+1]
                    matriz[i][k+1] = aux
    return matriz


x = [[2,3,4,1,4],
     [1,2,3,4,5],
    [2,3,4,5,6],
    [3,4,5,6,7],
    [4,5,6,7,8]]

vector = [3,4,3,2,1,4,2,3,2,1]

repeticiones = [[0 for _ in range(5)] for _ in range(5)]

for i in range(len(x)):
    for j in range(len(x[0])):
        numero = x[i][j]
        for k in range(len(vector)):    
            if numero == vector[k]: 
                repeticiones[i][j] += 1
                
repeticiones = ordenarMatrizPorFile(repeticiones)
for i in repeticiones:
    print(i)
    
