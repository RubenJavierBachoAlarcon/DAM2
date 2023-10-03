using System;

class Program
{
    static void Main()
    {
        int height = 5; // You can change the height as needed
        int width = 10; // You can change the width as needed

        for (int i = height; i >= 1; i--)
        {
            // First inverse staircase with numbers
            for (int j = 1; j <= i; j++)
            {
                Console.Write(j);
            }

            // Space between the two stairs
            for (int j = 1; j <= width - 2 * i; j++)
            {
                Console.Write(" ");
            }

            // Second inverse staircase with numbers
            for (int j = 1; j <= i; j++)
            {
                Console.Write(j);
            }

            Console.WriteLine();
        }

        Console.ReadLine(); // Pause to see the result
    }
}
