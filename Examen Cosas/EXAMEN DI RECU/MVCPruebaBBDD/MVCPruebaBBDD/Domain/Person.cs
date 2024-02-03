using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;

namespace MVCPruebaBBDD.Domain
{
    internal class Person
    {
        public int id { get; set; }
        public String firstName { get; set; }
        public String lastName { get; set; }
        public String birthDate { get; set; }
        public bool isStudent { get; set; }
        public PersonManage tm { get; set; }

        public Person(int id, string firstName, string lastName, String birthDate, bool isStudent, PersonManage tm)
        {
            this.firstName = firstName;
            this.lastName = lastName;
            this.birthDate = birthDate;
            this.isStudent = isStudent;
            this.tm = tm;
        }

        public Person()
        {
            tm = new PersonManage();
        }

        public Person(int id)
        {
            this.id = id;
            tm = new PersonManage();
        }

        public void readT()
        {
            tm.loadDataBase();
        }

        public List<Person> getListPerson()
        {
            return tm.listPerson;
        }

        public void insert()
        {
            tm.insertPerson(this);
        }

        public void delete()
        {
            tm.deletePerson(this);
        }

        public void update()
        {
            tm.updatePerson(this);
        }

    }
}
