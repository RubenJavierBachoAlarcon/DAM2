using System;

public class MatrixLibrary
{
    public static int[,] Add(int[,] matrix1, int[,] matrix2)
    {
        if (matrix1.GetLength(0) != matrix2.GetLength(0) || matrix1.GetLength(1) != matrix2.GetLength(1))
        {
            throw new ArgumentException("Matrix dimensions must be the same for addition.");
        }

        int rows = matrix1.GetLength(0);
        int columns = matrix1.GetLength(1);

        int[,] result = new int[rows, columns];

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                result[i, j] = matrix1[i, j] + matrix2[i, j];
            }
        }

        return result;
    }

    public static int[,] Subtract(int[,] matrix1, int[,] matrix2)
    {
        if (matrix1.GetLength(0) != matrix2.GetLength(0) || matrix1.GetLength(1) != matrix2.GetLength(1))
        {
            throw new ArgumentException("Matrix dimensions must be the same for subtraction.");
        }

        int rows = matrix1.GetLength(0);
        int columns = matrix1.GetLength(1);

        int[,] result = new int[rows, columns];

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                result[i, j] = matrix1[i, j] - matrix2[i, j];
            }
        }

        return result;
    }

    public static int[,] Multiply(int[,] matrix1, int[,] matrix2)
    {
        if (matrix1.GetLength(1) != matrix2.GetLength(0))
        {
            throw new ArgumentException("Matrix dimensions are incompatible for multiplication.");
        }

        int rows = matrix1.GetLength(0);
        int columns = matrix2.GetLength(1);
        int innerDimension = matrix1.GetLength(1);

        int[,] result = new int[rows, columns];

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                int sum = 0;
                for (int k = 0; k < innerDimension; k++)
                {
                    sum += matrix1[i, k] * matrix2[k, j];
                }
                result[i, j] = sum;
            }
        }

        return result;
    }
}

public class MatrixTest
{
    public static void Main(string[] args)
    {
        int[,] matrix1 = {
            {1, 2},
            {3, 4}
        };

        int[,] matrix2 = {
            {5, 6},
            {7, 8}
        };

        int[,] sumResult = MatrixLibrary.Add(matrix1, matrix2);
        int[,] subResult = MatrixLibrary.Subtract(matrix1, matrix2);
        int[,] mulResult = MatrixLibrary.Multiply(matrix1, matrix2);

        Console.WriteLine("Matrix Addition:");
        PrintMatrix(sumResult);

        Console.WriteLine("\nMatrix Subtraction:");
        PrintMatrix(subResult);

        Console.WriteLine("\nMatrix Multiplication:");
        PrintMatrix(mulResult);
    }

    public static void PrintMatrix(int[,] matrix)
    {
        int rows = matrix.GetLength(0);
        int columns = matrix.GetLength(1);

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                Console.Write(matrix[i, j] + "\t");
            }
            Console.WriteLine();
        }
    }
}
