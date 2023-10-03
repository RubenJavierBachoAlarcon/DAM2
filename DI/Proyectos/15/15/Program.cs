using System;

class Program
{
    static void Main()
    {
        Console.Write("Enter the number of students: ");
        if (int.TryParse(Console.ReadLine(), out int n) && n > 0)
        {
            int[] grades = new int[n];

            for (int i = 0; i < n; i++)
            {
                Console.Write($"Enter the grade for student {i + 1}: ");
                if (int.TryParse(Console.ReadLine(), out int grade) && grade >= 0 && grade <= 100)
                {
                    grades[i] = grade;
                }
                else
                {
                    Console.WriteLine("Invalid input for grade. Please enter a valid integer between 0 and 100.");
                    i--;
                }
            }

            double average = CalculateAverage(grades);
            int minimum = CalculateMinimum(grades);
            int maximum = CalculateMaximum(grades);
            double standardDeviation = CalculateStandardDeviation(grades, average);

            Console.WriteLine($"The average is {average:F2}");
            Console.WriteLine($"The minimum is {minimum}");
            Console.WriteLine($"The maximum is {maximum}");
            Console.WriteLine($"The standard deviation is {standardDeviation:F14}");
        }
        else
        {
            Console.WriteLine("Invalid input for the number of students. Please enter a positive integer.");
        }
    }

    static double CalculateAverage(int[] grades)
    {
        int sum = 0;
        foreach (int grade in grades)
        {
            sum += grade;
        }
        return (double)sum / grades.Length;
    }

    static int CalculateMinimum(int[] grades)
    {
        int min = grades[0];
        foreach (int grade in grades)
        {
            if (grade < min)
            {
                min = grade;
            }
        }
        return min;
    }

    static int CalculateMaximum(int[] grades)
    {
        int max = grades[0];
        foreach (int grade in grades)
        {
            if (grade > max)
            {
                max = grade;
            }
        }
        return max;
    }

    static double CalculateStandardDeviation(int[] grades, double average)
    {
        double sumSquaredDifferences = 0;
        foreach (int grade in grades)
        {
            double difference = grade - average;
            sumSquaredDifferences += difference * difference;
        }
        double variance = sumSquaredDifferences / grades.Length;
        return Math.Sqrt(variance);
    }
}
