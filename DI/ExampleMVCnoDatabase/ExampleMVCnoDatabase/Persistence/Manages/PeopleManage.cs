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
            listPeople.Add(new People("Neil",42));
            listPeople.Add(new People("Jimi", 20));
            listPeople.Add(new People("Valverde", 19));

        }

    }
}
