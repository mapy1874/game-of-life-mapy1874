package game_of_life;

public interface SettingViewListener {
	void handleSettingViewEvent(SettingViewEvent e);
	void handleAdvanceGame();
	void handleRandomlyGenerate(SettingViewEvent e);
	void handleRestart();
}
