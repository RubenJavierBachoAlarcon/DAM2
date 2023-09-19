using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading.Tasks;

namespace Matrix
{
    public class Matrix
    {
        public Random rand = new Random();

        public Character[] chars;
        public Character[,] matrixChar;
        public int longMatrix;
        public char[,] matrix;
        public Neo neo;
        public Smith smith;

        public Matrix(int longMatrix)
        {
            this.longMatrix = longMatrix;
            matrix = new char[longMatrix, longMatrix];
            matrixChar = new Character[longMatrix, longMatrix];
            chars = new Character[200];
            neo = new Neo();
            smith = new Smith();

            for (int i = 0; i < 200; i++)
            {
                chars[i] = new Character();
            }

            for (int i = 0; i < longMatrix; i++)
            {
                for (int j = 0; j < longMatrix; j++)

                    matrix[i, j] = '-';
            }
        }


        public Matrix() : this(5)
        {

        }

        public void fillMatrix()
        {
            smith.x = rand.Next(5);
            smith.y = rand.Next(5);

            neo.x = rand.Next(5);
            neo.y = rand.Next(5);

            while (neo.x == smith.x && neo.y == smith.y)
            {
                neo.x = rand.Next(5);
                neo.y = rand.Next(5);
            }

            for (int i = 0; i < matrix.Length; i++)
            {
                for (int j = 0; j < matrix.Length; j++)
                {
                    if (smith.x == i && smith.y == j)
                    {
                        matrix[i, j] = 'S';
                    }

                    if (neo.x == i && neo.y == j)
                    {
                        matrix[i, j] = 'N';
                    }

                    else
                    {
                        matrix[i, j] = 'C';
                        matrixChar[i, j] = new Character();
                        matrixChar[i, j].x = i;
                        matrixChar[i, j].y = j;
                    }
                }
            }
        }

        public void printMatrix()
        {
            for (int i = 0; i < longMatrix; i++)
            {
                for (int j = 0; j < longMatrix; j++)
                {
                    Console.Write(matrix[i, j]);
                }
                Console.WriteLine();
            }
        }
    }
}