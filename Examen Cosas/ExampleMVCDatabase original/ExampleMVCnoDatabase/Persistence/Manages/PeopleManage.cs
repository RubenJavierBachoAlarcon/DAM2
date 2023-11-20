using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Documents;
using ExampleMVCnoDatabase.Domain;
using ExampleMVCnoDatabase.Persistence;

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
            People p = null;
            List<Object> lpeople;
            lpeople = DBBroker.obtenerAgente().leer("select * from people order by idpeople");
            foreach (List<Object> aux in lpeople)
            {
                p = new People(Int32.Parse(aux[0].ToString()));
                p.name = aux[1].ToString();
                p.age = Int32.Parse(aux[2].ToString());
                this.listPeople.Add(p);
            }
        }
         public void insertPeople (People p)
        {
            DBBroker dBBroker=DBBroker.obtenerAgente();
            MessageBox.Show("Insert into people (name,age) values ('" + p.name + "'," + p.age + ")");
            dBBroker.modificar("Insert into people (name,age) values ('" + p.name + "',"+ p.age +")");
        }

        public void lastId(People p)
        { 
            List<Object> lpeople;
            lpeople = DBBroker.obtenerAgente().leer("select MAX(idPeople) FROM people");
            foreach (List<Object> aux in lpeople)
            {
                p.Id = Convert.ToInt32(aux[0]);
            }
        }

        public void deletePeople(People p)
        {
            DBBroker dBBroker = DBBroker.obtenerAgente();


            dBBroker.modificar("Delete from people where idPeople="+ p.Id);

        }
        public void updatePeople(People p)
        {
            DBBroker dBBroker = DBBroker.obtenerAgente();
            dBBroker.modificar("update people set name='" + p.name + "',age=" + p.age + " where idPeople=" + p.Id);
        }

    }
}
