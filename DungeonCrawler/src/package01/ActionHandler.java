package package01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

public class ActionHandler implements ActionListener
{
	Game g;
	Screen s;
	int x, y;
	String d;
	
	public ActionHandler(Game game, Screen screen)
	{
		g = game;
		s = screen;
		x = 10;
		y = 10;
		d = "N";
	}
	
	public void actionPerformed(ActionEvent event)
	{
		String action = event.getActionCommand();
		switch(action)
		{
		case "start" : g.vm.titleToDungeon(); break;
		case "Up" : 
			if(x == 10 && y == 10 && d.equals("N")){
				s.graphicsImage = new ImageIcon(getClass().getClassLoader().getResource("doorMediumLR.png")); s.graphicsLabel.setIcon(s.graphicsImage); y = 9; break;
			}
			else if(x == 10 && y == 9 && d.equals("N")) {
				s.graphicsImage = new ImageIcon(getClass().getClassLoader().getResource("doorCloseLR.png")); s.graphicsLabel.setIcon(s.graphicsImage); y = 8; break;
			}
		}
	}
}
