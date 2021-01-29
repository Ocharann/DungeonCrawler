package package01;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class Screen 
{
	ImageIcon graphicsImage, actionImage, statsImage;
	JFrame window;
	JPanel titleNamePanel, startButtonPanel, graphicsPanel, actionPanel, statsPanel;
	JLabel titleNameLabel, graphicsLabel, actionLabel, statsLabel;
	JButton startButton;
	Font titleFont = new Font("Courier", Font.PLAIN, 162);
	Font font1 = new Font("Courier", Font.PLAIN, 52);
	
	public void CreateUI(ActionHandler aHandler)
	{
		//----------WINDOW----------
		window = new JFrame();
		window.setSize(1920, 1080);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		window.setVisible(true);
		window.addMouseListener(null);
		
		//----------TITLE SCREEN----------
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(240, 180, 1440, 900);
		titleNamePanel.setBackground(Color.black);
		titleNameLabel = new JLabel("DUNGEON");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);
		titleNamePanel.add(titleNameLabel);
		
		//----------START BUTTON----------
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(720, 720, 480, 180);
		startButtonPanel.setBackground(Color.black);
		startButton = new JButton("START");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(font1);
		startButton.setFocusPainted(false);
		startButton.addActionListener(aHandler);
		startButton.setActionCommand("start");
		startButtonPanel.add(startButton);
		
		//----------GRAPHICS----------
		graphicsPanel = new JPanel();
		graphicsPanel.setBounds(10, 10, 1100, 760);
		graphicsPanel.setBackground(Color.black);
		
		graphicsImage = new ImageIcon(getClass().getClassLoader().getResource("doorFarLR.png"));
		
		graphicsLabel = new JLabel();
		graphicsLabel.setIcon(graphicsImage);
		graphicsPanel.add(graphicsLabel);
		
		//----------ACTION PANEL----------
		actionPanel = new JPanel();
		actionPanel.setBounds(1140, 10, 750, 760);
		actionPanel.setBackground(Color.black);
		
		actionImage = new ImageIcon(getClass().getClassLoader().getResource("actionPanel.png"));
		
		actionLabel = new JLabel();
		actionLabel.setIcon(actionImage);
		actionPanel.add(actionLabel);
		
		//----------STATS PANEL----------
		statsPanel = new JPanel();
		statsPanel.setBounds(10, 770, 1100, 260);
		statsPanel.setBackground(Color.black);
		
		statsImage = new ImageIcon(getClass().getClassLoader().getResource("statsPanel.png"));
		
		statsLabel = new JLabel();
		statsLabel.setIcon(statsImage);
		statsPanel.add(statsLabel);
		
		//----------ADD TO WINDOW(1)----------
		window.add(titleNamePanel);
		window.add(startButtonPanel);
		window.add(graphicsPanel);
		window.add(actionPanel);
		window.add(statsPanel);
		
		window.setVisible(true);
	}
}
