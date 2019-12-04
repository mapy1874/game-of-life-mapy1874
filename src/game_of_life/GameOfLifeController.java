package game_of_life;

public class GameOfLifeController implements BoardViewListener, GameOfLifeObserver {

	BoardView boardView;
	SettingView settingView;
	GameOfLifeModel model;
	
	public GameOfLifeController(GameOfLifeModel model, 	BoardView boardView,
			SettingView settingView) {
		this.boardView = boardView;
		this.settingView = settingView;
		this.model = model;
		
		boardView.addBoardViewListener(this);
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

}
