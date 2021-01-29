package package01;

public class VisibilityManager 
{
	Screen s;
	
	public VisibilityManager(Screen screen)
	{
		s = screen;
	}
	
	public void showTitleScreen()
	{
		//Display the title screen and start button
		s.titleNamePanel.setVisible(true);
		s.startButtonPanel.setVisible(true);
		
		//Hide everything else
		s.graphicsPanel.setVisible(false);
		s.actionPanel.setVisible(false);
		s.statsPanel.setVisible(false);
	}
	
	public void titleToDungeon()
	{
		//Hide Title screen
		s.titleNamePanel.setVisible(false);
		s.startButtonPanel.setVisible(false);
		
		//Show game screen
		s.graphicsPanel.setVisible(true);
		s.actionPanel.setVisible(true);
		s.statsPanel.setVisible(true);
	}
}
