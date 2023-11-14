cadena = "anita lava la tina"

cadenaTrim = cadena.replace(" ", "").lower()
cadenaReverse = cadenaTrim[::-1]
print(cadenaTrim)
print(cadenaReverse)

if (cadenaTrim == cadenaReverse):
    print(f"palindromo {cadenaTrim} y {cadenaReverse}")
else:
    print("No es palindromo")

n=4
print(f"{'Número':<8}{'Cuadrado':<8}{'Cubo':<8}")