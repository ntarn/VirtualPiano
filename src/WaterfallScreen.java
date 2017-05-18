import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import javax.sound.midi.MidiUnavailableException;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import org.jfugue.theory.Note;

import org.jfugue.realtime.RealtimePlayer;
/**
 * This class displays the "waterfall" functioning of the app, and implements the 
 * 
 * @author IvyHuang
 *
 */

//take 
public class WaterfallScreen extends JPanel{

	private JPanel waterfall, wf;
	private WaterfallKeyboard key;
	private ArrayList<Note> note;
	private Waterfall synth;
	public static final int WIDTH = 1195;
	public static final int HEIGHT = 800;
	private int count, interval;
	private Bars bluebar, greenbar;
	private ImageIcon blue, green;
	
	
	/**
	 * Creates a JPanel that displays the waterfall formatting of the 
	 */
	public WaterfallScreen() throws MidiUnavailableException{
		super();
		count = 0;
		interval = 0;
		waterfall = new JPanel();
		bluebar = new Bars("bluerect.png",70,100);
		greenbar = new Bars("greenrect.png", 70,100);
	//	wf = new JPanel();
		waterfall.setLayout(new BorderLayout());
		key = new WaterfallKeyboard(new RealtimePlayer());
		synth = new Waterfall( new Song ("mary had a little lamb"));
		note = new ArrayList<Note>();
		
		for (int i = 0; i<synth.getNotes().size(); i++){
			synth.getLength(i);
		}
		
		waterfall.setMinimumSize(new Dimension(500,400));
		setSize(WIDTH, HEIGHT);
		add(key, BorderLayout.SOUTH);
		setVisible(true);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		int width = getWidth();
	    int height = getHeight();
	    double rx = width/1195.0;
	    double ry = height/800.0;

	    Graphics2D g2 = (Graphics2D)g;
	    g2.scale(rx, ry);
	    
	    //not showing after resize
	    g2.setStroke(new BasicStroke(3));
	    
	    for(int i = 0; i<15 ; i++){
	    	g.drawRoundRect(75+(interval*count),0, 70, 650, 20, 20);
	    	interval = (1195-75)/15;
	    	count++;
	    }
	    
	 /*   for(int j = 0; j<synth.getNotes().size(); j++){
	    	
	    }
	    */
	    
	   repaint();
	}
	
	
	
	
}