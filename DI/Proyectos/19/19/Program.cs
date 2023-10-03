using System;

class Program
{
    static void Main()
    {
        Random random = new Random();
        int targetNumber = random.Next(0, 100);
        int numberOfGuesses = 0;

        Console.WriteLine("Welcome to the Number Guessing Game!");
        Console.WriteLine("Try to guess the number between 0 and 99.");

        while (true)
        {
            Console.Write("Enter your guess: ");
            if (int.TryParse(Console.ReadLine(), out int userGuess))
            {
                numberOfGuesses++;

                if (userGuess < targetNumber)
                {
                    Console.WriteLine("Try higher");
                }
                else if (userGuess > targetNumber)
                {
                    Console.WriteLine("Try lower");
                }
                else
                {
                    Console.WriteLine($"You got it in {numberOfGuesses} trials!");
                    break;
                }
            }
            else
            {
                Console.WriteLine("Invalid input. Please enter a valid number.");
            }
        }
    }
}
