string str1 = Console.ReadLine();
char[] chain = str.ToCharArray();
Array.Reverse(chain);
string reversed = new string(chain);
Console.WriteLine(reversed);