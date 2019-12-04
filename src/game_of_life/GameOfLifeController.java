package game_of_life;

import javax.swing.SwingUtilities;

public class GameOfLifeController implements BoardViewListener, SettingViewListener,
				GameOfLifeObserver, Runnable {

	BoardView boardView;
	SettingView settingView;
	GameOfLifeModel model;
	
	public GameOfLifeController(GameOfLifeModel model, 	BoardView boardView,
			SettingView settingView) {
		this.boardView = boardView;
		this.settingView = settingView; 
		this.model = model;
		//  add
		boardView.addBoardViewListener(this);
		settingView.addSettingViewListener(this);
		model.addObserver(this);
	}
	@Override
	public void handleBoardViewEvent(BoardViewEvent e) {
		System.out.println("GameOfLifeController: handleBoardViewEvent");
		model.toggleCell(e.getX(), e.getY());
	}

	@Override
	public void update(GameOfLifeModel model) {
		// repaint the new board
		System.out.println("GameOfLifeController: update");
		boardView.paintBoardView(model.getCells());
	}
	@Override
	public void handleSettingViewEvent(SettingViewEvent e) {
		// the model and the board need to be reconstruct
		System.out.println("GameOfLifeController: handleSettingViewEvent");
		boardView.setView(e.getWidth(), e.getHeight());
		model.setModel(e.getWidth(), e.getHeight(),
				e.getLowBirthThreshold(), e.getHighBirthThreshold(),
				e.getLowSurviveThreshold(), e.getHighSurviveThreshold(), e.IsTorus());
	}
	
	@Override
	public void handleAdvanceGame() {
		model.nextGen();
	}
	@Override
	public void handleRandomlyGenerate() {
		model.randomlyGenerate();
	}

	@Override
	public void handleRestart() {
		model.clear();
	}
	private boolean _isAutoStart;
	private int _delay;

	@Override
	public void handleAutoStart(boolean isAutoStart, int delay) {
		_isAutoStart = isAutoStart;
		_delay = delay;
		if (_isAutoStart) { // need to proceed the game automatically
			new Thread(this).start();
		} else {// do nothing
		}
	}
	@Override
	public void run() {
		while(_isAutoStart) {
				model.nextGen();
				try {
					Thread.sleep(_delay);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Controller: run");				
		}
	}

}
