using System;
using System.Net.NetworkInformation;
namespace Matrix
{
    public class Smith : Character
    {
        private int capInfect;

        public Smith(int capInfect)
        {
            this.capInfect = capInfect;
            base.probDeath = 0;
        }

        public Smith() : this(5)
        {
        }
    }
}