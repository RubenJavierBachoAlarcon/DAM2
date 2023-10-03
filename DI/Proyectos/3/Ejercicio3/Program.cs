using System;

class Program
{
    static void Main()
    {
        int upperbound = 100;
        int sum = 0;
        int count = 0;

        // Using a for loop to sum numbers from 1 to upperbound
        for (int i = 1; i <= upperbound; i++)
        {
            sum += i;
            count++;
        }

        // Calculate and display the average
        double average = (double)sum / count;
        Console.WriteLine("The sum is " + sum);
        Console.WriteLine("The average is " + average);

        // Using a while loop to achieve the same result
        int sumWhile = 0;
        int countWhile = 0;
        int j = 1;
        while (j <= upperbound)
        {
            sumWhile += j;
            countWhile++;
            j++;
        }

        // Calculate and display the average for the while loop
        double averageWhile = (double)sumWhile / countWhile;
        Console.WriteLine("Using while loop - The sum is " + sumWhile);
        Console.WriteLine("Using while loop - The average is " + averageWhile);

        // Using a do-while loop to achieve the same result
        int sumDoWhile = 0;
        int countDoWhile = 0;
        int k = 1;
        do
        {
            sumDoWhile += k;
            countDoWhile++;
            k++;
        } while (k <= upperbound);

        // Calculate and display the average for the do-while loop
        double averageDoWhile = (double)sumDoWhile / countDoWhile;
        Console.WriteLine("Using do-while loop - The sum is " + sumDoWhile);
        Console.WriteLine("Using do-while loop - The average is " + averageDoWhile);

        // Sum only odd numbers and calculate the average
        int sumOdd = 0;
        int countOdd = 0;
        for (int n = 1; n <= upperbound; n++)
        {
            if (n % 2 != 0)
            {
                sumOdd += n;
                countOdd++;
            }
        }

        double averageOdd = (double)sumOdd / countOdd;
        Console.WriteLine("Sum of odd numbers - The sum is " + sumOdd);
        Console.WriteLine("Sum of odd numbers - The average is " + averageOdd);

        // Sum numbers divisible by 7 and calculate the average
        int sumDivisibleBy7 = 0;
        int countDivisibleBy7 = 0;
        for (int m = 1; m <= upperbound; m++)
        {
            if (m % 7 == 0)
            {
                sumDivisibleBy7 += m;
                countDivisibleBy7++;
            }
        }

        double averageDivisibleBy7 = (double)sumDivisibleBy7 / countDivisibleBy7;
        Console.WriteLine("Sum of numbers divisible by 7 - The sum is " + sumDivisibleBy7);
        Console.WriteLine("Sum of numbers divisible by 7 - The average is " + averageDivisibleBy7);

        // Sum of the squares of numbers from 1 to 100
        int sumOfSquares = 0;
        for (int x = 1; x <= upperbound; x++)
        {
            sumOfSquares += x * x;
        }

        Console.WriteLine("Sum of the squares - The sum is " + sumOfSquares);
    }
}
