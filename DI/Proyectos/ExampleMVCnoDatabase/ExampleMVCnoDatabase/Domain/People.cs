using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using ExampleMVCnoDatabase.Persistence.Manages;

namespace ExampleMVCnoDatabase.Domain
{
    internal class People
    {
        public String name { get; set; }
        public int age { get; set; }
        public PeopleManage pm { get; set; }

        public People() {
            pm = new PeopleManage();
        }

        public People(string name, int age)
        {
            this.name = name;
            this.age = age;
            pm = new PeopleManage();
        }

        public void readP()
        {
            pm.readPeople();
        }

        public List<People> getListPeople(){
            return pm.listPeople;
        }


    }
}
