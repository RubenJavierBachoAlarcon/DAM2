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

        public int numInfected = 0;
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
                        matrixChar[i, j] = smith;
                    }

                    else if (neo.x == i && neo.y == j)
                    {
                        matrix[i, j] = 'N';
                        matrixChar[i, j] = neo;
                    }

                    else
                    {
                        matrix[i, j] = 'c';
                        matrixChar[i, j] = (Character)(chars[chars.Count - 1]);
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
                    Console.Write(matrix[i, j] + " ");
                }
                Console.WriteLine();
            }
        }

        public void charActs()
        {
            Console.WriteLine(matrixChar.Length);
            for (int i = 0; i < matrixChar.GetLength(0); i++)
            {
                for (int j = 0; j < matrixChar.GetLength(1); j++)
                {
                    if (matrixChar[i, j] != null)
                    {
                        if (matrixChar[i, j].probDeath != 0 && matrixChar[i, j].probDeath != null)
                        {
                            if (matrixChar[i, j].probDeath > 0.7)
                            {
                                matrixChar[i, j] = (Character)(chars[chars.Count - 1]);
                                chars.RemoveAt(chars.Count - 1);
                            }
                            else
                            {
                                matrixChar[i, j].probDeath += 0.1;
                            }

                        }
                    }
                }
            }
        }

        public void smithActs()
        {
            numInfected = 0;
            smith.capInfect = rand.Next(1, smith.maxCapInfect);
            smithActsRecursive(smith.x, smith.y, numInfected);
        }

        public void smithActsRecursive(int x, int y, int numInfected)
        {
            Boolean foundPath = false;

            int minDistance;
            int smithDistance;
            if (((x - y) % 2 == 0 && (neo.x - neo.y) % 2 == 0) || ((x - y) % 2 != 0 && (neo.x - neo.y) % 2 != 0))
            {
                for (int i = -1; i <= 1 && !foundPath && numInfected < smith.capInfect; i++)
                {
                    for (int j = -1; j <= 1 && !foundPath && numInfected < smith.capInfect; j++)
                    {
                        if (i != 0 && j != 0)
                        {
                            if ((x + i) >= 0 && (x + i) < matrixChar.GetLength(0) && (y + j) >= 0 && (y + j) < matrixChar.GetLength(1))
                            {
                                minDistance = Math.Max(Math.Abs(x + i - neo.x), Math.Abs(y + j - neo.y));
                                smithDistance = Math.Max(Math.Abs(x - neo.x), Math.Abs(y - neo.y));

                                if (minDistance < smithDistance)
                                {
                                    if (minDistance == 0)
                                    {
                                        break;
                                    }
                                    else
                                    {
                                        if (matrixChar[x + i, y + j] != null)
                                        {
                                            matrixChar[x + i, y + j] = null;
                                            matrix[x + i, y + j] = '-';
                                            numInfected++;
                                            Console.WriteLine("La capacidad de infectar es: " + smith.capInfect);
                                            Console.WriteLine("numero de infectados:" + numInfected);
                                            foundPath = true;
                                        }
                                        Console.WriteLine(smith.capInfect);
                                        smithActsRecursive(x + i, y + j, numInfected);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        public void neoActs()
        {
            neo.setRandomIsChossen();
            Console.WriteLine(neo.isChossen);
            if (neo.isChossen)
            {
                Console.WriteLine("Elegido");
                for (int i = -1; i <= 1; i++)
                {
                    for (int j = -1; j <= 1; j++)
                    {
                        if ((neo.x + i) >= 0 && (neo.x + i) < matrixChar.GetLength(0) && (neo.y + j) >= 0 && (neo.y + j) < matrixChar.GetLength(1))
                        {
                            if (matrixChar[neo.x + i, neo.y + j] == null)
                            {
                                matrixChar[neo.x + i, neo.y + j] = (Character)(chars[chars.Count - 1]);
                                chars.RemoveAt(chars.Count - 1);
                                Console.WriteLine("Character aniadido en " + (neo.x + i) + " " + (neo.y + j));
                                matrix[neo.x + i, neo.y + j] = 'c';
                            }
                        }
                    }
                }
            }

            int randomX = rand.Next(matrixChar.GetLength(0));
            int randomY = rand.Next(matrixChar.GetLength(1));


            if (matrixChar[randomX, randomY] == null)
            {
                matrix[randomX, randomY] = 'N';
                matrix[neo.x, neo.y] = '-';
                matrixChar[randomX, randomY] = neo;
                matrixChar[neo.x, neo.y] = null;
                neo.x = randomX;
                neo.y = randomY;

            }
            else if (matrixChar[randomX, randomY] is Smith smith)
            {
                matrix[neo.x, neo.y] = 'S';
                matrix[smith.x, smith.y] = 'N';

                int tempX = neo.x;
                int tempY = neo.y;
                neo.x = smith.x;
                neo.y = smith.y;
                smith.x = tempX;
                smith.y = tempY;

                matrixChar[neo.x, neo.y] = neo;
                matrixChar[smith.x, smith.y] = smith;


            }
            else
            {
                matrix[randomX, randomY] = 'N';
                matrix[neo.x, neo.y] = 'c';
                Character aux = new Character(matrixChar[randomX, randomY]);
                matrixChar[randomX, randomY] = neo;
                matrixChar[neo.x, neo.y] = aux;
                matrixChar[randomX, randomY].x = neo.x;
                matrixChar[randomX, randomY].y = neo.y;
                neo.x = randomX;
                neo.y = randomY;
            }
        }
        
    }

}