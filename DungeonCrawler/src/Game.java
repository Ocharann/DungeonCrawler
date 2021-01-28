import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Game 
{
	Font font1, font2;
	ImageIcon graphics, actionImage, statsImage, controlsImage;
	
	public static void main(String[] args)
	{
		new Game();
	}
	public Game()
	{
		createFont();
		createUI();
	}
	public void createFont()
	{
		font1 = new Font("Times New Roman", Font.PLAIN, 32);
		font2 = new Font("Times New Roman", Font.PLAIN, 16);
	}
	public void createUI()
	{
		//--------------WINDOW--------------
		JFrame window = new JFrame();
		window.setSize(1920, 1080);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		
		//--------------IMAGE PANEL & LABEL--------------
			//--displays images and graphics
		JPanel imagePanel = new JPanel();
		imagePanel.setBounds(10, 10, 1100, 760);
		imagePanel.setBackground(Color.black);
		window.add(imagePanel);
		
		graphics = new ImageIcon(getClass().getClassLoader().getResource("doorFarLR.png"));
		
		JLabel imageLabel = new JLabel();
		imageLabel.setIcon(graphics);
		imagePanel.add(imageLabel);
		
		//--------------ACTION PANEL & LABEL--------------
			//--displays dialogue, health bars for monster fights, etc.
		JPanel actionPanel = new JPanel();
		actionPanel.setBounds(1140, 10, 750, 760);
		actionPanel.setBackground(Color.black);
		window.add(actionPanel);
		
		actionImage = new ImageIcon(getClass().getClassLoader().getResource("actionPanel.png"));
		
		JLabel actionLabel = new JLabel();
		actionLabel.setIcon(actionImage);
		actionPanel.add(actionLabel);
		
		//--------------STATS PANEL & LABEL--------------
			//--displays stats (gold, xp, etc.)
		JPanel statsPanel = new JPanel();
		statsPanel.setBounds(10, 770, 1100, 260);
		statsPanel.setBackground(Color.black);
		window.add(statsPanel);
		
		statsImage = new ImageIcon(getClass().getClassLoader().getResource("statsPanel.png"));
		
		JLabel statsLabel = new JLabel();
		statsLabel.setIcon(statsImage);
		statsPanel.add(statsLabel);
		
		//--------------CONTROLS PANEL & LABEL--------------
			//--displays controls
		JPanel controlsPanel = new JPanel();
		controlsPanel.setBounds(1140, 770, 750, 260);
		controlsPanel.setBackground(Color.black);
		window.add(controlsPanel);
		
		controlsImage = new ImageIcon(getClass().getClassLoader().getResource("controlsPanel.png"));
		
		JLabel controlsLabel = new JLabel();
		controlsLabel.setIcon(controlsImage);
		controlsPanel.add(controlsLabel);
	
		window.setVisible(true);
		
		
	}
}
