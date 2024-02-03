int xOriginal;
Console.WriteLine("Introduce the rows: ");
int.TryParse(Console.ReadLine(), out xOriginal);

int yOriginal;
Console.WriteLine("Introduce the columns: ");
int.TryParse(Console.ReadLine(), out yOriginal);

char[,] matrixOriginal = new char[xOriginal, yOriginal];

Random rand = new Random();

int randX = rand.Next(0, xOriginal);
int randY = rand.Next(0, yOriginal);
Console.WriteLine(randX);
Console.WriteLine(randY);

matrixOriginal = queen(matrixOriginal);

print(matrixOriginal);


char[,] rook(char[,] matrix)
{
    for (int i = 0; i < matrix.GetLength(0); i++)
    {
        for (int j = 0; j < matrix.GetLength(0); j++)
        {
            if (randX == i)
            {
                matrix[i, j] = '*';
            }
            else if (randY == j)
            {
                matrix[i, j] = '*';
            }
        }
    }
    matrix[randX, randY] = 'T';

    return matrix;
}

char[,] horse(char[,] matrix)
{
    for (int i = 0; i < matrix.GetLength(0); i++)
    {
        for (int j = 0; j < matrix.GetLength(0); j++)
        {
            if (i == randX + 2 && j == randY + 1)
            {
                matrix[i, j] = '*';
            }
            else if (i == randX + 2 && j == randY - 1)
            {
                matrix[i, j] = '*';
            }
            else if (i == randX - 2 && j == randY + 1)
            {
                matrix[i, j] = '*';
            }
            else if (i == randX - 2 && j == randY - 1)
            {
                matrix[i, j] = '*';
            }
            else if (j == randY + 2 && i == randX + 1)
            {
                matrix[i, j] = '*';
            }
            else if (j == randY + 2 && i == randX - 1)
            {
                matrix[i, j] = '*';
            }
            else if (j == randY - 2 && i == randX + 1)
            {
                matrix[i, j] = '*';
            }
            else if (j == randY - 2 && i == randX - 1)
            {
                matrix[i, j] = '*';
            }

        }
        matrix[randX, randY] = 'H';
    }

    return matrix;
}


char[,] bishop(char[,] matrix)
{
    int x = randX;
    int y = randY;
    while (x < matrix.GetLength(0) && y < matrix.GetLength(1))
    {
        matrix[x, y] = '*';
        x++;
        y++;
    }

    x = randX;
    y = randY;
    while (x < matrix.GetLength(0) && y >= 0)
    {
        matrix[x, y] = '*';
        x++;
        y--;
    }
    x = randX;
    y = randY;
    while (x >= 0 && y < matrix.GetLength(1))
    {
        matrix[x, y] = '*';
        x--;
        y++;
    }
    x = randX;
    y = randY;
    while (x >= 0 && y >= 0)
    {
        matrix[x, y] = '*';
        x--;
        y--;
    }

    matrix[randX, randY] = 'B';
    
    return matrix;
}

char[,] queen(char[,] matrix)
{
    matrix = bishop(matrix);
    matrix = rook(matrix);
    matrix[randX, randY] = 'Q';
    return matrix;
}
void print(char[,] matrixPrint)
{
    for (int i = 0; i < matrixPrint.GetLength(0); i++)
    {
        for (int j = 0; j < matrixPrint.GetLength(1); j++)
        {
            if (matrixPrint[i, j] == '\0')
            {
                Console.Write(' ');
            }
            else
            {
                Console.Write(matrixPrint[i, j]);
            }
            
        }
        Console.WriteLine();
    }
}

