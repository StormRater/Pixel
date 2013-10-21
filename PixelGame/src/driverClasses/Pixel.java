package driverClasses;

import java.awt.Color;

import org.newdawn.slick.Graphics;

import pixelTypeClasses.PixelType;

public abstract class Pixel
{
	public static Graphics _G;
	public int xCoord, yCoord;
	public double time;
	public Color paintColor;
	public WeightClass weight = WeightClass.WEIGHTLESS;
	public PixelType type = PixelType.BASESOLID;
	
	public Pixel(Color colorParam, int xPosition, int yPosition)
	{
		xCoord=xPosition;//gets x coordinate for pixel from cursor
		yCoord=yPosition;//gets y coordinate ^
		paintColor = colorParam;
	}
	
	public void update(Graphics g){}
	
	//gravity------------------------------------------------->
	/*public void pixelGravity()
	{
		//int meters;
		//int seconds;
		double gravity=(-9.8);
		
		//until the pixel hits the edge of the applet, keep alive
		//as it falls, erase the old image of it and paint a new one at new coordinates.
	}*/

	//paintColor---------------------------------------------->
	public Color getPaintColor() {return paintColor;}
	
	public void setPaintColor(int colorRed, int colorGreen, int colorBlue)
	{this.paintColor = new Color(colorRed,colorGreen,colorBlue);}
	
	//xCoord-------------------------------------------------->
	public int getXCoord(){return xCoord;}
	
	public void setXCoord(int newxCoord){xCoord=newxCoord;}
	
	//yCoord-------------------------------------------------->
	public int getYCoord(){return yCoord;}
	
	public void setYCoord(int newyCoord){yCoord=newyCoord;}

}
