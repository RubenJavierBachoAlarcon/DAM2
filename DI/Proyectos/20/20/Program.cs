using System;

class WordGuess
{
    static void Main(string[] args)
    {
        if (args.Length != 1)
        {
            Console.WriteLine("Usage: WordGuess <word_to_guess>");
            return;
        }

        string wordToGuess = args[0].ToLower();
        char[] guessedWord = new char[wordToGuess.Length];
        int trials = 0;

        for (int i = 0; i < wordToGuess.Length; i++)
        {
            guessedWord[i] = '_';
        }

        Console.WriteLine("Word Guessing Game");
        Console.WriteLine("Guess the word by entering one character at a time or the entire word.");
        Console.WriteLine("Word to guess: " + new string(guessedWord));

        while (true)
        {
            Console.Write("Enter one character or your guess word: ");
            string input = Console.ReadLine().ToLower();

            if (input.Length == 1)
            {
                char guess = input[0];

                bool correctGuess = false;

                for (int i = 0; i < wordToGuess.Length; i++)
                {
                    if (wordToGuess[i] == guess)
                    {
                        guessedWord[i] = guess;
                        correctGuess = true;
                    }
                }

                if (!correctGuess)
                {
                    trials++;
                }

                Console.WriteLine($"Trial {trials}: {new string(guessedWord)}");

                if (new string(guessedWord) == wordToGuess)
                {
                    Console.WriteLine("Congratulations!");
                    Console.WriteLine($"You got it in {trials} trials.");
                    break;
                }
            }
            else if (input.Length == wordToGuess.Length && input == wordToGuess)
            {
                trials++;
                Console.WriteLine("Congratulations!");
                Console.WriteLine($"You got it in {trials} trials.");
                break;
            }
            else
            {
                Console.WriteLine("Invalid input. Please enter one character or your guess word.");
            }
        }
    }
}
