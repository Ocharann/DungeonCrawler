package package01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game 
{
	ActionHandler aHandler = new ActionHandler(this);
	Screen s = new Screen();
	VisibilityManager vm = new VisibilityManager(s);
	
	public static void main(String[] args)
	{
		new Game();
	}
	
	public Game()
	{
		s.CreateUI(aHandler);
		vm.showTitleScreen();
	}
}
