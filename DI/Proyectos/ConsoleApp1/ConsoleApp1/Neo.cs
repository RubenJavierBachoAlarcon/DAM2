using System;

public class Neo
{
	Random rand = new Random();

	public boolean isChossen;

	public Neo()
	{
	}

	private void setRandomIsChossen()
	{
		int random = rand.nextInt();
		if (random == 0)
		{
			isChossen = true;
		}
		else
		{
			isChossen = false;
		}
	}

	private boolean getIsChossen()
	{
		return isChossen;
	}
}
