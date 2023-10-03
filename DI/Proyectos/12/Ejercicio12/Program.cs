try
{
    string hexaString = Console.ReadLine();
    int hexa = Convert.ToInt32(hexaString, 16);
    Console.WriteLine(hexa);
}
catch (FormatException e)
{
    Console.WriteLine("El input no es hexadecimal");
}   