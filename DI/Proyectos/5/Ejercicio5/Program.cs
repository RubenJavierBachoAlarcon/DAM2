int numTry = int.Parse(Console.ReadLine());
double piProx = 0.0;
bool substract = false;

for (int i = 1; i < numTry; i += 2)
{
    if (substract)
    {
        piProx -= 1.0 / i;
        substract = false;
    }
    else
    {
        piProx += 1.0 / i;
        substract = true;
    }
}

Console.WriteLine(4*piProx);