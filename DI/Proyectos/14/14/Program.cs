using System;

class Program
{
    static void Main()
    {
        Console.Write("Enter a Hexadecimal string: ");
        string hexString = Console.ReadLine();

        try
        {
            int decimalValue = Convert.ToInt32(hexString, 16);
            string binaryString = Convert.ToString(decimalValue, 2);

            Console.WriteLine($"The equivalent binary for hexadecimal \"{hexString}\" is {binaryString}");
        }
        catch (FormatException)
        {
            Console.WriteLine("Invalid hexadecimal string format.");
        }
    }
}
