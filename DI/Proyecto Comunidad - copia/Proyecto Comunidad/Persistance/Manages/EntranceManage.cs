using DI_Ejercicio_4_Squid_Game.Persistance.DataBaseFolder;
using Proyecto_Comunidad.Domain;
using ProyectoComunidad.Domain;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Proyecto_Comunidad.Persistance.Manages
{
    internal class EntranceManage
    {

        public DataTable table { get; set; }
        public List<Entrance> listEntrance { get; set; }

        public EntranceManage()
        {
            this.table = new DataTable();
            this.listEntrance = new List<Entrance>();
        }


        public void insertEntrance(Entrance e)
        {
            DataBase.obtainDataBase()
            .modify("INSERT INTO entrances (nameCommunity, stair, floor, letter, parking, storage) " +
            $"values ('{GlobalVariable.nameCommunity}', '{e.stair}', '{e.floor}', '{e.letter}', {e.parking}, {e.storage})");

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
