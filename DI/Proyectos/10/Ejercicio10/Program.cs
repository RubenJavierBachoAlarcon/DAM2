Console.Write("Introduce la frase: ");

String input = Console.ReadLine();
String newInput = new String(input.Where(Char.IsLetter).ToArray()).ToLower();
String reverse = new String(newInput.Reverse().ToArray()).ToLower();

if (newInput == reverse)
{
    Console.WriteLine("Es palindromo");
} 
else
{
    Console.WriteLine("No es palindromo");
}



