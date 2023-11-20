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
        public int Id { get; set; }
        public String name { get; set; }
        public int age { get; set; }
        public PeopleManage pm { get; set; }

        public People()
        {
            pm = new PeopleManage();
        }
        public People(int id)
        {
            pm = new PeopleManage();
            Id = id;
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

        public void insert()
        {
            pm.insertPeople(this);
        }

        public  void last()
        {
            pm.lastId(this);
        }
        public void delete()
        {
            pm.deletePeople(this);
        }
        public void update()
        {
            pm.updatePeople(this);
        }

    }
}
