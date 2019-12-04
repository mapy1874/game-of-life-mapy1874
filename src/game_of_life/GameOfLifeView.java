package game_of_life;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.text.NumberFormat;
import java.util.Hashtable;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.text.NumberFormatter;

public class GameOfLifeView extends JPanel{

	BoardView boardView;
	SettingView settingView;
	public GameOfLifeView(int width, int height) {
		this.setLayout(new BorderLayout());

		boardView = new BoardView(width, height);
		settingView = new SettingView();
		this.add(boardView, BorderLayout.CENTER);
		this.add(settingView, BorderLayout.EAST);
	}
	
	public void addActionListener(ActionListener l) {
		// the listener only add buttons
		settingView.addActionListener();
	}
	
	public void setBoardView(boolean[][] cells) {
		
	}

}
