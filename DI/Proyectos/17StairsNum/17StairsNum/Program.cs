using System;

class NumberStaircasePatterns
{
    static void Main()
    {
        int height = 5; // Adjust the height as needed

        Console.WriteLine("First Staircase:");
        PrintFirstStaircase(height);

        Console.WriteLine("\nSecond Staircase:");
        PrintSecondStaircase(height);

        Console.WriteLine("\nThird Staircase:");
        PrintThirdStaircase(height);

        Console.WriteLine("\nFourth Staircase:");
        PrintFourthStaircase(height);
    }

    static void PrintFirstStaircase(int height)
    {
        for (int i = 1; i <= height; i++)
        {
            for (int j = 1; j <= i; j++)
            {
                Console.Write(j);
            }
            Console.WriteLine();
        }
    }

    static void PrintSecondStaircase(int height)
    {
        for (int i = 1; i <= height; i++)
        {
            for (int j = height - i + 1; j >= 1; j--)
            {
                Console.Write(j);
            }
            Console.WriteLine();
        }
    }

    static void PrintThirdStaircase(int height)
{
    for (int i = 1; i <= height; i++)
    {
        // Print spaces
        for (int j = 1; j <= height - i; j++)
        {
            Console.Write("  ");
        }

        // Print numbers in descending order
        for (int k = i; k >= 1; k--)
        {
            Console.Write(k);
            if (k != 1)
            {
                Console.Write(" ");
            }
        }

        Console.WriteLine();
    }
}


    static void PrintFourthStaircase(int height)
    {
        for (int i = 1; i <= height; i++)
        {
            for (int j = 1; j <= i - 1; j++)
            {
                Console.Write(" ");
            }
            for (int k = 1; k <= height - i + 1; k++)
            {
                Console.Write(k);
            }
            Console.WriteLine();
        }
    }
}
