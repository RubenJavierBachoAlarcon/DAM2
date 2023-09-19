public class Ejercicio4
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());
        double sum1 = 0;
        double sum2 = 0;
        for (int i = 1; i <= n; i++)
        {
            sum1 += 1.0 / (double)i;
        }

        for (int i = n; i > 0; i--)
        {
            sum2 += 1.0 / (double)i;
        }

        Console.WriteLine(sum1);
        Console.WriteLine(sum2);
        Console.WriteLine(sum2 - sum1);
    }
}