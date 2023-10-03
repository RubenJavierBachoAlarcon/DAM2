using System;
using System.Threading;

class Program
{
    static void Main()
    {
        // Crear una matriz de 7x7
        Matrix.Matrix matrix = new Matrix.Matrix(9);

        

        // Llenar la matriz y colocar personajes iniciales (Neo y Smith)
        matrix.fillMatrix();

        // Imprimir la matriz inicial
        matrix.printMatrix();

        // Imprimir la posición inicial de Neo
        Console.WriteLine("Posición inicial de Neo:");
        Console.WriteLine("X: " + matrix.neo.x);
        Console.WriteLine("Y: " + matrix.neo.y);

        // Imprimir la cantidad de personajes iniciales
        Console.WriteLine("Cantidad de personajes iniciales: " + matrix.chars.Count);

        // Imprimir la probabilidad de muerte en la posición (2,2)
        Console.WriteLine("Probabilidad de muerte en (2,2): " + matrix.matrixChar[2, 2].probDeath);

        // Simular eventos
        for (int seconds = 1; seconds <= 25; seconds++)
        {
            Console.WriteLine("\nSegundo " + seconds);

            // Evaluar la probabilidad de muerte y reemplazar personajes
            matrix.charActs();

            if (seconds % 2 == 0)
            {
                // Smith actúa cada dos segundos
                matrix.smithActs();
            }

            if (seconds % 5 == 0)
            {
                // Neo actúa cada cinco segundos
                matrix.neoActs();
            }

            // Imprimir la matriz después de cada segundo
            matrix.printMatrix();

            // Verificar si la simulación debe terminar
            if (matrix.chars.Count <= 2)
            {
                Console.WriteLine("La simulación ha terminado.");
                break;
            }

            // Pausa de un segundo (1000 milisegundos)
            
        }

        // Imprimir la cantidad de personajes restantes al final de la simulación
        Console.WriteLine("Cantidad de personajes restantes: " + matrix.chars.Count);
    }
}
