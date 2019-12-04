package game_of_life;


public class BoardViewEvent {
	// store the position of the cell in a 2D array
	private int _x;
	private int _y;
	public BoardViewEvent(int x, int y) {
		_x = x;
		_y = y;
	}
	
	public int getX() {
		return _x;
	}
	
	public int getY() {
		return _y;
	}
}
