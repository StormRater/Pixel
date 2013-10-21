package pixelTypeClasses;

import java.awt.Color;
import org.newdawn.slick.Graphics;
import driverClasses.DriverClass;
import driverClasses.Pixel;
import driverClasses.WeightClass;

public class StonePixel extends Pixel
{

	public StonePixel(Color colorParam, int xPosition, int yPosition)
	{
		super(colorParam, xPosition, yPosition);
		this.paintColor = Color.GRAY;
		this.type = PixelType.STONE;
		this.weight = WeightClass.HEAVY;
	}
	
	public void update(Graphics g)
	{
		_G=g;
		JDriverClass.thCursor.pixelArray[this.xCoord][this.yCoord] = null;
		g.setColor(Color.black);
		drawPoint(g, this.xCoord*3, this.yCoord*3); //TODO: Add drawPoint Method
		//If there is an empty space below, take it
		if(this.yCoord < JDriverClass.thCursor.pixelArray[0].length-1)//gravity
			if(JDriverClass.thCursor.pixelArray[this.xCoord][this.yCoord+1] == null)
			{
				this.yCoord++;
			}
		//implement pixel 
		JDriverClass.thCursor.pixelArray[this.xCoord][this.yCoord] = this;
		
		//Draw the pixel
		g.setColor(this.paintColor);
		drawPoint(g, this.xCoord*3, this.yCoord*3); //TODO: Add drawPoint Method
		
		//TODO: add PixelType collisions (i.e. water < stone)
	}

	


}
