package game_of_life;

public class GameOfLifeController implements BoardViewListener, SettingViewListener, GameOfLifeObserver {

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
		// TODO Auto-generated method stub
		model.clear();
	}

}
