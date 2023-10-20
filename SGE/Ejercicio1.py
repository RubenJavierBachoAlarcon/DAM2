X = [[1,2,3],
    [4,5,6],
    [7,8,9]]
Y = [[10,11,12],
    [13,14,15],
    [16,17,18]]
Z = [[0,0,0],
    [0,0,0],
    [0,0,0]]
for i in range(len(X)):
    for j in range(len(X[0])):
        for k in range(len(X)):
            Z[i][j] += X[i][k] * Y[k][j]

for r in Z:
    print(r)
    