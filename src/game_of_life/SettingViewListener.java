package game_of_life;

public interface SettingViewListener {
	void handleSettingViewEvent(SettingViewEvent e);
	void handleAdvanceGame();
	void handleRandomlyGenerate();
	void handleRestart();
	void handleAutoStart(boolean isAutoStart, int delay);
}
