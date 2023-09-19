for (int i = 1; i <= 9; i++)
{
    for (int j = 1; j <= 9; j++)
    {
        Console.Write((i*j).ToString().PadLeft(3));
    }
    Console.WriteLine();
}