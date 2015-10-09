import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class Canvas extends JFrame {
	public static Drawings draw = new Drawings();
	public static MouseInput mi = new MouseInput();
	public static GetHighScore record = new GetHighScore();
	
	private BufferStrategy bs = null;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Canvas();
			}
		});
		draw.PickSquares();
	}

	public Canvas() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(400, 800);
		this.setVisible(true);
		this.setTitle("Don't click the white squares");
		this.setBackground(Color.white);
		
		this.createBufferStrategy(2);

		this.addMouseListener(mi);
	}

	private void DoubleBuffering(Graphics graphics) {
		bs = this.getBufferStrategy();

		try {
			graphics = bs.getDrawGraphics();

			draw.DrawBoard(graphics);
			draw.DrawSquare(graphics);
			draw.SquaresLeft(graphics);
			draw.LiveTime(graphics);
			draw.ShowHighScore(graphics);
			
		} finally {
			graphics.dispose();
		}

		bs.show();

		Toolkit.getDefaultToolkit().sync();
	}

	public void paint(Graphics g) {
		if(!mi.playerLost && MoveUp.i < 50)
			DoubleBuffering(g);
		else if(mi.playerLost)
			draw.LoseGame(g);
		else
			draw.EndGame(g);
		
		repaint();
	}
}
