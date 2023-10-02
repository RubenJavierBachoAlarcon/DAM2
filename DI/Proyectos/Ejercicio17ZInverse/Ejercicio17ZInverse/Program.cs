int length = 6;

for (int i = 0; i < length; i++)
{
    for (int j = 0; j < length; j++)
    {
        if (i == 0 || i == length - 1)
        {
            Console.Write("* ");
        }
        else if (i == j)
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