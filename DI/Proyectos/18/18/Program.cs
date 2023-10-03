using System;

class TrigonometricSeries
{
    public static double ComputeSin(double x, int n)
    {
        double result = 0;
        for (int i = 0; i < n; i++)
        {
            int exponent = 2 * i + 1;
            double term = Math.Pow(-1, i) * Math.Pow(x, exponent) / Factorial(exponent);
            result += term;
        }
        return result;
    }

    public static double ComputeCos(double x, int n)
    {
        double result = 0;
        for (int i = 0; i < n; i++)
        {
            int exponent = 2 * i;
            double term = Math.Pow(-1, i) * Math.Pow(x, exponent) / Factorial(exponent);
            result += term;
        }
        return result;
    }

    private static double Factorial(int n)
    {
        if (n == 0)
            return 1;
        double result = 1;
        for (int i = 1; i <= n; i++)
        {
            result *= i;
        }
        return result;
    }

    static void Main()
    {
        double x = Math.PI / 4; // Replace with the desired angle in radians
        int n = 10; // Number of terms in the series, you can adjust this

        double sinValue = ComputeSin(x, n);
        double cosValue = ComputeCos(x, n);

        Console.WriteLine($"sin({x}) = {sinValue}");
        Console.WriteLine($"cos({x}) = {cosValue}");
    }
}
