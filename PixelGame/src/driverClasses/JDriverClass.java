package driverClasses;

import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

import pixelTypeClasses.StonePixel;
import pixelTypeClasses.WaterPixel;


public class JDriverClass extends JFrame
	implements MouseListener, MouseMotionListener
{
	public ImageIcon[] ElementShown={new ImageIcon("pixelFlame.png"),new ImageIcon("pixelStone.png"),new ImageIcon("pixelWater.png")};
	private static final long serialVersionUID = 1L;
	private int buttonPressed = 0,xCoord, yCoord,x = 640,y = 480;
	public int numberOfPixels;
	private boolean mouseButton;
	//pixel array 2D
	public Pixel[][] pixelArray = null;//sets the array to null so as to have it ready for values to be placed
	public Graphics theGraphics;
	public Timer theTimer = new Timer();//this 
	public TimerTask theTask = new Engine(this);
	public static JDriverClass thCursor = null;
	
	
	public static void main(String[] args)
	{
		new JDriverClass();

	}
	//zNOTE: double buffer: paint(Graphics t); set(Graphics g(t));
	public JDriverClass()
	{
		int width=10,height=5;
		
		//JFrame constructs
		this.setSize(x,y);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Picture Element Box");
		this.setVisible(true);
		
		//MUTHAFACKIN BUTT ONS
		JRadioButton waterPixelButton = new JRadioButton("Water");//button
			waterPixelButton.setSize(width, height);
			waterPixelButton.setAlignmentX(width);
			waterPixelButton.setAlignmentY(10);
			waterPixelButton.setVisible(true);
			
		JRadioButton firePixelButton = new JRadioButton("Fire");
			firePixelButton.setSize(width,height);
			firePixelButton.setAlignmentX(width);
			firePixelButton.setAlignmentY(15);
			firePixelButton.setVisible(true);
			
		JRadioButton stonePixelButton = new JRadioButton("Stone");
			stonePixelButton.setSize(width,height);
			stonePixelButton.setAlignmentX(width);
			stonePixelButton.setAlignmentY(20);
			stonePixelButton.setVisible(true);
			
		
		//Cursor constructs
		xCoord=0;
		yCoord=0;
		mouseButton=false;
		JDriverClass.thCursor = this;
	}
	
	public void init()
	{
		pixelArray = new Pixel[x/3][y/3];//initiates the pixel array
		numberOfPixels=0;//number of pixels on the screen
						//it is incremented with each 
		theTimer.scheduleAtFixedRate(theTask, 0, (long) 100/*this is the refresh rate*/);// refreshes the screen
	}
	
	public void paint(Graphics t)
	{
		Graphics _T = t;
		t.setBackground(t, Color.white);
		this.theGraphics = t;//theGraphics is defined as 
							//the current graphics being used
		for(Pixel[] element : pixelArray)//displays and updates the shown pixels
		{
			for(Pixel elements : element)
			{
				if(elements != null)
					elements.update(t);
			}
		}
	}
	
	public boolean mouseMove(Event e, int x, int y)
	{
		xCoord = x;//mouse coords
		yCoord = y;
		return true;
	}
	
	public boolean mouseDrag(Event e, int x, int y)
	{
		this.pixelArray[x/3][y/3] = new StonePixel(null, x/3, y/3);//TODO: Add ability to change pixel
																		 // based on mouse scroll bar
		return true;
	}
	
	public boolean mouseDown(Event e, int x, int y)///TODO
	{
		this.setXposi(x);
		this.setYposi(y);
		switch(buttonPressed)
		{
			case 0: /*do nothing*/ break;
			case 1: this.pixelArray[x/3][y/3] = new WaterPixel(Color.blue, x/3, y/3);//places a pixel
					/*first button*/break;
			case 2: /*second button*/break;
			case 3: /*third button*/break;
			case 4: /*fourth button*/break;
		}
		this.pixelArray[x/3][y/3] = new WaterPixel(Color.blue, x/3, y/3);//places a pixel
		return true;
	}

	
	//xCoord-------------Mouse object coordinates---------->
	
	public int getXposi()
	{return xCoord;}
	
	public void setXposi(int xPos)
	{xCoord=xPos;}
	
	//yCoord
	public int getYposi()
	{return yCoord;}
	
	public void setYposi(int yPos)
	{yCoord=yPos;}
	
	//mouseClicked--------------set/get--------------------------->
	
	public void setMouseClick(boolean position)//true or false to having the left button on mouse clicked
	{mouseButton=position;}
	
	
	public boolean getMouseClicked()//unused
	{return mouseButton;}

	public Graphics getGraphicsG(){return Pixel._G;}
	
	//events------------------------------------------------>
	
	@Override
	public void mouseDragged(MouseEvent e){}

	@Override
	public void mouseMoved(MouseEvent e){}

	@Override
	public void mouseClicked(MouseEvent e){}

	@Override
	public void mousePressed(MouseEvent e){}

	@Override
	public void mouseReleased(MouseEvent e){}

	@Override
	public void mouseEntered(MouseEvent e){}

	@Override
	public void mouseExited(MouseEvent e){}

}
