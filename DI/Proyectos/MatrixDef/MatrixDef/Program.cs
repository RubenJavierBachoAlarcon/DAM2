using System.Runtime.InteropServices;

Matrix.Matrix matrix = new Matrix.Matrix();
matrix.fillMatrix();
matrix.printMatrix();
Console.WriteLine(matrix.neo.x);
Console.WriteLine(matrix.neo.y);
Console.WriteLine(matrix.chars.Count);
Console.WriteLine(matrix.matrixChar[2,2].probDeath);
matrix.charActs();
matrix.charActs();
Console.WriteLine(matrix.chars.Count);