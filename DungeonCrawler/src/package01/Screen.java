package package01;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class Screen 
{
	ImageIcon graphicsImage, actionImage, statsImage, controlsImage;
	JFrame window;
	JPanel titleNamePanel, startButtonPanel, graphicsPanel, actionPanel, statsPanel, controlsPanel, uPanel, ldrPanel;
	JLabel titleNameLabel, graphicsLabel, actionLabel, statsLabel, controlsLabel;
	JButton startButton, upButton, leftButton, downButton, rightButton;
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
		graphicsPanel.setVisible(false);
		
		//----------ACTION PANEL----------
		actionPanel = new JPanel();
		actionPanel.setBounds(1140, 10, 750, 760);
		actionPanel.setBackground(Color.black);
		
		actionImage = new ImageIcon(getClass().getClassLoader().getResource("actionPanel.png"));
		
		actionLabel = new JLabel();
		actionLabel.setIcon(actionImage);
		actionPanel.add(actionLabel);
		actionPanel.setVisible(false);
		
		//----------STATS PANEL----------
		statsPanel = new JPanel();
		statsPanel.setBounds(10, 770, 1100, 260);
		statsPanel.setBackground(Color.black);
		
		statsImage = new ImageIcon(getClass().getClassLoader().getResource("statsPanel.png"));
		
		statsLabel = new JLabel();
		statsLabel.setIcon(statsImage);
		statsPanel.add(statsLabel);
		statsPanel.setVisible(false);
		
		//----------CONTROLS PANEL----------
		controlsPanel = new JPanel();
		controlsPanel.setBounds(1140, 770, 750, 260);
		controlsPanel.setBackground(Color.black);
		
		controlsImage = new ImageIcon(getClass().getClassLoader().getResource("controlsPanel.png"));
		
		controlsLabel = new JLabel();
		controlsLabel.setIcon(controlsImage);
		controlsPanel.add(controlsLabel);
		controlsPanel.setVisible(false);

		uPanel = new JPanel();
		uPanel.setBounds(1220, 785, 70, 70);
		uPanel.setBackground(Color.blue);
		uPanel.setLayout(new GridLayout(1, 3));
		uPanel.setOpaque(false);

		upButton = new JButton();
		upButton.setFocusPainted(false);
		upButton.addActionListener(aHandler);
		upButton.setActionCommand("Up");
		upButton.setOpaque(false);
		uPanel.add(upButton);
		uPanel.setVisible(false);

		ldrPanel = new JPanel();
		ldrPanel.setBounds(1150, 855, 210, 70);
		ldrPanel.setBackground(Color.blue);
		ldrPanel.setLayout(new GridLayout(1, 3));
		ldrPanel.setOpaque(false);

		leftButton = new JButton();
		leftButton.setFocusPainted(false);
		leftButton.addActionListener(aHandler);
		leftButton.setActionCommand("Left");
		leftButton.setOpaque(false);
		ldrPanel.add(leftButton);

		downButton = new JButton();
		downButton.setFocusPainted(false);
		downButton.addActionListener(aHandler);
		downButton.setActionCommand("Down");
		downButton.setOpaque(false);
		ldrPanel.add(downButton);

		rightButton = new JButton();
		rightButton.setFocusPainted(false);
		rightButton.addActionListener(aHandler);
		rightButton.setActionCommand("Right");
		rightButton.setOpaque(false);
		ldrPanel.add(rightButton);
		ldrPanel.setVisible(false);
		
		//----------ADD TO WINDOW(1)----------
		window.add(titleNamePanel);
		window.add(startButtonPanel);
		window.add(graphicsPanel);
		window.add(actionPanel);
		window.add(statsPanel);
		window.add(controlsPanel);
		window.add(uPanel);
		window.add(ldrPanel);
		
		window.setVisible(true);
	}
}
