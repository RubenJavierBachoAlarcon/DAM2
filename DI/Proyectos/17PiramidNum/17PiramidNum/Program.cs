using System;

class Program
{
    static void Main()
    {
        int n = 5; // Change the value of n to set the number of rows in the pyramid

        for (int i = 1; i <= n; i++)
        {
            // Print spaces before numbers
            for (int j = 1; j <= n - i; j++)
            {
                Console.Write("  ");
            }

            // Print increasing numbers
            for (int k = 1; k <= i; k++)
            {
                Console.Write(k + " ");
            }

            // Print decreasing numbers
            for (int l = i - 1; l >= 1; l--)
            {
                Console.Write(l + " ");
            }

            Console.WriteLine(); // Move to the next line for the next row
        }
    }
}
