using System;
using System.Collections;
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

        public ArrayList chars;
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
            chars = new ArrayList();
            neo = new Neo();
            smith = new Smith();

            for (int i = 0; i < 200; i++)
            {
                chars.Add(new Character()); 
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
            smith.x = rand.Next(longMatrix);
            smith.y = rand.Next(longMatrix);

            neo.x = rand.Next(longMatrix);
            neo.y = rand.Next(longMatrix);

            while (neo.x == smith.x && neo.y == smith.y)
            {
                neo.x = rand.Next(longMatrix);
                neo.y = rand.Next(longMatrix);
            }

            for (int i = 0; i < matrix.GetLength(0); i++)
            {
                for (int j = 0; j < matrix.GetLength(1); j++)
                {
                    if (smith.x == i && smith.y == j)
                    {
                        matrix[i, j] = 'S';
                    }

                    else if (neo.x == i && neo.y == j)
                    {
                        matrix[i, j] = 'N';
                    }

                    else
                    {
                        matrix[i, j] = 'c';
                        matrixChar[i, j] = (Character) (chars[chars.Count - 1]);
                        chars.RemoveAt(chars.Count - 1);
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

        public void charActs()
        {

        }
    }
}