int length = 5; // Change this to change the size of the pyramid

for (int i = length; i > 0; i--)
{
    for (int j = 0; j < length - i; j++)
    {
        Console.Write("  ");
    }

    for (int k = 0; k < (2 * i - 1); k++)
    {
        Console.Write("* ");
    }

    Console.WriteLine();
}
