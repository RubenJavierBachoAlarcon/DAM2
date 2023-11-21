using DI_Ejercicio_4_Squid_Game.Persistance.DataBaseFolder;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DI_Ejercicio_4_Squid_Game.Persistance.Manages
{
    class EmployeeManage
    {
        public DataTable table { get; set; }
        public List<Domain.Employee> listEmployee { get; set; }

        public EmployeeManage()
        {
            this.table = new DataTable();
            this.listEmployee = new List<Domain.Employee>();
        }

        public void loadDataBase()
        {
            List<List<Object>> lEmployee = DataBase.obtainDataBase().read("SELECT * FROM employee ORDER BY nif");

            Domain.Employee t = null;
            foreach (List<Object> employee in lEmployee)
            {
                t = new Domain.Employee(employee[0].ToString());
                t.name = employee[1].ToString();
                t.surname = employee[2].ToString();
                t.age = Int32.Parse(employee[3].ToString());
                this.listEmployee.Add(t);
            }
        }

        public void insertEmployee(Domain.Employee e)
        {
            DataBase.obtainDataBase()
                .modify("INSERT INTO employee (nif, name, surname, age) " +
                $"values ('{e.nif}', '{e.name}', '{e.surname}', {e.age})");
        }

        public void deleteTask(Domain.Employee e)
        {
            DataBase.obtainDataBase().modify($"DELETE FROM employee where nif='{e.nif}'");

        }
        public void updateTask(Domain.Employee e)
        {
            DataBase.obtainDataBase().modify($"UPDATE employee SET name = '{e.name}', surname = '{e.surname}', age = {e.age} where nif = '{e.nif}' ");
        }
    }
}
