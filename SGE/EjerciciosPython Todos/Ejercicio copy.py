cadena = "anita lava la tina"

cadenaTrim = cadena.replace(" ", "").lower()
cadenaReverse = cadenaTrim[::-1]
print(cadenaTrim)
print(cadenaReverse)

if (cadenaTrim == cadenaReverse):
    print("palindromo")
else:
    print("No es palindromo")