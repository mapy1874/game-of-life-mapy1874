package game_of_life;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JToggleButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.NumberFormatter;

public class SettingView extends JPanel implements ActionListener{
	public static final int DEFAULT_LOW_BIRTH_THRESHOLD = 3;
	public static final int DEFAULT_HIGH_BIRTH_THRESHOLD = 3;
	public static final int DEFAULT_LOW_SURVIVE_THRESHOLD = 2;
	public static final int DEFAULT_HIGH_SURVIVE_THRESHOLD = 3;
	public static final int DEFAULT_DELAY = 500;
	private JPanel setSizePanel;
	private JSlider setSizeSlider;
	
	
	private JPanel lifeDeathPanel;
	private JSlider lowBirthThresholdSlider;
	private JSlider highBirthThresholdSlider;
	private JSlider lowSurviveThresholdSlider;
	private JSlider highSurviveThresholdSlider;

	
	private JPanel startStopPanel;
	private JToggleButton startToggleButton;
	private JSlider delaySlider;
	
	private JToggleButton torusToggleButton;
	
	private JButton applyParasButton;
	private JButton advanceGameButton;
	private JButton randomlyGenerateButton;
	private JButton restartButton;
	private JLabel reminderLabel;
	private List<SettingViewListener> listeners;
	public SettingView() {
		//TODO: add text to make user know the next step
		listeners = new ArrayList<SettingViewListener>();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		// setSizePanel
		setSizePanel = new JPanel();
		setSizePanel.setLayout(new BoxLayout(setSizePanel, BoxLayout.Y_AXIS));
		setSizeSlider = new JSlider(10, 500);
		JLabel setSizeLabel = new JLabel("Size of the board(10 to 500): ");
	    Hashtable<Integer, JLabel> table1 = new Hashtable<Integer, JLabel>();
	    table1.put (10, new JLabel("10"));
	    table1.put (100, new JLabel("100"));
	    table1.put (200, new JLabel("200"));
	    table1.put (300, new JLabel("300"));
	    table1.put (400, new JLabel("400"));
	    table1.put (500, new JLabel("500"));
	    setSizeSlider.setPaintLabels(true);
	    setSizeSlider.setLabelTable(table1);
	    setSizeSlider.setValue(50);
	    setSizeSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
		        if (!setSizeSlider.getValueIsAdjusting()) {
					reminderLabel.setText("<html>Size of the board£º " +setSizeSlider.getValue()
					+ "*"+setSizeSlider.getValue()+".<br>Click APPLY button to apply.</html>");
		        }				
			}
	    });

	    setSizePanel.add(setSizeLabel);
		setSizePanel.add(setSizeSlider);
		this.add(setSizePanel);
		
		// lifeDeathPanel
		lifeDeathPanel = new JPanel();
		lifeDeathPanel.setLayout(new BoxLayout(lifeDeathPanel, BoxLayout.Y_AXIS));
	    Hashtable<Integer, JLabel> table = new Hashtable<Integer, JLabel>();
	    table.put (0, new JLabel("0"));
	    table.put (2, new JLabel("2"));
	    table.put (4, new JLabel("4"));
	    table.put (6, new JLabel("6"));
	    table.put (8, new JLabel("8"));

		lowBirthThresholdSlider = new JSlider(0, 8);
		lowBirthThresholdSlider.setPaintLabels(true);
	    lowBirthThresholdSlider.setLabelTable (table);
	    lowBirthThresholdSlider.setValue(DEFAULT_LOW_BIRTH_THRESHOLD);
	    lowBirthThresholdSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
		        if (!lowBirthThresholdSlider.getValueIsAdjusting()) {
					reminderLabel.setText("<html>Low Birth Threshold£º " +lowBirthThresholdSlider.getValue()
					+".<br>Click APPLY button to apply.</html>");
		        }				
			}
	    });

		highBirthThresholdSlider = new JSlider(0, 8);
		highBirthThresholdSlider.setPaintLabels(true);
		highBirthThresholdSlider.setLabelTable (table);
		highBirthThresholdSlider.setValue(DEFAULT_HIGH_BIRTH_THRESHOLD);
		highBirthThresholdSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
		        if (!highBirthThresholdSlider.getValueIsAdjusting()) {
					reminderLabel.setText("<html>High Birth Threshold£º " +highBirthThresholdSlider.getValue()
					+".<br>Click APPLY button to apply.</html>");
		        }				
			}
	    });

		
		lowSurviveThresholdSlider = new JSlider(0, 8);
		lowSurviveThresholdSlider.setPaintLabels(true);
		lowSurviveThresholdSlider.setLabelTable (table);
		lowSurviveThresholdSlider.setValue(DEFAULT_LOW_SURVIVE_THRESHOLD);
		lowSurviveThresholdSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
		        if (!lowSurviveThresholdSlider.getValueIsAdjusting()) {
					reminderLabel.setText("<html>Low Survive Threshold£º " +lowSurviveThresholdSlider.getValue()
					+".<br>Click APPLY button to apply.</html>");
		        }				
			}
	    });

		highSurviveThresholdSlider = new JSlider(0, 8);
		highSurviveThresholdSlider.setPaintLabels(true);
		highSurviveThresholdSlider.setLabelTable (table);
		highSurviveThresholdSlider.setValue(DEFAULT_HIGH_SURVIVE_THRESHOLD);
		highSurviveThresholdSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
		        if (!highSurviveThresholdSlider.getValueIsAdjusting()) {
					reminderLabel.setText("<html>High Survive Threshold£º " +highSurviveThresholdSlider.getValue()
					+".<br>Click APPLY button to apply.</html>");
		        }				
			}
	    });


		lifeDeathPanel.add(new JLabel("Low birth threshold: "));
		lifeDeathPanel.add(lowBirthThresholdSlider);
		lifeDeathPanel.add(new JLabel("High birth threshold: "));
		lifeDeathPanel.add(highBirthThresholdSlider);
		lifeDeathPanel.add(new JLabel("Low survive threshold: "));
		lifeDeathPanel.add(lowSurviveThresholdSlider);
		lifeDeathPanel.add(new JLabel("High survive threshold: "));
		lifeDeathPanel.add(highSurviveThresholdSlider);
		this.add(lifeDeathPanel);
		

		JPanel togglePanel = new JPanel();
		togglePanel.setLayout(new FlowLayout());
		torusToggleButton = new JToggleButton("Torus");
		torusToggleButton.setAlignmentX(CENTER_ALIGNMENT);
		torusToggleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				reminderLabel.setText("Torus mode£º " +torusToggleButton.isSelected());
			}
		});
		
		togglePanel.add(torusToggleButton);
		this.add(togglePanel);
		
		applyParasButton = new JButton("Apply the above settings");
		applyParasButton.setAlignmentX(CENTER_ALIGNMENT);
		this.add(applyParasButton);

		
		// startStopPanel
		startStopPanel = new JPanel();
		startStopPanel.setLayout(new BoxLayout(startStopPanel, BoxLayout.Y_AXIS));
	    Hashtable<Integer, JLabel> table2 = new Hashtable<Integer, JLabel>();
	    table2.put (10, new JLabel("10"));
	    table2.put (200, new JLabel("200"));
	    table2.put (400, new JLabel("400"));
	    table2.put (600, new JLabel("600"));
	    table2.put (800, new JLabel("800"));
	    table2.put (1000, new JLabel("1000"));

	    delaySlider = new JSlider(10, 1000);
	    delaySlider.setPaintLabels(true);
	    delaySlider.setLabelTable (table2);
	    delaySlider.setValue(DEFAULT_DELAY);
	    delaySlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
		        if (!delaySlider.getValueIsAdjusting()) {
					for (SettingViewListener l : listeners) {
						l.handleAutoStart(startToggleButton.isSelected(), delaySlider.getValue());
							reminderLabel.setText("<html> Delay: " 
									+delaySlider.getValue()+" ms</html>");
						}
						System.out.println("SettingView: stateChanged: stateChanged  " +setSizeSlider.getValue());
					}
		        }				
	    });


		startStopPanel.add(new JLabel("Delay(10-1000ms): "));
		startStopPanel.add(delaySlider);
		startToggleButton = new JToggleButton("Auto start");
		startToggleButton.setAlignmentX(CENTER_ALIGNMENT);
		startStopPanel.add(startToggleButton);
		this.add(startStopPanel);

		// remaining button
		advanceGameButton = new JButton("Advance game to next generation");
		advanceGameButton.setAlignmentX(CENTER_ALIGNMENT);
		randomlyGenerateButton = new JButton("Randomly generate live cells");
		randomlyGenerateButton.setAlignmentX(CENTER_ALIGNMENT);
		restartButton = new JButton("Clear");
		restartButton.setAlignmentX(CENTER_ALIGNMENT);
		this.add(advanceGameButton);
		this.add(randomlyGenerateButton);
		this.add(restartButton);
		
		reminderLabel = new JLabel();
		reminderLabel.setText("<html> Welcome to mapy1874's Game Of Life<br>"+
		"Remember to click APPLY button after finishing setting</html>");
		reminderLabel.setAlignmentX(CENTER_ALIGNMENT);
		this.add(reminderLabel);
		// all related button will be listened and have related actionlistener
		this.addActionListener();
		this.setActionCommand();
	}
	
	private void setActionCommand() {
		restartButton.setActionCommand("restart");
		startToggleButton.setActionCommand("auto start");
		torusToggleButton.setActionCommand("torus");
		applyParasButton.setActionCommand("apply");
		advanceGameButton.setActionCommand("advance");
		randomlyGenerateButton.setActionCommand("random");
	}

	
	public void addSettingViewListener(SettingViewListener l) {
		listeners.add(l);
	}
	
	public void removeSettingViewListener(SettingViewListener l) {
		listeners.remove(l);
	}

	public void addActionListener() {
		startToggleButton.addActionListener(this);
		torusToggleButton.addActionListener(this);
		applyParasButton.addActionListener(this);
		advanceGameButton.addActionListener(this);
		randomlyGenerateButton.addActionListener(this);
		restartButton.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		System.out.println("SettingView: actionPerformed  " + command);
		switch(command) {
		case "advance":
			// advance the game to the next level
			for (SettingViewListener l : listeners) {
				l.handleAdvanceGame();
				reminderLabel.setText("Advance the game successfully!");
				System.out.println("SettingView: actionPerformed: advance");
			}
			break;
		case "apply":
			// extract the parameters and change the game
			startToggleButton.setSelected(false);
			for (SettingViewListener l : listeners) {
				l.handleAutoStart(startToggleButton.isSelected(), delaySlider.getValue());
			}
			for (SettingViewListener l : listeners) {
				l.handleSettingViewEvent(new SettingViewEvent(
						setSizeSlider.getValue(),setSizeSlider.getValue(),
						lowBirthThresholdSlider.getValue(), 
						highBirthThresholdSlider.getValue(),
						lowSurviveThresholdSlider.getValue(),
						highSurviveThresholdSlider.getValue(),
						delaySlider.getValue(),
						torusToggleButton.isSelected()));
				reminderLabel.setText("<html>Size = "+setSizeSlider.getValue()
				+ ",         lbt = " + lowBirthThresholdSlider.getValue()+ 
						",       hbt = " + highBirthThresholdSlider.getValue()+
						",       lst = "+ lowSurviveThresholdSlider.getValue()+",<br>"
						+ "hst = " + highSurviveThresholdSlider.getValue()+
						",         torus mode = " + torusToggleButton.isSelected()+ "</html>");

				System.out.println("SettingView: actionPerformed: apply  " +setSizeSlider.getValue());
			}
			break;
		case "random":
			// stop the auto start first so the function can clear the board fully
			startToggleButton.setSelected(false);
			for (SettingViewListener l : listeners) {
				l.handleAutoStart(startToggleButton.isSelected(), delaySlider.getValue());
			}
			// not sure why, but this will clear the board fully
			try {
				Thread.sleep(100);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			for (SettingViewListener l : listeners) {
				l.handleRandomlyGenerate();
				reminderLabel.setText("Randomly generated successfully!");
				System.out.println("SettingView: actionPerformed: random  " +setSizeSlider.getValue());
			}
			break;
		case "restart":
			startToggleButton.setSelected(false);
			for (SettingViewListener l : listeners) {
				l.handleAutoStart(startToggleButton.isSelected(), delaySlider.getValue());
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			for (SettingViewListener l : listeners) {
				l.handleRestart();
				reminderLabel.setText("<html>Clear the game successfully!<br> Auto start released.</html>");
				System.out.println("SettingView: actionPerformed: handleRestart  " +setSizeSlider.getValue());
			}
			break;

		case "auto start":
			for (SettingViewListener l : listeners) {
				l.handleAutoStart(startToggleButton.isSelected(), delaySlider.getValue());
				if (startToggleButton.isSelected()) {
					reminderLabel.setText("<html> Auto start the game successfully! <br>Delay: " 
							+delaySlider.getValue()+" ms</html>");
				} else {
					reminderLabel.setText("Stop the game successfully!");
				}
				System.out.println("SettingView: actionPerformed: handleRestart  " +setSizeSlider.getValue());
			}
			break;

		}
		
	}


}
