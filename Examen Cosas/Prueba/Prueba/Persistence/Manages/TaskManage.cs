using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Xml.Linq;
using Prueba.Persistence;
using Prueba.Persistence.DataBase;

namespace Prueba.Persistence.Manages
{
    internal class TaskManage
    {
        public DataTable table { get; set; }
        public List<Domain.Task> listTask { get; set; }

        public TaskManage()
        {
            this.table = new DataTable();
            this.listTask = new List<Domain.Task>();
        }

        public void loadDataBase()
        {
            List<List<Object>> lTask = Persistence.DataBase.DataBase.obtainDataBase().read("SELECT * FROM task ORDER BY id");

            Domain.Task t = null;
            foreach (List<Object> task in lTask)
            {
                t = new Domain.Task(Int32.Parse(task[0].ToString()));
                t.name = task[1].ToString();
                t.description = task[2].ToString();
                t.isCompleted = Convert.ToBoolean(task[3].ToString());
                this.listTask.Add(t);
            }
        }

        public void insertTask(Domain.Task t)
        {
            DataBase.DataBase.obtainDataBase()
                .modify("INSERT INTO task (id, name, description, isCompleted) " +
                $"values ({t.id}, '{t.name}', '{t.description}', {t.isCompleted})");
        }

        public void lastId(Domain.Task t)
        {
            List<List<Object>> lTask = DataBase.DataBase.obtainDataBase().read("SELECT MAX(id) FROM task");

            foreach (List<Object> task in lTask)
            {
                t.id = Int32.Parse(task[0].ToString()) + 1;
            }
        }

        public void deleteTask(Domain.Task t)
        {
            DataBase.DataBase.obtainDataBase().modify("DELETE FROM task where id=" + t.id);

        }
        public void updateTask(Domain.Task t)
        {
            DataBase.DataBase.obtainDataBase().modify($"UPDATE task SET name = '{t.name}', description = '{t.description}', isCompleted = {t.isCompleted} where id = " + t.id);
        }

    }
}
