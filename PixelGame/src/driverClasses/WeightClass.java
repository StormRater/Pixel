package driverClasses;

public enum WeightClass
{
	WEIGHTLESS(0), LIGHT(1), AVERAGE(2), HEAVY(3);


	private int PixelWeight=0;//the pixel's weight to determine which pixel is to sink below another
	
	private WeightClass(int weight)//constructor?
	{
		PixelWeight=weight;
	}
}
	
