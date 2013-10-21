package pixelTypeClasses;

import java.awt.*;

import driverClasses.DriverClass;
import driverClasses.Pixel;
import driverClasses.WeightClass;

public class WaterPixel extends Pixel {

	public WaterPixel(Color colorParam, int xPosition, int yPosition) {
		super(colorParam, xPosition, yPosition);
		this.paintColor = Color.blue;
		this.type = PixelType.WATER;
		this.weight = WeightClass.AVERAGE;
	}
	
	public void update(Graphics g)
	{
		_G=g;
		//Destroy the old pixel
		JDriverClass.thCursor.pixelArray[this.xCoord][this.yCoord] = null;
		g.setColor(Color.black);
		g.drawPoint(this.xCoord*3, this.yCoord*3); //TODO: Add drawPoint Method
		//If there is an empty space below, take it
		if(this.yCoord < JDriverClass.thCursor.pixelArray[0].length-1)//gravity
			if(JDriverClass.thCursor.pixelArray[this.xCoord][this.yCoord+1] == null)
			{
				this.yCoord++;
			}
		//Randomly decide whether to spread right or left
		if(this.xCoord < JDriverClass.thCursor.pixelArray.length-1 && this.xCoord > 0)
			if(JDriverClass.thCursor.pixelArray[this.xCoord+1][this.yCoord] == null && JDriverClass.thCursor.pixelArray[this.xCoord-1][this.yCoord] == null)
			{
				if(Math.random()*10 > 5)
				{
					this.xCoord--;
				}else{
					this.xCoord++;
				}
			}
		//Spread right if blocked
		if(this.xCoord < JDriverClass.thCursor.pixelArray.length-1 && this.xCoord > 0)
			if(JDriverClass.thCursor.pixelArray[this.xCoord+1][this.yCoord] == null && JDriverClass.thCursor.pixelArray[this.xCoord-1][this.yCoord] != null)
			{
				this.xCoord++;
			}
		//Spread left if blocked
		if(this.xCoord < JDriverClass.thCursor.pixelArray.length-1 && this.xCoord > 0)
			if(JDriverClass.thCursor.pixelArray[this.xCoord-1][this.yCoord] == null && JDriverClass.thCursor.pixelArray[this.xCoord+1][this.yCoord] != null)
			{
				this.xCoord--;
			}
		//Reassign your position
		JDriverClass.thCursor.pixelArray[this.xCoord][this.yCoord] = this;
		//Draw the pixel
		g.setColor(this.paintColor);
		g.drawPoint(this.xCoord*3, this.yCoord*3); //TODO: Add drawPoint Method
	}
}
