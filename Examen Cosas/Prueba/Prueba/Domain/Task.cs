using Prueba.Persistence.Manages;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Prueba.Domain
{
    internal class Task
    {
        public int id { get; set; }
        public String name { get; set; }
        public String description { get; set; }
        public bool isCompleted { get; set; }
        public TaskManage tm { get; set; }

        public Task(String name, String description, bool isCompleted)
        {
            this.id = id;
            this.name = name;
            this.isCompleted = isCompleted;
            tm = new TaskManage();
        }

        public Task()
        {
            tm = new TaskManage();
        }

        public Task(int id)
        {
            this.id = id;
            tm = new TaskManage();
        }

        public void readT()
        {
            tm.loadDataBase();
        }

        public List<Task> getListTask()
        {
            return tm.listTask;
        }

        public void insert()
        {
            tm.insertTask(this);
        }

        public void last()
        {
            tm.lastId(this);
        }

        public void delete()
        {
            tm.deleteTask(this);
        }

        public void update()
        {
            tm.updateTask(this);
        }

    }
}
