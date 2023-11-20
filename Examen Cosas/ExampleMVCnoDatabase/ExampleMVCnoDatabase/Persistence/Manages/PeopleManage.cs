using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Documents;
using ExampleMVCnoDatabase.Domain;

namespace ExampleMVCnoDatabase.Persistence.Manages
{
    internal class PeopleManage
    {
        public DataTable table { get; set; }
        public List<People> listPeople { get; set; }


        public PeopleManage()
        {
            table=new DataTable();
            listPeople=new List<People>();
        }

        public void readPeople()
        {
            /*listPeople.Add(new People("Neil",42));
            listPeople.Add(new People("Jimi", 20));
            listPeople.Add(new People("Valverde", 19));*/

            List<List<Object>> lpeople = DbMySql.obtainDB().read("SELECT * FROM people ORDER BY id");

            foreach (List<Object> aux in lpeople)
            {
                People p = new People();

                p.id = Convert.ToInt32(aux[0]);
                p.name = aux[1].ToString();
;               p.age = Convert.ToInt32(aux[2]);

                listPeople.Add(p);
            }
        }

    }
}
