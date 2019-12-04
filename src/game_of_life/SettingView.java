package game_of_life;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Hashtable;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JToggleButton;
import javax.swing.text.NumberFormatter;

public class SettingView extends JPanel implements ActionListener{
	public static final int DEFAULT_LOW_BIRTH_THRESHOLD = 3;
	public static final int DEFAULT_HIGH_BIRTH_THRESHOLD = 3;
	public static final int DEFAULT_LOW_SURVIVE_THRESHOLD = 2;
	public static final int DEFAULT_HIGH_SURVIVE_THRESHOLD = 3;

	private JPanel setSizePanel;
	private JSlider setSizeSlider;
	
	
	private JPanel lifeDeathPanel;
	private JButton lifeDeathButton;
	private JSlider lowBirthThresholdSlider;
	private JSlider highBirthThresholdSlider;
	private JSlider lowSurviveThresholdSlider;
	private JSlider highSurviveThresholdSlider;

	
	private JPanel startStopPanel;
	private JToggleButton startToggleButton;
	private JFormattedTextField setDelayTextField;
	private JButton setDelayButton;
	
	private JButton advanceGameButton;
	private JButton randomlyGenerateButton;
	private JToggleButton torusToggleButton;
	private JButton resetButton;
	public SettingView() {
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		// setSizePanel
		setSizePanel = new JPanel();
		setSizePanel.setLayout(new FlowLayout());
		integerFormatter(10, 500);
		setSizeSlider = new JSlider(10, 500);
	    Hashtable<Integer, JLabel> table1 = new Hashtable<Integer, JLabel>();
	    table1.put (10, new JLabel("10"));
	    table1.put (100, new JLabel("100"));
	    table1.put (200, new JLabel("200"));
	    table1.put (300, new JLabel("300"));
	    table1.put (400, new JLabel("400"));
	    table1.put (500, new JLabel("500"));
	    setSizeSlider.setPaintLabels(true);
	    setSizeSlider.setLabelTable(table1);
	    setSizeSlider.setValue(10);

		JLabel sizeLabel = new JLabel("Current size: 10*10");
		setSizePanel.add(setSizeSlider);
		setSizePanel.add(sizeLabel);
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
	    
		highBirthThresholdSlider = new JSlider(0, 8);
		highBirthThresholdSlider.setPaintLabels(true);
		highBirthThresholdSlider.setLabelTable (table);
		highBirthThresholdSlider.setValue(DEFAULT_HIGH_BIRTH_THRESHOLD);
		
		lowSurviveThresholdSlider = new JSlider(0, 8);
		lowSurviveThresholdSlider.setPaintLabels(true);
		lowSurviveThresholdSlider.setLabelTable (table);
		lowSurviveThresholdSlider.setValue(DEFAULT_LOW_SURVIVE_THRESHOLD);
		
		highSurviveThresholdSlider = new JSlider(0, 8);
		highSurviveThresholdSlider.setPaintLabels(true);
		highSurviveThresholdSlider.setLabelTable (table);
		highSurviveThresholdSlider.setValue(DEFAULT_HIGH_SURVIVE_THRESHOLD);

		lifeDeathButton = new JButton("Set thresholds");
		lifeDeathPanel.add(new JLabel("Low birth threshold: "));
		lifeDeathPanel.add(lowBirthThresholdSlider);
		lifeDeathPanel.add(new JLabel("High birth threshold: "));
		lifeDeathPanel.add(highBirthThresholdSlider);
		lifeDeathPanel.add(new JLabel("High survive threshold: "));
		lifeDeathPanel.add(lowSurviveThresholdSlider);
		lifeDeathPanel.add(new JLabel("High survive threshold: "));
		lifeDeathPanel.add(highSurviveThresholdSlider);
		lifeDeathPanel.add(lifeDeathButton);
		this.add(lifeDeathPanel);
		
		// startStopPanel
		startStopPanel = new JPanel();
		startStopPanel.setLayout(new FlowLayout());
		startToggleButton = new JToggleButton("Auto start");
		setDelayTextField = new JFormattedTextField(integerFormatter(10, 1000));
		setDelayTextField.setColumns(4);
		setDelayButton = new JButton("Set delay");
		startStopPanel.add(new JLabel("Delay(10-1000ms): "));
		startStopPanel.add(setDelayTextField);
		startStopPanel.add(setDelayButton);
		startStopPanel.add(startToggleButton);
		this.add(startStopPanel);

		// remaining button
		advanceGameButton = new JButton("Advance game to next generation");
		advanceGameButton.setAlignmentX(CENTER_ALIGNMENT);
		randomlyGenerateButton = new JButton("Randomly generate live cells");
		randomlyGenerateButton.setAlignmentX(CENTER_ALIGNMENT);
		torusToggleButton = new JToggleButton("Torus mode");
		torusToggleButton.setAlignmentX(CENTER_ALIGNMENT);
		resetButton = new JButton("Reset");
		resetButton.setAlignmentX(CENTER_ALIGNMENT);
		this.add(advanceGameButton);
		this.add(randomlyGenerateButton);
		this.add(torusToggleButton);
		this.add(resetButton);
		
	}
	
	// generated a numberformatter to restrict the input of the 
	// textfield
	private NumberFormatter integerFormatter(int min, int max) {
	    NumberFormat format = NumberFormat.getInstance();
	    NumberFormatter formatter = new NumberFormatter(format);
	    formatter.setValueClass(Integer.class);
	    formatter.setMinimum(min);
	    formatter.setMaximum(max);
//	    formatter.setAllowsInvalid(false);
	    return formatter;
	}

	public void addActionListener() {
		resetButton.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
