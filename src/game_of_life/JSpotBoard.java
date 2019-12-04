package game_of_life;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;

import javax.swing.JPanel;




public class JSpotBoard extends JPanel implements SpotBoard, MouseListener, ActionListener {

	private static final int DEFAULT_SCREEN_WIDTH = 500;
	private static final int DEFAULT_SCREEN_HEIGHT = 500;
	private static final Color DEFAULT_BACKGROUND_LIGHT = new Color(0.8f, 0.8f, 0.8f);
	private static final Color DEFAULT_BACKGROUND_DARK = new Color(0.5f, 0.5f, 0.5f);
	private static final Color DEFAULT_SPOT_COLOR = Color.BLACK;
	private static final Color DEFAULT_HIGHLIGHT_COLOR = Color.YELLOW;
	public static final int TIC_TAC_TOE = 1;
	public static final int CONNECT_FOUR = 2;
	public static final int OTHER = 3;

	
	private JSpot[][] _spots;
	private double _spot_size;// size of a single spot
	public JSpotBoard(int width, int height) {
		// TODO: EXCEPTION HANDLING
		setLayout(new GridLayout(height, width));
		_spots = new JSpot[width][height];
		
		
		Dimension preferred_size = new Dimension(DEFAULT_SCREEN_WIDTH/width, DEFAULT_SCREEN_HEIGHT/height);
		_spot_size = DEFAULT_SCREEN_WIDTH/width;
		for (int y=0; y<height; y++) {
			for (int x=0; x<width; x++) {
				Color bg = ((x+y)%2 == 0) ? DEFAULT_BACKGROUND_LIGHT : DEFAULT_BACKGROUND_DARK;
				_spots[x][y] = new JSpot(bg, DEFAULT_SPOT_COLOR, DEFAULT_HIGHLIGHT_COLOR, this, x, y);

//					_spots[x][y] = new JSpot(DEFAULT_BACKGROUND_LIGHT, 
//							DEFAULT_SPOT_COLOR, DEFAULT_HIGHLIGHT_COLOR, this, x, y);
				// fields only have spot, but actually they will be JSpot in the real life
				((JSpot)_spots[x][y]).setPreferredSize(preferred_size);
				add(((JSpot) _spots[x][y]));
			}			
		}
		
		this.addMouseListener(this);
	}

	// Getters for SpotWidth and SpotHeight properties
	
	@Override
	public int getSpotWidth() {
		return _spots.length;
	}
	
	@Override
	public int getSpotHeight() {
		return _spots[0].length;
	}

	// Lookup method for Spot at position (x,y)
	
	@Override
	public Spot getSpotAt(int x, int y) {
		if (x < 0 || x >= getSpotWidth() || y < 0 || y >= getSpotHeight()) {
			throw new IllegalArgumentException("Illegal spot coordinates");
		}
		
		return _spots[x][y];
	}
	
	// Convenience methods for (de)registering spot listeners.
	
	@Override
	public void addSpotListener(SpotListener spot_listener) {
		for (int x=0; x<getSpotWidth(); x++) {
			for (int y=0; y<getSpotHeight(); y++) {
				_spots[x][y].addSpotListener(spot_listener);
			}
		}
		// better way to use it
//		for (Spot s: this) {
//			s.addSpotListener(spot_listener);
//		}
	}
	
	@Override
	public void removeSpotListener(SpotListener spot_listener) {
		for (int x=0; x<getSpotWidth(); x++) {
			for (int y=0; y<getSpotHeight(); y++) {
				_spots[x][y].removeSpotListener(spot_listener);
			}
		}
	}

	@Override
	public Iterator<Spot> iterator() {
		return new SpotBoardIterator(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Mouse clicked");

		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Mouse Entered");
		int x = (int) (e.getPoint().x/_spot_size);
		int y = e.getPoint().y;
		(_spots[x][y]).paintComponent(_spots[x][y].getGraphics());
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
