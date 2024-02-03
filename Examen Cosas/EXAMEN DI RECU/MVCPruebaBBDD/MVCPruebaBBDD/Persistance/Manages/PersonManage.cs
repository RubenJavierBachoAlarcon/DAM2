using MVCPruebaBBDD.Persistance.DataBaseFolder;
using System.Collections.Generic;
using System.Data;
using System;

namespace MVCPruebaBBDD.Domain
{
    internal class PersonManage
    {
        public DataTable table { get; set; }
        public List<Domain.Person> listPerson { get; set; }

        public PersonManage()
        {
            this.table = new DataTable();
            this.listPerson = new List<Domain.Person>();
        }

        public void loadDataBase()
        {
            List<List<Object>> lPerson = DataBase.obtainDataBase().read("SELECT * FROM person ORDER BY id");

            Domain.Person t = null;
            foreach (List<Object> person in lPerson)
            {
                t = new Domain.Person(Int32.Parse(person[0].ToString()));
                t.firstName = person[1].ToString();
                t.lastName = person[2].ToString();
                t.birthDate = person[3].ToString();
                
                if (person[4] == "1")
                {
                    t.isStudent = true;
                }
                else
                {
                    t.isStudent = false;
                }

                this.listPerson.Add(t);
            }
        }

        public void insertPerson(Domain.Person t)
        {
            DataBase.obtainDataBase()
                .modify("INSERT INTO person (firstName, lastName, birthDate, isStudent) " +
                $"values ('{t.firstName}', '{t.lastName}', '{t.birthDate}', {t.isStudent})");
        }
        public void deletePerson(Domain.Person t)
        {
            DataBase.obtainDataBase().modify("DELETE FROM person where id=" + t.id);

        }
        public void updatePerson(Domain.Person t)
        {
            DataBase.obtainDataBase().modify($"UPDATE person SET firstName = '{t.firstName}', lastName = '{t.lastName}', birthDate = '{t.birthDate}', isStudent = {t.isStudent} where id = " + t.id);
        }
    }
}