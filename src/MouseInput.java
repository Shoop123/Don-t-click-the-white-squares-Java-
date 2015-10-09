import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput extends MoveUp implements MouseListener{

	private int x;
	private int y;
	private boolean call = true;
	static public Point[][] boxes = new Point[5][2];
	public boolean playerLost = false;
	static long startTime;
	static boolean upDate = false;
	static boolean startShowTime = false;
	static boolean pause = false;
	
	@Override
	public void mouseClicked(MouseEvent e) {
		x = e.getX();
		y = e.getY();

		if(call)
		{
			FindValue();
			startTime = System.nanoTime();
			startShowTime = true;
			call = false;
		}
		
		if(x > boxes[3][0].x && x < boxes[3][0].x + 100 && y > 600 && y < 800)
		{
			ChangeBoard();
			upDate = true;
		}
		else
			playerLost = true;
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		pause = false;
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		pause = true;
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		
	}
	
	private void FindValue()
	{	
		if(Canvas.draw.squares[0])
		{
			boxes[0][0] = new Point(0, 0);
			boxes[0][1] = new Point(101, 201);
		}
		else if(Canvas.draw.squares[1])
		{
			boxes[0][0] = new Point(100, 0);
			boxes[0][1] = new Point(101, 201);
		}
		else if(Canvas.draw.squares[2])
		{
			boxes[0][0] = new Point(200, 0);
			boxes[0][1] = new Point(101, 201);
		}
		else if(Canvas.draw.squares[3])
		{
			boxes[0][0] = new Point(300, 0);
			boxes[0][1] = new Point(101, 201);
		}
		
		
		if(Canvas.draw.squares[4])
		{
			boxes[1][0] = new Point(0, 200);
			boxes[1][1] = new Point(101, 201);
		}
		else if(Canvas.draw.squares[5])
		{
			boxes[1][0] = new Point(100, 200);
			boxes[1][1] = new Point(101, 201);
		}
		else if(Canvas.draw.squares[6])
		{
			boxes[1][0] = new Point(200, 200);
			boxes[1][1] = new Point(101, 201);
		}
		else if(Canvas.draw.squares[7])
		{
			boxes[1][0] = new Point(300, 200);
			boxes[1][1] = new Point(101, 201);
		}
		
		
		if(Canvas.draw.squares[8])
		{
			boxes[2][0] = new Point(0, 400);
			boxes[2][1] = new Point(101, 201);
		}
		else if(Canvas.draw.squares[9])
		{
			boxes[2][0] = new Point(100, 400);
			boxes[2][1] = new Point(101, 201);
		}
		else if(Canvas.draw.squares[10])
		{
			boxes[2][0] = new Point(200, 400);
			boxes[2][1] = new Point(101, 201);
		}
		else if(Canvas.draw.squares[11])
		{
			boxes[2][0] = new Point(300, 400);
			boxes[2][1] = new Point(101, 201);
		}
		
		
		if(Canvas.draw.squares[12])
		{
			boxes[3][0] = new Point(0, 600);
			boxes[3][1] = new Point(101, 201);
		}
		else if(Canvas.draw.squares[13])
		{
			boxes[3][0] = new Point(100, 600);
			boxes[3][1] = new Point(101, 201);
		}
		else if(Canvas.draw.squares[14])
		{
			boxes[3][0] = new Point(200, 600);
			boxes[3][1] = new Point(101, 201);
		}
		else if(Canvas.draw.squares[15])
		{
			boxes[3][0] = new Point(300, 600);
			boxes[3][1] = new Point(101, 201);
		}
	}
}






























