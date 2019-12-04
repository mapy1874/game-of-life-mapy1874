package game_of_life;

public class SettingViewEvent {
	// the event contains all information to set the game
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
	private boolean _isTorus;
	// TODO: implement this after finish the basic part
	private int _delay;

	public SettingViewEvent(int width, int height, int lowBirthThreshold, int highBirthThreshold,
			int lowSurviveThreshold, int highSurviveThreshold, int delay, boolean isTorus) {
		// TODO: Controller will verify the value of each parameter
		_width = width;
		_height = height;
		// initialize the threshold
		_lowBirthThreshold = lowBirthThreshold;
		_highBirthThreshold = highBirthThreshold;
		_lowSurviveThreshold = lowSurviveThreshold;
		_highSurviveThreshold = highSurviveThreshold;
		_delay = delay;
		_isTorus = isTorus;
	}

	public int getWidth() {
		return _width;
	}

	public int getHeight() {
		return _height;
	}

	public int getLowBirthThreshold() {
		return _lowBirthThreshold;
	}

	public int getHighBirthThreshold() {
		return _highBirthThreshold;
	}

	public int getLowSurviveThreshold() {
		return _lowSurviveThreshold;
	}

	public int getHighSurviveThreshold() {
		return _highSurviveThreshold;
	}

	public int getDelay() {
		return _delay;
	}

	public boolean IsTorus() {
		return _isTorus;
	}
}
