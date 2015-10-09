import java.awt.Color;
import java.awt.Graphics;
import java.text.DecimalFormat;
import java.util.Random;

public class Drawings{

	private Random rnd = new Random();
	
	public boolean[] squares = new boolean[16];
	
	private boolean stop = false;
	private boolean  recordScore = true;
	
	private double endTime;
	public static double finalTime;
	private String squaresLeft;
	private String highScore;

	
	public void DrawBoard(Graphics graphics)
	{
		for(int x = 1; x <= 400; x+= 100)
			graphics.drawLine(x, 0, x, 800);
		
		for(int y = 1; y <= 800; y += 200)
			graphics.drawLine(0, y, 400, y);
	}
	
	public void PickSquares()
	{
		int firstSquare = rnd.nextInt(4) + 1;
		
		switch(firstSquare)
		{
		case 1:
			squares[0] = true;
			break;
		case 2:
			squares[1] = true;
			break;
		case 3:
			squares[2] = true;
			break;
		case 4:
			squares[3] = true;
			break;
		}
		
		int secondSquare = rnd.nextInt(4) + 1;
		
		switch(secondSquare)
		{
		case 1:
			squares[4] = true;
			break;
		case 2:
			squares[5] = true;
			break;
		case 3:
			squares[6] = true;
			break;
		case 4:
			squares[7] = true;
			break;	
		}
		
		int thirdSquare = rnd.nextInt(4) + 1;
		
		switch(thirdSquare)
		{
		case 1:
			squares[8] = true;
			break;
		case 2:
			squares[9] = true;
			break;
		case 3:
			squares[10] = true;
			break;
		case 4:
			squares[11] = true;
			break;	
		}
		
		int fourthSquare = rnd.nextInt(4) + 1;
		
		switch(fourthSquare)
		{
		case 1:
			squares[12] = true;
			break;
		case 2:
			squares[13] = true;
			break;
		case 3:
			squares[14] = true;
			break;
		case 4:
			squares[15] = true;
			break;	
		}
	}
	
	public void DrawSquare(Graphics graphics)
	{
		if(MoveUp.start)
		{
			for(int i = 0; i <= 3; i++)
			{
				if(squares[i])
				{
					graphics.fillRect(i * 100 + 5, 5, 93, 193);
					break;
				}
			}
			
			for(int i = 4; i <= 7; i++)
			{
				if(squares[i])
				{
					graphics.fillRect((i-4) * 100 + 5, 205, 93, 193);
					break;
				}
			}
			
			for(int i = 8; i <= 11; i++)
			{
				if(squares[i])
				{
					graphics.fillRect((i-8) * 100 + 5, 405, 93, 193);
					break;
				}
			}
			
			for(int i = 12; i <= 15; i++)
			{
				if(squares[i])
				{
					graphics.fillRect((i-12) * 100 + 5, 605, 93, 193);
					break;
				}
			}
		}
		
		else if(MoveUp.redraw)
		{
			graphics.setColor(Color.white);
			graphics.fillRect(MouseInput.boxes[4][0].x, 600, 101, 200);
			graphics.fillRect(MouseInput.boxes[3][0].x, 400, 101, 200);
			graphics.fillRect(MouseInput.boxes[2][0].x, 200, 101, 200);
			graphics.fillRect(MouseInput.boxes[1][0].x, 0, 101, 200);
			
			graphics.setColor(Color.green);
			graphics.fillRect(MouseInput.boxes[3][0].x + 5, 605, 93, 193);
			
			if(MoveUp.i < 49)
				graphics.fillRect(MouseInput.boxes[2][0].x + 5, 405, 93, 193);
			if(MoveUp.i < 48)
				graphics.fillRect(MouseInput.boxes[1][0].x + 5, 205, 93, 193);
			if(MoveUp.i < 47)
				graphics.fillRect(MouseInput.boxes[0][0].x + 5, 5, 93, 193);
			
			MoveUp.redraw = false;
		}
	}
	
	public void LoseGame(Graphics graphics)
	{
		
		if(!stop)
		{
			graphics.setColor(Color.red);
			graphics.fillRect(0, 0, 400, 800);	
			stop = true;
			endTime = (System.nanoTime() - MouseInput.startTime) / 1000000;
			finalTime = endTime / 1000;
		}
		else
		{
			graphics.setColor(Color.black);
			graphics.drawString("You Lose!" + " You survived for: " + finalTime + " Seconds", 75, 398);
		}
	}
	
	public void EndGame(Graphics graphics)
	{
		if(!stop)
		{
			graphics.setColor(Color.green);
			graphics.fillRect(0, 0, 400, 800);	
			stop = true;
			endTime = (System.nanoTime() - MouseInput.startTime) / 1000000;
			finalTime = endTime / 1000;
		}
		else
		{
			graphics.setColor(Color.black);
			graphics.drawString("It took you: " + finalTime + " Seconds", 75, 398);
		}
		
		if(Canvas.record.CheckScore())
			Canvas.record.WriteScore();
	}
	
	public void SquaresLeft(Graphics graphics)
	{
		graphics.setColor(Color.red);
		squaresLeft = String.valueOf(50 - MoveUp.i);
		if(MouseInput.upDate)
		{
			graphics.clearRect(375, 785, 25, 15);
			MouseInput.upDate = false;
		}
		graphics.drawString(squaresLeft, 380, 795);
	}
	
	public void LiveTime(Graphics graphics)
	{
		if(MouseInput.startShowTime && MouseInput.pause == false)
		{
			endTime = (System.nanoTime() - MouseInput.startTime) / 1000000;
			finalTime = endTime / 1000;
			finalTime = RoundTo2Decimal(finalTime);
			graphics.drawString("Time: " + finalTime, 115, 597);
			graphics.clearRect(114, 588, 80, 10);
			graphics.drawString("Time: " + finalTime, 115, 597);
		}
	}
	
	private double RoundTo2Decimal(double number)
	{
		DecimalFormat twoDecimalPlaces = new DecimalFormat("##.##");
		return Double.valueOf(twoDecimalPlaces.format(number));
	}
	
	public void ShowHighScore(Graphics graphics)
	{
		if(!recordScore)
		{
			graphics.setColor(Color.blue);
			graphics.drawString("Current High Score : " + highScore, 10, 40);
		}else{highScore = String.valueOf(Canvas.record.ReturnHighScore()); recordScore = false;}
	}
}














































