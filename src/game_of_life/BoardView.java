package game_of_life;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JPanel;


public class BoardView extends JPanel implements MouseListener{
	private static final int DEFAULT_SCREEN_WIDTH = 500;
	private static final int DEFAULT_SCREEN_HEIGHT = 500;
	
	// TODO: change the cell size after experiments
	// each cell will be 10px*10px at first
	private static final int DEFAULT_CELL_SIZE = 10;
	
	private int _width;
	private int _height;
	private int _cellSize;
	private boolean[][] _cells;
	private List<BoardViewListener> listeners;


	public BoardView(int width, int height) {
		setView(width, height);
		listeners = new ArrayList<BoardViewListener>();
		this.addMouseListener(this);
	}
	
	public void setView(int width, int height) {
		this.setBackground(Color.WHITE);
		_width = width;
		_height = height;
		_cellSize = DEFAULT_SCREEN_WIDTH/_width;
		this.setPreferredSize(new Dimension(_cellSize*_width,
				_cellSize*_width));
		_cells = new boolean[_width][_height];
		//repaint();
		System.out.println(_cells[0][0]);		
	}

	@Override
	public void paintComponent(Graphics g) {    
		// Super class paintComponent will take care of 
		// painting the background.
		super.paintComponent(g);
		System.out.println("BoardView: paintComponent");
		Graphics2D g2d = (Graphics2D) g.create();
	    g2d.setColor(Color.BLACK);
	    for (int x = 0; x < _width; x++) {
	    	for (int y = 0; y < _height; y++) {
	    		if (_cells[x][y]) {// if the cell is alive, paint it
	    			System.out.println("BoardView: paintComponent painting " + x +"," +y);
	    			g2d.fillRect(x*_cellSize, y*_cellSize, _cellSize, _cellSize);
	    		}
	    	}
	    }
	}  

	
	private void fireEvent(BoardViewEvent boardViewEvent) {
		for (BoardViewListener l : listeners) {
			l.handleBoardViewEvent(boardViewEvent);
			System.out.println("BoardView: fireEvent");
		}
	}
	
	public void addBoardViewListener(BoardViewListener l) {
		listeners.add(l);
	}
	
	public void removeBoardViewListener(BoardViewListener l) {
		listeners.remove(l);
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// convert the coord to the position in array
		int x = e.getX()/_cellSize;
		int y = e.getY()/_cellSize;
		if (x == _width) { //  hit the last pixel, so the x is _width-1
			x--;
		}
		if (y == _height) {//  hit the last pixel, so the y is _height-1
			y--;
		}
		System.out.println("BoardView: mouseClicked");
		// TODO: change the cell size later
		fireEvent(new BoardViewEvent(x, y));
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void paintBoardView(boolean[][] cells) {
		_cells = cells.clone();
		System.out.println("BoardView: paintBoardView");
		//this.paintComponent(this.getGraphics());
		this.repaint();
	}

}
