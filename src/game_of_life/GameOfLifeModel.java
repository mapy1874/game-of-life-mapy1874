package game_of_life;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameOfLifeModel {
	// true for live, false for death
	private boolean[][] _cells;
	private List<GameOfLifeObserver> observers;
	private int _width;
	private int _height;
	// if _lowBirthThreshold <= surrounding live cells <= _highBirthThreshold
	// the dead cell live, by default, the lbt = 3, hbt = 3;
	private int _lowBirthThreshold;
	private int _highBirthThreshold;
	// if _lowSurviveThreshold <= surrounding live cells <= _highSurviveThreshold
	// the cell live to next gen, by default, the lst = 2, hbt = 3;
	private int _lowSurviveThreshold;
	private int _highSurviveThreshold;

	// about 10% of cell will be alive if we randomly generate the board
	public static double DEFAULT_ALIVE_PROB = 0.1;

	public GameOfLifeModel(int width, int height, 
			int lowBirthThreshold, int highBirthThreshold ,
			int lowSurviveThreshold, int highSurviveThreshold) {
		observers = new ArrayList<GameOfLifeObserver>();
		setModel(width, height, 
				lowBirthThreshold, highBirthThreshold ,
				lowSurviveThreshold, highSurviveThreshold);
	}
	
	public GameOfLifeModel(int width, int height) {
		this(width, height, 3, 3, 2, 3);
	}
	
	public void setModel(int width, int height, 
			int lowBirthThreshold, int highBirthThreshold ,
			int lowSurviveThreshold, int highSurviveThreshold) {
		// TODO: Controller will verify the value of each parameter
		_width = width;
		_height = height;
		
		// initialize the threshold
		_lowBirthThreshold = lowBirthThreshold;
		_highBirthThreshold = highBirthThreshold;
		_lowSurviveThreshold = lowSurviveThreshold;
		_highSurviveThreshold = highSurviveThreshold;
		
		// all cells are dead at first
		_cells = new boolean[_width][_height];
		notifyObservers();
	}
	
	// return the status of the next generation
	// and change the value of _cells
	public void nextGen() {
		// store the next gen in this array first
		boolean[][] nextGen = new boolean[_width][_height];

		for (int x = 0; x < _width; x++) {
			for (int y = 0; y < _height; y++) {
				// TODO: update the isTorus para 
				int numOfAliveCells = numOfAliveCells(x, y, false);
				// if the cell is alive, use survive condition
				if (_cells[x][y]) {
					if (numOfAliveCells <= _highSurviveThreshold &&
							numOfAliveCells >= _lowSurviveThreshold) {
						// the cell survive to the next gen
						nextGen[x][y] = true;
					} else {
						// the cell will die
						nextGen[x][y] = false;
					}
				} else {// if the cell is dead, use birth threshold
					if (numOfAliveCells <= _highBirthThreshold &&
							numOfAliveCells >= _lowBirthThreshold) {
						// the dead cell alive
						nextGen[x][y] = true;
					} else {
						// the cell is still dead
						nextGen[x][y] = false;
					}
				}
			}
		}
		// safely pass the nextGen
		_cells = nextGen.clone();
		// use clone to avoid undesirable changes
		notifyObservers();
	}
	
	public void toggleCell (int x, int y) {
		if (x >= _width || y >= _height) {
			return;
		}
		// change the status of a cell
		_cells[x][y] = !_cells[x][y];
		notifyObservers();
	}
	
	// count the number of alive cells for a cell in (x, y)
	private int numOfAliveCells(int x, int y, boolean isTorus) {
		int numOfAliveCells = 0;
		ArrayList<Boolean> surroundingCells = getSurroundingCells(x, y, isTorus);
		for (boolean cell : surroundingCells) {
			// if the cell is alive
			if (cell) {
				numOfAliveCells++;
			}
		}
		return numOfAliveCells;
	}
	
	// randomlyGenerate 
	public void randomlyGenerate() {
		// randomly generate will restart the board
		clear();
		for (int x = 0; x < _width; x++) {
			for (int y = 0; y < _height; y++) {
				if (Math.random() < DEFAULT_ALIVE_PROB) {
					// the cell is alive by randomness
					_cells[x][y] = true;
				}
			}
		}
		notifyObservers();
	}
	
	// make all cells dead
	public void clear() {
		for (int x = 0; x < _width; x++) {
			for (int y  = 0; y < _height; y++) {
				_cells[x][y] = false;
			}
		}
		notifyObservers();
	}
	
	public boolean[][] getCells() {
		return _cells.clone();
	}

	public void addObserver(GameOfLifeObserver o) {
		observers.add(o);
	}
	
	public void removeObserver(GameOfLifeObserver o) {
		observers.remove(o);
	}
	
	private void notifyObservers() {
		System.out.println("GameOfLifeModel: notifyObservers");
		for (GameOfLifeObserver o : observers) {
			o.update(this);
		}
	}

	
	// get the boolean value of the surrounding cell at (x, y)
	private ArrayList<Boolean> getSurroundingCells(int x, int y, boolean isTorus) {
		ArrayList<Boolean> surroundingCells = new ArrayList<Boolean>();
		if (!isTorus) {
			if (x - 1 >= 0) {
				surroundingCells.add(_cells[x-1][y]);
			}
			if (y - 1 >= 0) {
				surroundingCells.add(_cells[x][y-1]);
			}
			if (x + 1 < _width) {
				surroundingCells.add(_cells[x+1][y]);
			}
			if (y + 1 < _height) {
				surroundingCells.add(_cells[x][y+1]);
			}
			if (x - 1 >= 0 &&  y - 1 >= 0) {
				surroundingCells.add(_cells[x-1][y-1]);
			}
			if (x + 1 < _width &&  y + 1 < _height) {
				surroundingCells.add(_cells[x+1][y+1]);
			}
			if (x - 1 >= 0 &&  y + 1 < _height) {
				surroundingCells.add(_cells[x-1][y+1]);
			}
			if (x + 1 < _width &&  y - 1 >= 0) {
				surroundingCells.add(_cells[x+1][y-1]);
			}

		} else {
			// the x (left, right) , y (up, down) for the cell in torus mode
			int left, down, right, up;
			if (x -1 < 0) {
				left = x - 1 + _width;
			} else {
				left = x-1;
			}
			if (y -1 < 0) {
				down = y - 1 + _height;
			} else {
				down = y-1;
			}
			if (x + 1 <= _width) {
				right = (x+1)%_width;
			} else {
				right = x+1;
			}
			if (y + 1 <= _height) {
				up = (y+1)%_height;
			} else {
				up = y+1;
			}
			surroundingCells.add(_cells[x][down]);
			surroundingCells.add(_cells[x][up]);
			surroundingCells.add(_cells[left][y]);
			surroundingCells.add(_cells[right][y]);
			surroundingCells.add(_cells[right][up]);
			surroundingCells.add(_cells[right][down]);
			surroundingCells.add(_cells[left][up]);
			surroundingCells.add(_cells[left][down]);
		}

		return surroundingCells;
	}

}
