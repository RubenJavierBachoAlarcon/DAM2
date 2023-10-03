using System;
using System.Threading;

class Program
{
    static void Main()
    {
        // Create a 7x7 matrix
        Matrix.Matrix matrix = new Matrix.Matrix(20);

        // Fill the matrix and place initial characters (Neo and Smith)
        matrix.fillMatrix();

        // Print the initial matrix
        matrix.printMatrix();

        // Print Neo's initial position
        Console.WriteLine("Initial position of Neo:");
        Console.WriteLine("X: " + matrix.neo.x);
        Console.WriteLine("Y: " + matrix.neo.y);

        // Print the number of initial characters
        Console.WriteLine("Number of initial characters: " + matrix.chars.Count);

        // Print the death probability at position (2,2)
        Console.WriteLine("Death probability at (2,2): " + matrix.matrixChar[2, 2].probDeath);

        // Simulate events
        for (int seconds = 1; seconds <= 25; seconds++)
        {
            Console.WriteLine("\nSecond " + seconds);

            // Evaluate the death probability and replace characters
            matrix.charActs();

            if (matrix.OnlySmithNeoMatrix())
            {
                Console.WriteLine("Only Neo and Smith left");
                Environment.Exit(0);
            }

            if (seconds % 2 == 0)
            {
                // Smith acts every two seconds
                matrix.smithActs();

                if (matrix.OnlySmithNeoMatrix())
                {
                    Console.WriteLine("Only Neo and Smith left");
                    Environment.Exit(0);
                }
            }

            if (seconds % 5 == 0)
            {
                // Neo acts every five seconds
                matrix.neoActs();
            }

            // Print the matrix after each second
            matrix.printMatrix();

            // Check if the simulation should end
            if (matrix.chars.Count <= 2)
            {
                Console.WriteLine("The simulation has ended.");
                break;
            }

            // Pause for one second (1000 milliseconds)
            Thread.Sleep(1000);
        }

        // Print the number of remaining characters at the end of the simulation
        Console.WriteLine("Number of remaining characters: " + matrix.chars.Count);
    }
}
