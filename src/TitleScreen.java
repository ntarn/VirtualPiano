import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * This class displays the title screen of the application (what shows up when the user runs the program)
 * @author Ivy Huang
 */
public class TitleScreen extends JPanel {
		/*
		 * instructions, keyboard, synthesia, 
		 */
	private JPanel title, btnpnl, inst;
	private JLabel info;
	public static final int WIDTH = 1125;
	public static final int HEIGHT = 800;
	private Image background, id;
	private CardLayout c;
	private WaterfallScreen w;
	private ScoreScreen s;
	private JButton instructions, waterfall, keyboard;
	
	/**
	 * Creates the title screen/main screen with the main menu and makes it visible to the user.
	 */
	public TitleScreen(){
		super();
		//c = new CardLayout();
		title = new JPanel();
		setMinimumSize(new Dimension(500,400));
		setLayout(c);

	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		int width = getWidth();
	    int height = getHeight();
	    double rx = width/1125.0;
	    double ry = height/800.0;

	    Graphics2D g2 = (Graphics2D)g;
	    g2.scale(rx, ry);
	    id = (new ImageIcon("titleid.png")).getImage();
	    background = (new ImageIcon("piano.jpg")).getImage();
	    g.drawImage(background, 0, 0, null);
	    g.drawImage(id, WIDTH/2, HEIGHT/10, this);
	    
	    repaint();
	}
	

}