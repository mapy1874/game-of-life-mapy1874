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
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleAdvanceGame() {
		model.nextGen();
	}
	@Override
	public void handleRandomlyGenerate(SettingViewEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleRestart(SettingViewEvent e) {
		// TODO Auto-generated method stub
		
	}

}
