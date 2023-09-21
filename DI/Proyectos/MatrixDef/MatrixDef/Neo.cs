using System;
namespace Matrix
{
    public class Neo : Character
    {
        Random rand = new Random();

        public bool isChossen;

        public Neo()
        {
            base.probDeath = 0;
        }

        public Neo(Neo original)
        {
            // Copiar las propiedades del objeto original

        }

        public void setRandomIsChossen()
        {
            int random = rand.Next(2);
            if (random == 0)
            {
                isChossen = true;
            }
            else
            {
                isChossen = false;
            }
        }

        public bool getIsChossen()
        {
            return isChossen;
        }
    }
}