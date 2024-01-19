using ProyectoComunidad.Domain;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Proyecto_Comunidad.Persistance.Manages;
using Proyecto_Comunidad.Persistance;

namespace Proyecto_Comunidad.Domain
{

    internal class Entrance
    {
        public String nameCommunity;
        public int stair;
        public int floor;
        public char letter;
        public int parking;
        public int storage;
        public EntranceManage em;

        public Entrance(String nameCommunity, int stair, int floor, char letter, int parking, int storage)
        {
            this.nameCommunity = nameCommunity;
            this.stair = stair;
            this.floor = floor;
            this.letter = letter;
            this.parking = parking;
            this.storage = storage;
            this.em = new EntranceManage();
        }

        public Entrance(string nameCommunity, int stair, int floor, char letter)
        {
            this.nameCommunity = nameCommunity;
            this.stair = stair;
            this.floor = floor;
            this.letter = letter;
            this.em = new EntranceManage();
        }

        public Entrance()
        {
            this.em = new EntranceManage();
        }


        public void insert()
        {
            em.insertEntrance(this);
        }

    }
}
