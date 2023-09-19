using System;
using System.Net.NetworkInformation;

public class Smith
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

