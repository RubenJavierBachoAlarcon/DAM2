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
    /// <summary>
    /// Represents an entrance in a community with properties such as name of the community, stair, floor, letter, parking, storage, and entrance management.
    /// </summary>
    internal class Entrance
    {
        /// <summary>
        /// Name of the community.
        /// </summary>
        public String nameCommunity;

        /// <summary>
        /// Stair number.
        /// </summary>
        public int stair;

        /// <summary>
        /// Floor number.
        /// </summary>
        public int floor;

        /// <summary>
        /// Letter of the entrance.
        /// </summary>
        public char letter;

        /// <summary>
        /// Parking number.
        /// </summary>
        public int parking;

        /// <summary>
        /// Storage number.
        /// </summary>
        public int storage;

        /// <summary>
        /// Entrance management.
        /// </summary>
        public EntranceManage em;

        /// <summary>
        /// Initializes a new instance of the <see cref="Entrance"/> class with specified properties.
        /// </summary>
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

        /// <summary>
        /// Initializes a new instance of the <see cref="Entrance"/> class with specified properties.
        /// </summary>
        public Entrance(string nameCommunity, int stair, int floor, char letter)
        {
            this.nameCommunity = nameCommunity;
            this.stair = stair;
            this.floor = floor;
            this.letter = letter;
            this.em = new EntranceManage();
        }

        /// <summary>
        /// Initializes a new instance of the <see cref="Entrance"/> class.
        /// </summary>
        public Entrance()
        {
            this.em = new EntranceManage();
        }

        /// <summary>
        /// Inserts the entrance into the database.
        /// </summary>
        public void insert()
        {
            em.insertEntrance(this);
        }
    }
}
