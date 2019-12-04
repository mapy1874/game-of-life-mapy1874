package game_of_life;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Main {
	public static void main(String[] args) {
		// create top level window
		JFrame main_frame = new JFrame();
		main_frame.setTitle("Game of Life");
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// create panel for content, using BorderLayout
		JPanel top_panel = new JPanel();
		top_panel.setLayout(new BorderLayout());
		main_frame.setContentPane(top_panel);
		
		GameOfLifeModel model = new GameOfLifeModel(50, 50);
		BoardView boardView = new BoardView(50, 50);
		SettingView settingView = new SettingView();
		GameOfLifeController controller = new GameOfLifeController(model,boardView, settingView);
		top_panel.add(boardView, BorderLayout.CENTER);
		top_panel.add(settingView, BorderLayout.EAST);
		// pack main_frame and make it visible
		main_frame.pack();
		main_frame.setVisible(true);
	}

}
