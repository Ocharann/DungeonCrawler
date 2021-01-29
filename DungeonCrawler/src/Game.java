import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
	JButton button1, button2, button3, button4;
	JPanel imagePanel;
	JLabel imageLabel;
	JTextArea actionText;
	Font font1, font2;
	ImageIcon deadFarR, doorCloseLR, doorMediumLR, deadClose, wall, doorFarLR, actionImage, statsImage, controlsImage;
	ButtonHandler bHandler = new ButtonHandler();
	//KeyHandler kHandler = new KeyHandler();
	boolean locked, isDeadClose, isWall, isDFLR, isDMLR, isDCLR, isDEFR;
	
	public static void main(String[] args)
	{
		System.out.println("test");
		new Game();
	}
	public Game()
	{
		locked = false;
		isDeadClose = false;
		isWall = false;
		isDFLR = true;
		isDMLR = false;
		isDCLR = false;
		isDEFR = false;
		createFont();
		createUI();
	}
	public void createFont()
	{
		font1 = new Font("Courier", Font.PLAIN, 32);
		font2 = new Font("Courier", Font.PLAIN, 16);
	}
	public void createUI()
	{
		//--------------WINDOW--------------
		JFrame window = new JFrame();
		window.setSize(1920, 1080);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		
		//--------------GRAPHICS PANEL & LABEL--------------
			//--displays images and graphics
		imagePanel = new JPanel();
		imagePanel.setBounds(10, 10, 1100, 760);
		imagePanel.setBackground(Color.black);
		window.add(imagePanel);
		
		deadFarR = new ImageIcon(getClass().getClassLoader().getResource("deadFarR.png"));
		doorCloseLR = new ImageIcon(getClass().getClassLoader().getResource("doorCloseLR.png"));
		doorMediumLR = new ImageIcon(getClass().getClassLoader().getResource("doorMediumLR.png"));
		doorFarLR = new ImageIcon(getClass().getClassLoader().getResource("doorFarLR.png"));
		wall = new ImageIcon(getClass().getClassLoader().getResource("wall.png"));
		deadClose = new ImageIcon(getClass().getClassLoader().getResource("deadClose.png"));
		
		imageLabel = new JLabel();
		imageLabel.setIcon(doorFarLR);
		imagePanel.add(imageLabel);
		
		//--------------ACTION PANEL & LABEL--------------
			//--displays dialogue, health bars for monster fights, etc.
		JPanel actionPanel = new JPanel();
		actionPanel.setBounds(1140, 10, 750, 760);
		actionPanel.setBackground(Color.black);
		window.add(actionPanel);
		
		actionText = new JTextArea();
		actionText.setBounds(1140, 10, 750, 760);
		actionText.setForeground(Color.white);
		actionText.setBackground(Color.black);
		actionText.setFont(font1);
		actionText.setLineWrap(true);
		actionText.setWrapStyleWord(true);
		actionText.setEditable(false);
		actionPanel.add(actionText);
		
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
		
		JPanel uPanel = new JPanel();
		uPanel.setBounds(1220, 785, 70, 70);
		uPanel.setBackground(Color.blue);
		uPanel.setLayout(new GridLayout(1, 3));
		uPanel.setOpaque(false);
		window.add(uPanel);
		
		button4 = new JButton();
		button4.setFocusPainted(false);
		button4.addActionListener(bHandler);
		button4.setActionCommand("Up");
		button4.setOpaque(false);
		uPanel.add(button4);
		
		JPanel ldrPanel = new JPanel();
		ldrPanel.setBounds(1150, 855, 210, 70);
		ldrPanel.setBackground(Color.blue);
		ldrPanel.setLayout(new GridLayout(1, 3));
		ldrPanel.setOpaque(false);
		window.add(ldrPanel);
		
		button1 = new JButton();
		button1.setFocusPainted(false);
		button1.addActionListener(bHandler);
		button1.setActionCommand("Left");
		button1.setOpaque(false);
		ldrPanel.add(button1);
		
		button2 = new JButton();
		button2.setFocusPainted(false);
		button2.addActionListener(bHandler);
		button2.setActionCommand("Down");
		button2.setOpaque(false);
		ldrPanel.add(button2);
		
		button3 = new JButton();
		button3.setFocusPainted(false);
		button3.addActionListener(bHandler);
		button3.setActionCommand("Right");
		button3.setOpaque(false);
		ldrPanel.add(button3);

		window.setVisible(true);
		
	}
	public class ButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			String action = event.getActionCommand();
			actionText.setText("");
			switch(action)
			{
			case("Up"):
				if(isWall == false)
				{
					if(isDFLR)
					{
						imageLabel.setIcon(doorMediumLR);
						imagePanel.add(imageLabel);
						isDFLR = false;
						isDMLR = true;
						break;
					}
					else if(isDMLR)
					{
						imageLabel.setIcon(doorCloseLR);
						imagePanel.add(imageLabel);
						actionText.setText("This door is locked.");
						isDMLR = false;
						isDCLR = true;
						locked = true;
						break;
					}
					else if(isDCLR)
					{
						actionText.setText("This door is locked.");
						locked = true;
						break;
					}
				}
				else
				{
					actionText.setText("You bump into the wall. How did you not see that?");
					break;
				}
			case("Left"):
				if(isWall == false)
				{
					if(isDCLR)
					{
						imageLabel.setIcon(deadFarR);
						imagePanel.add(imageLabel);
						isDCLR = false;
						isDEFR = true;
						break;
					}
					else 
					{
						imageLabel.setIcon(wall);
						imagePanel.add(imageLabel);
						isWall = true;
						break;
					}
				}
				else
				{
					imageLabel.setIcon(deadClose);
					imagePanel.add(imageLabel);
					isWall = false;
					break;
				}
				
			case("Right"):
				if(isWall == false)
				{
					imageLabel.setIcon(wall);
					imagePanel.add(imageLabel);
					isWall = true;
					break;
				}
				else
				{
					imageLabel.setIcon(doorFarLR);
					imagePanel.add(imageLabel);
					isWall = false;
					break;
				}
			}
		}
	}
	/*public class KeyHandler implements KeyListener
	{

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			int keyCode = e.getKeyCode();
			System.out.println(keyCode);
			switch(keyCode)
			{
			case KeyEvent.VK_UP:
				if(deadClose == false)
				{
					System.out.println("test");
					imageLabel.setIcon(null);
					graphics = new ImageIcon(getClass().getClassLoader().getResource("doorMediumLR.png"));
					imageLabel.setIcon(graphics);
					imagePanel.add(imageLabel);
				}
				else
				{
					actionText.setText("Dead end!");
				}
			}
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}*/
}
