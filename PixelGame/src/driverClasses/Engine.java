package driverClasses;

public class Engine extends java.util.TimerTask {
	
	public JDriverClass parent = null;
	
	public Engine(JDriverClass jDriverClass)
	{
		parent = jDriverClass;
	}
	
	@Override
	public void run() {
		parent.paint(parent.getGraphics());
	}
}
// add double buffering
// single pixel replacement