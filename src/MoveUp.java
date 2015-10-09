import java.awt.Point;
import java.util.Random;


public class MoveUp{
	
	private Random rnd = new Random();
	private int num;
	protected boolean hit = false;
	static protected boolean start = true;
	static protected boolean redraw = false;
	static protected int i = 0;
	
	public void ChangeBoard()
	{	
		MouseInput.boxes[4][0] = MouseInput.boxes[3][0];
		MouseInput.boxes[4][1] = MouseInput.boxes[3][1];
		
		MouseInput.boxes[3][0] = MouseInput.boxes[2][0];
		MouseInput.boxes[3][1] = MouseInput.boxes[2][1];
		
		MouseInput.boxes[2][0] = MouseInput.boxes[1][0];
		MouseInput.boxes[2][1] = MouseInput.boxes[1][1];
		
		MouseInput.boxes[1][0] = MouseInput.boxes[0][0];
		MouseInput.boxes[1][1] = MouseInput.boxes[0][1];
		
		MouseInput.boxes[0][0] = GetNewPoint();
		MouseInput.boxes[0][1] = new Point(101, 201);
		
		start = false;
		redraw = true;
		i++;
	}
	
	private Point GetNewPoint()
	{
		num = rnd.nextInt(4) + 1;
		Point value = null;
		
		switch(num)
		{
		case 1:
			value = new Point(0, 0);
			break;
		case 2:
			value = new Point(100, 0);
			break;
		case 3:
			value = new Point(200, 0);
			break;
		case 4:
			value = new Point(300, 0);
			break;
		}
		
		return value;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
