package package01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener
{
	Game game;
	
	public ActionHandler(Game g)
	{
		game = g;
	}
	
	public void actionPerformed(ActionEvent event)
	{
		String action = event.getActionCommand();
		switch(action)
		{
		case "start" : game.vm.titleToDungeon();
		}
	}
}
