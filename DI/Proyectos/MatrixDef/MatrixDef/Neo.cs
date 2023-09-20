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

        private void setRandomIsChossen()
        {
            int random = (int)rand.NextInt64();
            if (random == 0)
            {
                isChossen = true;
            }
            else
            {
                isChossen = false;
            }
        }

        private bool getIsChossen()
        {
            return isChossen;
        }
    }
}