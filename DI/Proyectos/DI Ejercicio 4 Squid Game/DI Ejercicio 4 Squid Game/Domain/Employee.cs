using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using DI_Ejercicio_4_Squid_Game.Persistance.Manages;

namespace DI_Ejercicio_4_Squid_Game.Domain
{
    class Employee
    {
        public string nif { get; set; }
        public String name { get; set; }
        public String surname { get; set; }
        public int age { get; set; }
        public EmployeeManage em { get; set; }

        public Employee()
        {
            em = new EmployeeManage();
        }

        public Employee(String nif)
        {
            this.nif = nif;
            em = new EmployeeManage();
        }

        public Employee(String nif, String name, String surname, int age)
        {
            this.nif = this.nif;
            this.name = nif;
            this.surname = surname;
            this.age = age;
            em = new EmployeeManage();
        }

        public void readE()
        {
            em.loadDataBase();
        }

        public List<Employee> getListTask()
        {
            return em.listEmployee;
        }

        public void insert()
        {
            em.insertEmployee(this);
        }

        public void delete()
        {
            em.deleteTask(this);
        }

        public void update()
        {
            em.updateTask(this);
        }

    }
}
