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
        }

        public Smith() : this(5)
        {
        }
    }
}