using System;

class Program
{
    static void Main()
    {
        Console.Write("Enter the upper bound: ");
        if (int.TryParse(Console.ReadLine(), out int upperBound) && upperBound > 0)
        {
            Console.WriteLine("These numbers are perfect:");
            int perfectCount = 0;

            for (int i = 2; i <= upperBound; i++)
            {
                if (IsPerfectNumber(i))
                {
                    Console.Write($"{i} ");
                    perfectCount++;
                }
            }

            Console.WriteLine($"\n[{perfectCount} perfect numbers found ({((double)perfectCount / upperBound * 100):F2}%)]\n");

            Console.WriteLine("These numbers are neither deficient nor perfect:");
            int neitherCount = 0;

            for (int i = 2; i <= upperBound; i++)
            {
                if (!IsPerfectNumber(i) && !IsDeficientNumber(i))
                {
                    Console.Write($"{i} ");
                    neitherCount++;
                }
            }

            Console.WriteLine($"\n[{neitherCount} numbers found ({((double)neitherCount / upperBound * 100):F2}%)]");
        }
        else
        {
            Console.WriteLine("Invalid input. Please enter a positive integer.");
        }
    }

    static bool IsPerfectNumber(int num)
    {
        int sum = 1;
        for (int i = 2; i * i <= num; i++)
        {
            if (num % i == 0)
            {
                sum += i;
                if (i != num / i)
                {
                    sum += num / i;
                }
            }
        }
        return sum == num;
    }

    static bool IsDeficientNumber(int num)
    {
        int sum = 1;
        for (int i = 2; i * i <= num; i++)
        {
            if (num % i == 0)
            {
                sum += i;
                if (i != num / i)
                {
                    sum += num / i;
                }
            }
        }
        return sum < num;
    }
}
