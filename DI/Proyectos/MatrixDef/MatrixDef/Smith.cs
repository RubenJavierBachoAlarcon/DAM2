using System;
using System.Net.NetworkInformation;
namespace Matrix
{
    public class Smith : Character
    {
        Random rand = new Random();
        public int capInfect;
        public int maxCapInfect;

        public Smith(int maxCapInfect)
        {
            this.maxCapInfect = maxCapInfect;
            base.probDeath = 0;
        }

        public Smith() : this(5)
        {
        }

        public Smith(Smith smith)
        {

        }
    }
}