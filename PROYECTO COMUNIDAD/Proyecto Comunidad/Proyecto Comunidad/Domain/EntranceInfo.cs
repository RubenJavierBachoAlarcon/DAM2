using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Proyecto_Comunidad.Domain
{
    internal class EntranceInfo
    {

        public int id { get; set; }
        public int numStairs { get; set; }
        public int numFloors { get; set; }
        public int numLetters { get; set; }

        public EntranceInfo(int id, int numStairs, int numFloors, int numLetters)
        {
            this.id = id;
            this.numStairs = numStairs;
            this.numFloors = numFloors;
            this.numLetters = numLetters;
        }

        public EntranceInfo(int numStairs, int numFloors, int numLetters)
        {
            this.numStairs = numStairs;
            this.numFloors = numFloors;
            this.numLetters = numLetters;
        }
    }
}
