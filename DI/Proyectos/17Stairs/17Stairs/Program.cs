using System;

class StaircasePatterns
{
    static void Main()
    {
        int height = 5; // Adjust the height as needed

        Console.WriteLine("Upward Staircase:");
        PrintUpwardStaircase(height);

        Console.WriteLine("\nDownward Staircase:");
        PrintDownwardStaircase(height);

        Console.WriteLine("\nLeftward Staircase:");
        PrintLeftwardStaircase(height);

        Console.WriteLine("\nRightward Staircase:");
        PrintRightwardStaircase(height);
    }

    static void PrintUpwardStaircase(int height)
    {
        for (int i = 1; i <= height; i++)
        {
            for (int j = 0; j < i; j++)
            {
                Console.Write("* ");
            }
            Console.WriteLine();
        }
    }

    static void PrintDownwardStaircase(int height)
    {
        for (int i = height; i >= 1; i--)
        {
            for (int j = 0; j < i; j++)
            {
                Console.Write("* ");
            }
            Console.WriteLine();
        }
    }

    static void PrintLeftwardStaircase(int height)
    {
        for (int i = 1; i <= height; i++)
        {
            for (int j = height; j > i; j--)
            {
                Console.Write("  ");
            }
            for (int k = 0; k < i; k++)
            {
                Console.Write("* ");
            }
            Console.WriteLine();
        }
    }

    static void PrintRightwardStaircase(int height)
    {
        for (int i = 1; i <= height; i++)
        {
            for (int j = 0; j < i - 1; j++)
            {
                Console.Write("  ");
            }
            for (int k = i; k <= height; k++)
            {
                Console.Write("* ");
            }
            Console.WriteLine();
        }
    }
}
