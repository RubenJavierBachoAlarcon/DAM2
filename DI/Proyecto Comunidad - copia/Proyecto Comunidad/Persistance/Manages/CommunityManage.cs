using DI_Ejercicio_4_Squid_Game.Persistance.DataBaseFolder;
using ProyectoComunidad.Domain;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProyectoComunidad.Persistance.Manages
{
    class CommunityManage
    {
        public DataTable table { get; set; }
        public List<Community> listCommunity { get; set; }

        public CommunityManage()
        {
            this.table = new DataTable();
            this.listCommunity = new List<Community>();
        }

        public void loadDataBase()
        {
            List<List<Object>> lCommunity = DataBase.obtainDataBase().read("SELECT * FROM communities ORDER BY name");

            Community c = null;
            foreach (List<Object> community in lCommunity)
            {
                c = new Community(community[0].ToString());
                c.address = community[1].ToString();
                c.foundingDate = community[2].ToString();
                c.size = int.Parse(community[3].ToString());
                
                if (community[4].ToString().Equals("1"))
                {
                    c.havePool = true;
                }
                else
                {
                    c.havePool = false;
                }

                this.listCommunity.Add(c);
            }
        }

        public void insertCommunity(Community c)
        {
            int havePool;

            if (c.havePool)
            {
                havePool = 1;
            }
            else
            {
                havePool = 0;
            }

            DataBase.obtainDataBase()
                .modify("INSERT INTO communities (name, address, foundingDate, size, havePool) " +
                $"values ('{c.name}', '{c.address}', '{c.foundingDate}', {c.size}, {havePool})");
        }

        public void deleteCommunity(Community c)
        {
            DataBase.obtainDataBase().modify($"DELETE FROM communities where name = '{c.name}'");

        }
        public void updateCommunity(Community c)
        {
            DataBase.obtainDataBase().modify($"UPDATE communities SET name = '{c.name}', address = '{c.address}', " +
                $"foundingDate = '{c.foundingDate}', size = {c.size}, havePool = {c.havePool} " +
                $"where name = '{c.name}' ");
        }
    }
}
