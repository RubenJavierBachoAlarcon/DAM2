using System;

class Program
{
    static void Main()
    {
        Console.Write("Enter the first positive integer (a): ");
        if (int.TryParse(Console.ReadLine(), out int a) && a > 0)
        {
            Console.Write("Enter the second positive integer (b): ");
            if (int.TryParse(Console.ReadLine(), out int b) && b > 0)
            {
                int gcd = FindGCD(a, b);
                Console.WriteLine($"GCD({a}, {b}) = {gcd}");
            }
            else
            {
                Console.WriteLine("Invalid input for the second integer.");
            }
        }
        else
        {
            Console.WriteLine("Invalid input for the first integer.");
        }
    }

    static int FindGCD(int a, int b)
    {
        if (b == 0)
        {
            return a;
        }
        else
        {
            return FindGCD(b, a % b);
        }
    }
}
