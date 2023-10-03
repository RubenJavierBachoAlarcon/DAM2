int length = 5; // Change this to change the size of the pyramid

for (int i = 1; i <= length; i++)
{
    // Spaces before the asterisks
    for (int j = 1; j <= length - i; j++)
    {
        Console.Write("  ");
    }

    // Asterisks
    for (int j = 1; j <= 2 * i - 1; j++)
    {
        Console.Write("* ");
    }

    Console.WriteLine(); // Move to the next line
}