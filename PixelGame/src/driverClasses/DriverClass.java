package driverClasses;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class DriverClass extends BasicGame{

	public DriverClass(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void init(GameContainer container) throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		
		
	}
	
	public static void main(String[] args) throws SlickException {
		AppGameContainer app= new AppGameContainer(new DriverClass("Pixels"));
		
		app.setDisplayMode(800, 600, false);
		
		app.start();
	}

}
