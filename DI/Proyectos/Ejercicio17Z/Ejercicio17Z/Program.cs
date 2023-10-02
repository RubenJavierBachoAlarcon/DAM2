int length = 5;

for (int i = 0; i < length; i++)
{
    for (int j = 0; j < length; j++)
    {
        if (i == 0 || i == length - 1 || j == length - i - 1)
        {
            Console.Write("* ");
        }
        else
        {
            Console.Write("  ");
        }
    }
    Console.WriteLine();
}
