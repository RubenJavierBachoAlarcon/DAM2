int numStudents = int.Parse(Console.ReadLine());
int gradeStudent;
int sum = 0;
int i;
for (i = 0; 
    (gradeStudent = int.Parse(Console.ReadLine())) > 0 && gradeStudent < 100; 
    i++)
{
    sum += gradeStudent;
}

Console.WriteLine(sum/i);

