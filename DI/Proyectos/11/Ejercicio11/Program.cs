try
{
    string binaryString = Console.ReadLine();
    int decimalNumber = Convert.ToInt32(binaryString, 2);
    Console.WriteLine(decimalNumber);
}
catch (FormatException e)
{
    Console.WriteLine("El input no es binario");
}