import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

public class GetHighScore {
	
	File highScore = new File("High Score.dat");
	
	private FileReader fr;
	private BufferedReader br;
	private FileWriter fw;
	private BufferedWriter bw;
	String read;
	double score;
	String name;
	
	public GetHighScore()
	{
		if(!highScore.exists())
		{
			try
			{
				highScore.createNewFile();
			}catch(Exception e){e.printStackTrace();}
		}
	}
	
	public boolean CheckScore()
	{
		try
		{
			fr = new FileReader(highScore);
			br = new BufferedReader(fr);
			read = br.readLine();
		}catch (Exception e){e.printStackTrace();}
		
		if(read == null)
		{
			try
			{
				br.close();
			}catch(IOException io){io.printStackTrace();}
			return true;
		}
		else
		{
			score = Double.parseDouble(read.split(":")[1]);
			if(score > Drawings.finalTime)
			{
				try
				{
					br.close();
				}catch(IOException io){io.printStackTrace();}
				return true;
			}
				
			else
			{
				try
				{
					br.close();
				}catch(IOException io){io.printStackTrace();}
				return false;
			}
		}
	}
	
	public void WriteScore()
	{
		try
		{
			fw = new FileWriter(highScore);
			bw = new BufferedWriter(fw);
			bw.write(GotHighScore());
			bw.close();
		}catch(IOException io){io.printStackTrace();}
	}
	
	public String GotHighScore()
	{
		name = JOptionPane.showInputDialog("Type you name to save high score!");
		if(!name.equals("") && name != null)
			return name + ":" + Drawings.finalTime;
		else 
			return "Anon:" + ReadHighScore();
	}
	
	public String ReadHighScore()
	{
		try
		{
			fr = new FileReader(highScore);
			br = new BufferedReader(fr);
		}
		catch (FileNotFoundException fnf)
		{
			fnf.printStackTrace();
		}
		
		try
		{
			read = br.readLine();
		}catch(IOException io){io.printStackTrace();}
		finally{if(br != null) try{br.close();}catch(IOException io){io.printStackTrace();}}	
		
		if(read != null)
			return read;
		else
			return "0";
	}
	
	public double ReturnHighScore()
	{
		try
		{
			fr = new FileReader(highScore);
			br = new BufferedReader(fr);
			read = br.readLine();
		}catch (Exception e){e.printStackTrace();}
		
		if(read != null)
		{
			score = Double.parseDouble(read.split(":")[1]);
			return score;
		}
		else
			return 0;

	}
}



































