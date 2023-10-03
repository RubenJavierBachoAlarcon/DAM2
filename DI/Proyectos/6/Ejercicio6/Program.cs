using System;


int n = 20;
int[] tribonacci = new int[n];

tribonacci[0] = tribonacci[1] = 1;
tribonacci[2] = 2;

for (int i = 3; i < n; i++)
{
    tribonacci[i] = tribonacci[i - 1] + tribonacci[i - 2] + tribonacci[i - 3];
}

for (int i = 0; i < n; i++)
{
    Console.Write(tribonacci[i] + " ");
}
