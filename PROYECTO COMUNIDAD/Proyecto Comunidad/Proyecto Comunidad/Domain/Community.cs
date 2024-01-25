using ProyectoComunidad.Persistance.Manages;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using ProyectoComunidad.Persistance;

namespace ProyectoComunidad.Domain
{
    class Community
    {
        public string name { get; set; }
        public String address { get; set; }
        public String foundingDate { get; set; }
        public int size { get; set; }
        public bool havePool { get; set; }
        public CommunityManage cm { get; set; }

        public Community()
        {
            CommunityManage cm = new CommunityManage();
        }

        public Community(string name)
        {
            this.name = name;
        }

        public Community(string name, string address, string foundingDate, int size, bool havePool, CommunityManage cm)
        {
            this.name = name;
            this.address = address;
            this.foundingDate = foundingDate;
            this.size = size;
            this.havePool = havePool;
            this.cm = cm;
        }

        public void reaC()
        {
            cm.loadDataBase();
        }

        public List<Community> getListTask()
        {
            return cm.listCommunity;
        }

        public void insert()
        {
            cm.insertCommunity(this);
        }

        public void delete()
        {
            cm.deleteCommunity(this);
        }

        public void update()
        {
            cm.updateCommunity(this);
        }

    }
}
