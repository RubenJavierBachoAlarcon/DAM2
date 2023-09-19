using System;

public class Neo
{
    Random rand = new Random();

    public Boolean isChossen;

    public Neo()
    {
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

    private Boolean getIsChossen()
    {
        return isChossen;
    }
}
