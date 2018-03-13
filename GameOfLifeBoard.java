import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class GameOfLifeBoard implements ActionListener
{	
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Game of Life");
		frame.setSize(1800, 1200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try 
		{
			frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("quad.jpg")))));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		placeComponents(frame);
		frame.setVisible(true);

	}

	static int player1Money = 2000;
	static int player2Money	= 2000;
	static int player1isuPoints = 0;
	static int player2isuPoints = 0;
	static int player1FinalScore = 0;
	static int player2FinalScore = 0;
	static String winner = "";
	static boolean player1 = true;
	
	public static JTextField player1MoneyLabel;
	public static JTextField player1MoneyTotal;
	public static JTextField player1LifePoints;
	public static JTextField player1PointsLabel;
	public static JTextField player2MoneyLabel;
	public static JTextField player2MoneyTotal;
	public static JTextField player2PointsLabel;
	public static JTextField player2LifePoints;
	public static JTextField currentPlayerLabel;
	public static JTextField currentPlayer;
	public static JTextField player1PositionLabel;
	public static JTextField player1Position;
	public static JTextField player2Position;
	public static JTextField player2PositionLabel;
	

	private static void placeComponents(JFrame frame)
	{
		frame.setLayout(null);
		Font font1 = new Font("SansSerif", Font.BOLD, 18);
		
		JPanel player1Scoring = new JPanel();
		player1Scoring.setBounds(1000, 80, 350, 200);
		player1Scoring.setLayout(new GridLayout(7,2));
		
		player1MoneyLabel = new JTextField(100);
		player1MoneyLabel.setText("Player 1 Money");
		player1MoneyLabel.setFont(font1);
		player1MoneyTotal = new JTextField(100);
		player1MoneyTotal.setText("$ " + String.valueOf(player1Money));
		player1MoneyTotal.setFont(font1);
		player1MoneyTotal.setForeground(Color.BLUE);
		player1PointsLabel = new JTextField(100);
		player1PointsLabel.setText("Player 1 Life Points");
		player1PointsLabel.setFont(font1);
		player1LifePoints = new JTextField(100);
		player1LifePoints.setText(String.valueOf(player1isuPoints));
		player1LifePoints.setFont(font1);
		player1LifePoints.setForeground(Color.BLUE);
		player1PositionLabel = new JTextField(100);
		player1PositionLabel.setText("Player 1 Position");
		player1PositionLabel.setFont(font1);
		player1Position = new JTextField(100);
		player1Position.setText("START");
		player1Position.setFont(font1);
		player1Position.setForeground(Color.BLUE);

		player1Scoring.add(player1MoneyLabel);
		player1Scoring.add(player1MoneyTotal);
		player1Scoring.add(player1PointsLabel);
		player1Scoring.add(player1LifePoints);
		player1Scoring.add(player1PositionLabel);
		player1Scoring.add(player1Position);

		player2MoneyLabel = new JTextField(100);
		player2MoneyLabel.setText("Player 2 Money");
		player2MoneyLabel.setFont(font1);
		player2MoneyTotal = new JTextField(100);
		player2MoneyTotal.setText("$ " + String.valueOf(player2Money));
		player2MoneyTotal.setFont(font1);
		player2MoneyTotal.setForeground(Color.orange);
		player2PointsLabel = new JTextField(100);
		player2PointsLabel.setText("Player 2 Life Points");
		player2PointsLabel.setFont(font1);
		player2LifePoints = new JTextField(70);
		player2LifePoints.setText(String.valueOf(player2isuPoints));
		player2LifePoints.setFont(font1);
		player2LifePoints.setForeground(Color.orange);
		player2PositionLabel = new JTextField(100);
		player2PositionLabel.setText("Player 2 Position");
		player2PositionLabel.setFont(font1);
		player2Position = new JTextField(100);
		player2Position.setText("START");
		player2Position.setFont(font1);
		player2Position.setForeground(Color.orange);

		player1Scoring.add(player2MoneyLabel);
		player1Scoring.add(player2MoneyTotal);
		player1Scoring.add(player2PointsLabel);
		player1Scoring.add(player2LifePoints);
		player1Scoring.add(player2PositionLabel);
		player1Scoring.add(player2Position);

		currentPlayerLabel = new JTextField(55);
		currentPlayerLabel.setText("Current Player");
		currentPlayerLabel.setFont(font1);
		currentPlayer = new JTextField(55);
		currentPlayer.setText("Player 1's Turn");
		currentPlayer.setFont(font1);
		currentPlayer.setForeground(Color.BLUE);
		player1Scoring.add(currentPlayerLabel);
		player1Scoring.add(currentPlayer);




		JPanel spinnerPanel = new JPanel();
		LifeSpinner spinner = new LifeSpinner();
		spinnerPanel = spinner.getPanel();
		spinnerPanel.setVisible(true);

		JButton spinButton = new JButton();
		spinButton = spinner.getButton();
		spinButton.setBackground(Color.yellow);
		spinButton.setOpaque(true);
		spinButton.setFont(font1);
		spinButton.setBorder(BorderFactory.createLineBorder(Color.black, 7));

		spinButton.setBounds(1000, 370, 150, 50);
		frame.add(spinButton);		
		frame.getContentPane().add(spinnerPanel, BorderLayout.EAST);
		frame.getContentPane().add(player1Scoring, BorderLayout.CENTER);
		
		JButton changePlayer = new JButton("Change Player");
		changePlayer.setBackground(Color.yellow);
		changePlayer.setOpaque(true);
		changePlayer.setBorder(BorderFactory.createLineBorder(Color.black, 7));
		changePlayer.setBounds(1000, 300, 150, 50);
		changePlayer.setFont(font1);
		frame.add(changePlayer);
		changePlayer.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				changePlayer.setBackground(Color.green);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				changePlayer.setBackground(Color.yellow);
			}
		});
		
		changePlayer.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent arg0) 
			{
				if(player1 == true){
					player1 = false;
					currentPlayer.setText("Player 2's Turn");
					currentPlayer.setForeground(Color.ORANGE);
				}

				else	{
					player1 = true;
					currentPlayer.setText("Player 1's Turn");
					currentPlayer.setForeground(Color.BLUE);
				}

			}
		});

		JButton startButton = new JButton("START");
		startButton.setBackground(Color.red);
		startButton.setOpaque(true);
		startButton.setBorder(BorderFactory.createLineBorder(Color.black, 7));
		startButton.setBounds(10, 80, 100, 50);
		startButton.setToolTipText("<HTML><b>Position 0<b>");
		frame.add(startButton);
		startButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				startButton.setBackground(Color.cyan);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				startButton.setBackground(Color.red);
			}
		});
		startButton.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent arg0) 
			{

			}
		});

		JButton summerJob = new JButton("<HTML><center><b>Summer Job<b>");
		summerJob.setBackground(Color.orange);
		summerJob.setOpaque(true);
		summerJob.setBorder(BorderFactory.createLineBorder(Color.black, 7));
		summerJob.setBounds(130, 80, 100, 50);
		summerJob.setToolTipText("<HTML><b>Position 1<b>");
		frame.add(summerJob);
		summerJob.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				summerJob.setBackground(Color.red);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				summerJob.setBackground(Color.orange);
			}
		});
		summerJob.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent arg0)	{
				JOptionPane.showMessageDialog(frame.getComponent(0), "You received $1000 from your summer job!");
				if(player1 == true)	{
					player1Money = player1Money + 1000;
					player1MoneyTotal.setText("$ " + String.valueOf(player1Money));
					player1Position.setText("1"); 

				}
				else	{
					player2Money = player2Money + 1000;
					player2MoneyTotal.setText("$ " + String.valueOf(player2Money));
					player2Position.setText("1");
				}
			}
		});

		JButton buyBooks = new JButton("<HTML><center><b>Buy Books<b>");
		buyBooks.setBackground(Color.orange);
		buyBooks.setOpaque(true);
		buyBooks.setBorder(BorderFactory.createLineBorder(Color.black, 7));
		buyBooks.setBounds(250, 80, 100, 50);
		buyBooks.setToolTipText("Position 2");
		frame.add(buyBooks);
		buyBooks.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				buyBooks.setBackground(Color.red);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				buyBooks.setBackground(Color.orange);
			}
		});
		buyBooks.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent arg0)	{
				JOptionPane.showMessageDialog(frame.getComponent(0), "Books cost you $500 for the semester.");
				if(player1 == true)	{
					player1Money = player1Money - 500;
					player1MoneyTotal.setText("$ " + String.valueOf(player1Money));
					player1Position.setText("2");
				}
				else	{
					player2Money = player2Money - 500;
					player2MoneyTotal.setText("$ " + String.valueOf(player2Money));
					player2Position.setText("2");
				}
			}
		});

		JButton makeFriends = new JButton("<HTML><center><b>Meet New People<b>");
		makeFriends.setBackground(Color.orange);
		makeFriends.setOpaque(true);
		makeFriends.setBorder(BorderFactory.createLineBorder(Color.black, 7));
		makeFriends.setBounds(370, 80, 100, 50);
		makeFriends.setToolTipText("Position 3");
		frame.add(makeFriends);
		makeFriends.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				makeFriends.setBackground(Color.red);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				makeFriends.setBackground(Color.orange);
			}
		});
		makeFriends.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent arg0)	{
				JOptionPane.showMessageDialog(frame.getComponent(0), "Met new friends.  Gain 500 ISU Life Points.");
				if(player1 == true)	{	
					player1isuPoints = player1isuPoints + 500;
					player1LifePoints.setText(String.valueOf(player1isuPoints));
					player1Position.setText("3");
				}
				else	{
					player2isuPoints = player2isuPoints + 500;
					player2LifePoints.setText(String.valueOf(player2isuPoints));
					player2Position.setText("3");
				}
			}
		});

		JButton drawCard1 = new JButton("<HTML><center> Draw a Card");
		drawCard1.setBackground(Color.cyan);
		drawCard1.setOpaque(true);
		drawCard1.setBorder(BorderFactory.createLineBorder(Color.black, 7));
		drawCard1.setBounds(490, 80, 100, 50);
		drawCard1.setToolTipText("Position 4");
		frame.add(drawCard1);
		drawCard1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				drawCard1.setBackground(Color.red);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				drawCard1.setBackground(Color.cyan);
			}
		});
		drawCard1.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent arg0)	{
				JOptionPane.showMessageDialog(frame.getComponent(0), "Draw an ISU Life Card");
				if(player1 == true)	{
					player1Position.setText("4");
				}
				else	{
					player2Position.setText("4");
				}
			}
		});

		JButton parentGift = new JButton("<HTML><center>Gift");
		parentGift.setBackground(Color.orange);
		parentGift.setOpaque(true);
		parentGift.setBorder(BorderFactory.createLineBorder(Color.black, 7));
		parentGift.setBounds(610, 80, 100, 50);
		parentGift.setToolTipText("Position 5");
		frame.add(parentGift);
		parentGift.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				parentGift.setBackground(Color.red);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				parentGift.setBackground(Color.orange);
			}
		});
		parentGift.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent arg0)	{
				JOptionPane.showMessageDialog(frame.getComponent(0), "Parents are worried and give you $1000 for the semester.");
				if(player1 == true)	{
					player1Money = player1Money + 1000;
					player1MoneyTotal.setText("$ " + String.valueOf(player1Money));
					player1Position.setText("5");
				}
				else	{
					player2Money = player2Money + 1000;
					player2MoneyTotal.setText("$ " + String.valueOf(player2Money));
					player2Position.setText("5");
				}
			}
		});

		JButton buyClothing = new JButton("<HTML><center>Buy ISU Appareal");
		buyClothing.setBackground(Color.orange);
		buyClothing.setOpaque(true);
		buyClothing.setBorder(BorderFactory.createLineBorder(Color.black, 7));
		buyClothing.setBounds(730, 80, 100, 50);
		buyClothing.setToolTipText("Position 6");
		frame.add(buyClothing);
		buyClothing.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				buyClothing.setBackground(Color.red);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				buyClothing.setBackground(Color.orange);
			}
		});
		buyClothing.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent arg0)	{
				JOptionPane.showMessageDialog(frame.getComponent(0), "Buy ISU clothing costs $400.");
				if(player1 == true)	{
					player1Money = player1Money - 400;
					player1MoneyTotal.setText("$ " + String.valueOf(player1Money));
					player1Position.setText("6");
				}
				else	{
					player2Money = player2Money - 400;
					player2MoneyTotal.setText("$ " + String.valueOf(player2Money));
					player2Position.setText("6");
				}
			}
		});

		JButton birthday = new JButton("<HTML><center>Happy Birthday");
		birthday.setBackground(Color.orange);
		birthday.setOpaque(true);
		birthday.setBorder(BorderFactory.createLineBorder(Color.black, 7));
		birthday.setBounds(850, 105, 100, 50);
		birthday.setToolTipText("Position 7");
		frame.add(birthday);
		birthday.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				birthday.setBackground(Color.red);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				birthday.setBackground(Color.orange);
			}
		});
		birthday.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent arg0)	{
				JOptionPane.showMessageDialog(frame.getComponent(0), "Receive Birthday gifts from family gain $500.");
				if(player1 == true)	{
					player1Money = player1Money + 500;
					player1MoneyTotal.setText("$ " + String.valueOf(player1Money));
					player1Position.setText("7");
				}
				else	{
					player2Money = player2Money + 500;
					player2MoneyTotal.setText("$ " + String.valueOf(player2Money));
					player2Position.setText("7");
				}
			}
		});

		JButton cellPhone = new JButton("<HTML><center>Cell Phone");
		cellPhone.setBackground(Color.orange);
		cellPhone.setOpaque(true);
		cellPhone.setBorder(BorderFactory.createLineBorder(Color.black, 7));
		cellPhone.setBounds(850, 175, 100, 50);
		cellPhone.setToolTipText("Position 8");
		frame.add(cellPhone);
		cellPhone.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				cellPhone.setBackground(Color.red);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				cellPhone.setBackground(Color.orange);
			}
		});
		cellPhone.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent arg0)	{
				JOptionPane.showMessageDialog(frame.getComponent(0), "Break your cellphone screen costs $200 to fix.");
				if(player1 == true)	{
					player1Money = player1Money - 200;
					player1MoneyTotal.setText("$ " + String.valueOf(player1Money));
					player1Position.setText("8");
				}
				else	{
					player2Money = player2Money - 200;
					player2MoneyTotal.setText("$ " + String.valueOf(player2Money));
					player2Position.setText("8");
				}
			}
		});

		JButton stop = new JButton("<HTML><center>STOP!!!");
		stop.setBackground(Color.red);
		stop.setOpaque(true);
		stop.setBorder(BorderFactory.createLineBorder(Color.black, 7));
		stop.setBounds(850, 245, 100, 50);
		stop.setToolTipText("Position STOP");
		frame.add(stop);
		stop.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				stop.setBackground(Color.cyan);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				stop.setBackground(Color.red);
			}
		});
		stop.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent arg0)	{
				JOptionPane.showMessageDialog(frame.getComponent(0), "STOP! Choose college path, Bookworm or Party Animal and spin again");
				if(player1 == true)	{
					player1Position.setText("STOP");
				}
				else	{
					player2Position.setText("STOP");
				}
			}
		});

		JButton scholorship = new JButton("<HTML><center>Earned Scholarship");
		scholorship.setBackground(Color.orange);
		scholorship.setOpaque(true);
		scholorship.setBorder(BorderFactory.createLineBorder(Color.black, 7));
		scholorship.setBounds(730, 200, 100, 50);
		scholorship.setToolTipText("Position A9");
		frame.add(scholorship);
		scholorship.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				scholorship.setBackground(Color.red);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				scholorship.setBackground(Color.orange);
			}
		});
		scholorship.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent arg0)	{
				JOptionPane.showMessageDialog(frame.getComponent(0), "Earned Scholarship, cash check before parents find out $1000");
				if(player1 == true)	{
					player1Money = player1Money + 1000;
					player1MoneyTotal.setText("$ " + String.valueOf(player1Money));
					player1Position.setText("A9");
				}
				else	{
					player2Money = player2Money + 1000;
					player2MoneyTotal.setText("$ " + String.valueOf(player2Money));
					player2Position.setText("A9");
				}
			}
		});

		JButton honors = new JButton("<HTML><center> Honors");
		honors.setBackground(Color.orange);
		honors.setOpaque(true);
		honors.setBorder(BorderFactory.createLineBorder(Color.black, 7));
		honors.setBounds(610, 175, 100, 50);
		honors.setToolTipText("Position A10");
		frame.add(honors);
		honors.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				honors.setBackground(Color.red);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				honors.setBackground(Color.orange);
			}
		});
		honors.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent arg0)	{
				JOptionPane.showMessageDialog(frame.getComponent(0), "Join Honors Program.  Earn 1000 ISU Life Points");
				if(player1 == true)	{	
					player1isuPoints = player1isuPoints + 1000;
					player1LifePoints.setText(String.valueOf(player1isuPoints));
					player1Position.setText("A10");
				}
				else	{
					player2isuPoints = player2isuPoints + 1000;
					player2LifePoints.setText(String.valueOf(player2isuPoints));
					player2Position.setText("A10");
				}
			}
		});

		JButton computerCrash = new JButton("<HTML><center> Computer Crashes");
		computerCrash.setBackground(Color.orange);
		computerCrash.setOpaque(true);
		computerCrash.setBorder(BorderFactory.createLineBorder(Color.black, 7));
		computerCrash.setBounds(490, 175, 100, 50);
		computerCrash.setToolTipText("Position A11");
		frame.add(computerCrash);
		computerCrash.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				computerCrash.setBackground(Color.red);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				computerCrash.setBackground(Color.orange);
			}
		});
		computerCrash.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent arg0)	{
				JOptionPane.showMessageDialog(frame.getComponent(0), "Infected with a virus, have to buy a new one.  Pay $700");
				if(player1 == true)	{
					player1Money = player1Money - 700;
					player1MoneyTotal.setText("$ " + String.valueOf(player1Money));
					player1Position.setText("A11");
				}
				else	{
					player2Money = player2Money - 700;
					player2MoneyTotal.setText("$ " + String.valueOf(player2Money));
					player2Position.setText("A11");
				}
			}
		});

		JButton paperDue = new JButton("<HTML><center> Term Paper Due");
		paperDue.setBackground(Color.orange);
		paperDue.setOpaque(true);
		paperDue.setBorder(BorderFactory.createLineBorder(Color.black, 7));
		paperDue.setBounds(370, 175, 100, 50);
		paperDue.setToolTipText("Position A12");
		frame.add(paperDue);
		paperDue.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				paperDue.setBackground(Color.red);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				paperDue.setBackground(Color.orange);
			}
		});
		paperDue.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent arg0)	{
				JOptionPane.showMessageDialog(frame.getComponent(0), "Term Paper is due, spend all night finishing.  Loose a turn");
				if(player1 == true)	{
					player1Position.setText("A12");
				}
				else {
					player2Position.setText("A12");
				}
			}
		});

		JButton drawCard2 = new JButton("<HTML><center> Draw a Card2");
		drawCard2.setBackground(Color.cyan);
		drawCard2.setOpaque(true);
		drawCard2.setBorder(BorderFactory.createLineBorder(Color.black, 7));
		drawCard2.setBounds(250, 175, 100, 50);
		drawCard2.setToolTipText("Position A13");
		frame.add(drawCard2);
		drawCard2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				drawCard2.setBackground(Color.red);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				drawCard2.setBackground(Color.cyan);
			}
		});
		drawCard2.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent arg0)	{
				JOptionPane.showMessageDialog(frame.getComponent(0), "Draw an ISU Life Card");
				if(player1 == true)	{
					player1Position.setText("A13");
				}
				else	{
					player2Position.setText("A13");
				}
				
			}
		});

		JButton tutor = new JButton("<HTML><center> Help Classmate");
		tutor.setBackground(Color.orange);
		tutor.setOpaque(true);
		tutor.setBorder(BorderFactory.createLineBorder(Color.black, 7));
		tutor.setBounds(130, 175, 100, 50);
		tutor.setToolTipText("Position A14");
		frame.add(tutor);
		tutor.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				tutor.setBackground(Color.red);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				tutor.setBackground(Color.orange);
			}
		});
		tutor.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent arg0)	{
				JOptionPane.showMessageDialog(frame.getComponent(0), "Help classmates prepare for test, earn $50");
				if(player1 == true)	{
					player1Money = player1Money + 50;
					player1MoneyTotal.setText("$ " + String.valueOf(player1Money));
					player1Position.setText("A14");
				}
				else	{
					player2Money = player2Money + 50;
					player2MoneyTotal.setText("$ " + String.valueOf(player2Money));
					player2Position.setText("A14");
				}
			}
		});

		JButton tailGate = new JButton("<HTML><center>Tail Gate ");
		tailGate.setBackground(Color.orange);
		tailGate.setOpaque(true);
		tailGate.setBorder(BorderFactory.createLineBorder(Color.black, 7));
		tailGate.setBounds(10, 220, 100, 50);
		tailGate.setToolTipText("Position A15");
		frame.add(tailGate);
		tailGate.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				tailGate.setBackground(Color.red);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				tailGate.setBackground(Color.orange);
			}
		});
		tailGate.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent arg0)	{
				JOptionPane.showMessageDialog(frame.getComponent(0), "Someone cute asks you to tailgate, can't say no. Regret not studying the next day, earn 200 ISU Life Points");
				if(player1 == true)	{	
					player1isuPoints = player1isuPoints + 200;
					player1LifePoints.setText(String.valueOf(player1isuPoints));
					player1Position.setText("A15");
				}
				else	{
					player2isuPoints = player2isuPoints + 200;
					player2LifePoints.setText(String.valueOf(player2isuPoints));
					player2Position.setText("A15");
				}
			}
		});

		JButton books = new JButton("<HTML><center>Book Rental");
		books.setBackground(Color.orange);
		books.setOpaque(true);
		books.setBorder(BorderFactory.createLineBorder(Color.black, 7));
		books.setBounds(10, 290, 100, 50);
		books.setToolTipText("Position A16");
		frame.add(books);
		books.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				books.setBackground(Color.red);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				books.setBackground(Color.orange);
			}
		});
		books.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent arg0)	{
				JOptionPane.showMessageDialog(frame.getComponent(0), "Miss deadline to return books.  Charged $500 to buy them");
				if(player1 == true)	{
					player1Money = player1Money - 500;
					player1MoneyTotal.setText("$ " + String.valueOf(player1Money));
					player1Position.setText("A16");
				}
				else	{
					player2Money = player2Money - 500;
					player2MoneyTotal.setText("$ " + String.valueOf(player2Money));
					player2Position.setText("A16");
				}
				
			}
		});

		JButton studyAbroad = new JButton("<HTML><center>Study Abroad");
		studyAbroad.setBackground(Color.orange);
		studyAbroad.setOpaque(true);
		studyAbroad.setBorder(BorderFactory.createLineBorder(Color.black, 7));
		studyAbroad.setBounds(10, 360, 100, 50);
		studyAbroad.setToolTipText("Position A17");
		frame.add(studyAbroad);
		studyAbroad.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				studyAbroad.setBackground(Color.red);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				studyAbroad.setBackground(Color.orange);
			}
		});
		studyAbroad.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent arg0)	{
				JOptionPane.showMessageDialog(frame.getComponent(0), "Study Abroad for Semester. Gain 1000 life points");
				if(player1 == true)	{	
					player1isuPoints = player1isuPoints + 1000;
					player1LifePoints.setText(String.valueOf(player1isuPoints));
					player1Position.setText("A17");
				}
				else	{
					player2isuPoints = player2isuPoints + 1000;
					player2LifePoints.setText(String.valueOf(player2isuPoints));
					player2Position.setText("A17");
				}
				
			}
		});

		JButton getSick = new JButton("<HTML><center>Get Sick");
		getSick.setBackground(Color.orange);
		getSick.setOpaque(true);
		getSick.setBorder(BorderFactory.createLineBorder(Color.black, 7));
		getSick.setBounds(10, 430, 100, 50);
		getSick.setToolTipText("Position A18");
		frame.add(getSick);
		getSick.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				getSick.setBackground(Color.red);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				getSick.setBackground(Color.orange);
			}
		});
		getSick.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent arg0)	{
				JOptionPane.showMessageDialog(frame.getComponent(0), "Get the flu, can't go to classes.  Loose a turn");
				if(player1 == true)	{
					player1Position.setText("A18");
				}
				else	{
					player2Position.setText("A18");
				}
				
			}
		});

		JButton deansList = new JButton("<HTML><center>Deans List");
		deansList.setBackground(Color.orange);
		deansList.setOpaque(true);
		deansList.setBorder(BorderFactory.createLineBorder(Color.black, 7));
		deansList.setBounds(10, 500, 100, 50);
		deansList.setToolTipText("Position A19");
		frame.add(deansList);
		deansList.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				deansList.setBackground(Color.red);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				deansList.setBackground(Color.orange);
			}
		});
		deansList.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent arg0)	{
				JOptionPane.showMessageDialog(frame.getComponent(0), "Made the Deans List.  Gain 1000 life points");
				if(player1 == true)	{	
					player1isuPoints = player1isuPoints + 1000;
					player1LifePoints.setText(String.valueOf(player1isuPoints));
					player1Position.setText("A19");
				}
				else	{
					player2isuPoints = player2isuPoints + 1000;
					player2LifePoints.setText(String.valueOf(player2isuPoints));
					player2Position.setText("A19");
				}
				
			}
		});

		JButton flatTire = new JButton("<HTML><center>Car Repairs");
		flatTire.setBackground(Color.orange);
		flatTire.setOpaque(true);
		flatTire.setBorder(BorderFactory.createLineBorder(Color.black, 7));
		flatTire.setBounds(10, 570, 100, 50);
		flatTire.setToolTipText("Position A20");
		frame.add(flatTire);
		flatTire.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				flatTire.setBackground(Color.red);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				flatTire.setBackground(Color.orange);
			}
		});
		flatTire.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent arg0)	{
				JOptionPane.showMessageDialog(frame.getComponent(0), "Got a flat tire, pay $200 to fix it");
				if(player1 == true)	{
					player1Money = player1Money - 200;
					player1MoneyTotal.setText("$ " + String.valueOf(player1Money));
					player1Position.setText("A20");
				}
				else	{
					player2Money = player2Money - 200;
					player2MoneyTotal.setText("$ " + String.valueOf(player2Money));
					player2Position.setText("A20");
				}
				
			}
		});

		JButton drawCard3 = new JButton("<HTML><center>Draw a Card3");
		drawCard3.setBackground(Color.cyan);
		drawCard3.setOpaque(true);
		drawCard3.setBorder(BorderFactory.createLineBorder(Color.black, 7));
		drawCard3.setBounds(10, 640, 100, 50);
		drawCard3.setToolTipText("Position A21");
		frame.add(drawCard3);
		drawCard3.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				drawCard3.setBackground(Color.red);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				drawCard3.setBackground(Color.cyan);
			}
		});
		drawCard3.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent arg0)	{
				JOptionPane.showMessageDialog(frame.getComponent(0), "Draw an ISU Life Card");
				if(player1 == true)	{
					player1Position.setText("A21");
				}
				else	{
					player2Position.setText("A21");
				}
				
			}
		});

		JButton grader = new JButton("<HTML><center>Help Prof. Grade");
		grader.setBackground(Color.orange);
		grader.setOpaque(true);
		grader.setBorder(BorderFactory.createLineBorder(Color.black, 7));
		grader.setBounds(10, 710, 100, 50);
		grader.setToolTipText("Position A22");
		frame.add(grader);
		grader.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				grader.setBackground(Color.red);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				grader.setBackground(Color.orange);
			}
		});
		grader.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent arg0)	{
				JOptionPane.showMessageDialog(frame.getComponent(0), "Professor loses grader, recruits you to help.  Earn $400");
				if(player1 == true)	{
					player1Money = player1Money + 400;
					player1MoneyTotal.setText("$ " + String.valueOf(player1Money));
					player1Position.setText("A22");
				}
				else	{
					player2Money = player2Money + 400;
					player2MoneyTotal.setText("$ " + String.valueOf(player2Money));
					player2Position.setText("A22");
				}
				
			}
		});

		JButton internFair = new JButton("<HTML><center>Internship Fair");
		internFair.setBackground(Color.orange);
		internFair.setOpaque(true);
		internFair.setBorder(BorderFactory.createLineBorder(Color.black, 7));
		internFair.setBounds(10, 780, 100, 50);
		internFair.setToolTipText("Position A23");
		frame.add(internFair);
		internFair.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				internFair.setBackground(Color.red);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				internFair.setBackground(Color.orange);
			}
		});
		internFair.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent arg0)	{
				JOptionPane.showMessageDialog(frame.getComponent(0), "Make connection with dream company! Gain 1000 life points");
				if(player1 == true)	{	
					player1isuPoints = player1isuPoints + 1000;
					player1LifePoints.setText(String.valueOf(player1isuPoints));
					player1Position.setText("A23");
				}
				else	{
					player2isuPoints = player2isuPoints + 1000;
					player2LifePoints.setText(String.valueOf(player2isuPoints));
					player2Position.setText("A23");
				}
				
			}
		});

		JButton volunteer = new JButton("<HTML><center>Volunteer For Good Cause");
		volunteer.setBackground(Color.orange);
		volunteer.setOpaque(true);
		volunteer.setBorder(BorderFactory.createLineBorder(Color.black, 7));
		volunteer.setBounds(10, 850, 100, 50);
		volunteer.setToolTipText("Position A24");
		frame.add(volunteer);
		volunteer.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				volunteer.setBackground(Color.red);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				volunteer.setBackground(Color.orange);
			}
		});
		volunteer.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent arg0)	{
				JOptionPane.showMessageDialog(frame.getComponent(0), "Volunteer at the local Human Shelter.  Gain 500 life points");
				if(player1 == true)	{	
					player1isuPoints = player1isuPoints + 500;
					player1LifePoints.setText(String.valueOf(player1isuPoints));
					player1Position.setText("A24");
				}
				else	{
					player2isuPoints = player2isuPoints + 500;
					player2LifePoints.setText(String.valueOf(player2isuPoints));
					player2Position.setText("A24");
				}
				
			}
		});

		JButton tuition = new JButton("<HTML><center>Tuition");
		tuition.setBackground(Color.orange);
		tuition.setOpaque(true);
		tuition.setBorder(BorderFactory.createLineBorder(Color.black, 7));
		tuition.setBounds(10, 920, 100, 50);
		tuition.setToolTipText("Position A25");
		frame.add(tuition);
		tuition.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				tuition.setBackground(Color.red);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				tuition.setBackground(Color.orange);
			}
		});
		tuition.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent arg0)	{
				JOptionPane.showMessageDialog(frame.getComponent(0), "Tuition Bill is due, pay $1000");
				if(player1 == true)	{
					player1Money = player1Money - 1000;
					player1MoneyTotal.setText("$ " + String.valueOf(player1Money));
					player1Position.setText("A25");
				}
				else	{
					player2Money = player2Money - 1000;
					player2MoneyTotal.setText("$ " + String.valueOf(player2Money));
					player2Position.setText("A25");
				}
				
			}
		});

		JButton honorsGraduation = new JButton("<HTML><center>GPA 3.87");
		honorsGraduation.setBackground(Color.orange);
		honorsGraduation.setOpaque(true);
		honorsGraduation.setBorder(BorderFactory.createLineBorder(Color.black, 7));
		honorsGraduation.setBounds(130, 920, 100, 50);
		honorsGraduation.setToolTipText("Position A26");
		frame.add(honorsGraduation);
		honorsGraduation.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				honorsGraduation.setBackground(Color.red);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				honorsGraduation.setBackground(Color.orange);
			}
		});
		honorsGraduation.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent arg0)	{
				JOptionPane.showMessageDialog(frame.getComponent(0), "Set to graduate Magna Cum Laude. Gain 500 ISU Life Points.");
				if(player1 == true)	{	
					player1isuPoints = player1isuPoints + 500;
					player1LifePoints.setText(String.valueOf(player1isuPoints));
					player1Position.setText("A26");
				}
				else	{
					player2isuPoints = player2isuPoints + 500;
					player2LifePoints.setText(String.valueOf(player2isuPoints));
					player2Position.setText("A26");
				}
				
			}
		});

		JButton websiteDevelopment = new JButton("<HTML><center>Design Website");
		websiteDevelopment.setBackground(Color.orange);
		websiteDevelopment.setOpaque(true);
		websiteDevelopment.setBorder(BorderFactory.createLineBorder(Color.black, 7));
		websiteDevelopment.setBounds(250, 920, 100, 50);
		websiteDevelopment.setToolTipText("Position A27");
		frame.add(websiteDevelopment);
		websiteDevelopment.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				websiteDevelopment.setBackground(Color.red);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				websiteDevelopment.setBackground(Color.orange);
			}
		});
		websiteDevelopment.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent arg0)	{
				JOptionPane.showMessageDialog(frame.getComponent(0), "Design local companies website, earn $500");
				if(player1 == true)	{
					player1Money = player1Money + 500;
					player1MoneyTotal.setText("$ " + String.valueOf(player1Money));
					player1Position.setText("A27");
				}
				else	{
					player2Money = player2Money + 500;
					player2MoneyTotal.setText("$ " + String.valueOf(player2Money));
					player2Position.setText("A27");
				}
				
			}
		});

		JButton springBreakStudy = new JButton("<HTML><center>Spring Break");
		springBreakStudy.setBackground(Color.orange);
		springBreakStudy.setOpaque(true);
		springBreakStudy.setBorder(BorderFactory.createLineBorder(Color.black, 7));
		springBreakStudy.setBounds(250, 850, 100, 50);
		springBreakStudy.setToolTipText("Position A28");
		frame.add(springBreakStudy);
		springBreakStudy.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				springBreakStudy.setBackground(Color.red);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				springBreakStudy.setBackground(Color.orange);
			}
		});
		springBreakStudy.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent arg0)	{
				JOptionPane.showMessageDialog(frame.getComponent(0), "Spend Spring Break, preparing for midterms.  Gain 500 ISU Life Points");
				if(player1 == true)	{	
					player1isuPoints = player1isuPoints + 500;
					player1LifePoints.setText(String.valueOf(player1isuPoints));
					player1Position.setText("A28");
				}
				else	{
					player2isuPoints = player2isuPoints + 500;
					player2LifePoints.setText(String.valueOf(player2isuPoints));
					player2Position.setText("A28");
				}
				
			}
		});
		JButton partTimeJob = new JButton("<HTML><center>Part Time Job ");
		partTimeJob.setBackground(Color.orange);
		partTimeJob.setOpaque(true);
		partTimeJob.setBorder(BorderFactory.createLineBorder(Color.black, 7));
		partTimeJob.setBounds(850, 315, 100, 50);
		partTimeJob.setToolTipText("Position B9");
		frame.add(partTimeJob);
		partTimeJob.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				partTimeJob.setBackground(Color.red);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				partTimeJob.setBackground(Color.orange);
			}
		});
		partTimeJob.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent arg0)	{
				JOptionPane.showMessageDialog(frame.getComponent(0), "Get part time job. Collect 1st paycheck $200");
				if(player1 == true)	{
					player1Money = player1Money + 200;
					player1MoneyTotal.setText("$ " + String.valueOf(player1Money));
					player1Position.setText("B9");
				}
				else	{
					player2Money = player2Money + 200;
					player2MoneyTotal.setText("$ " + String.valueOf(player2Money));
					player2Position.setText("B9");
				}
				
			}
		});	

		JButton party = new JButton("<HTML><center>House Party");
		party.setBackground(Color.orange);
		party.setOpaque(true);
		party.setBorder(BorderFactory.createLineBorder(Color.black, 7));
		party.setBounds(850, 385, 100, 50);
		party.setToolTipText("Position B10");
		frame.add(party);
		party.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				party.setBackground(Color.red);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				party.setBackground(Color.orange);
			}
		});
		party.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent arg0)	{
				JOptionPane.showMessageDialog(frame.getComponent(0), "Host party, sell cups for $5.  Make $500");
				if(player1 == true)	{
					player1Money = player1Money + 500;
					player1MoneyTotal.setText("$ " + String.valueOf(player1Money));
					player1Position.setText("B10");
				}
				else	{
					player2Money = player2Money + 500;
					player2MoneyTotal.setText("$ " + String.valueOf(player2Money));
					player2Position.setText("B10");
				}
				
			}
		});

		JButton rentDue = new JButton("<HTML><center>Pay Rent");
		rentDue.setBackground(Color.orange);
		rentDue.setOpaque(true);
		rentDue.setBorder(BorderFactory.createLineBorder(Color.black, 7));
		rentDue.setBounds(730, 385, 100, 50);
		rentDue.setToolTipText("Position B11");
		frame.add(rentDue);
		rentDue.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				rentDue.setBackground(Color.red);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				rentDue.setBackground(Color.orange);
			}
		});
		rentDue.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent arg0)	{
				JOptionPane.showMessageDialog(frame.getComponent(0), "Rent is due, pay $300");
				if(player1 == true)	{
					player1Money = player1Money - 300;
					player1MoneyTotal.setText("$ " + String.valueOf(player1Money));
					player1Position.setText("B11");
				}
				else	{
					player2Money = player2Money - 300;
					player2MoneyTotal.setText("$ " + String.valueOf(player2Money));
					player2Position.setText("B11");
				}
				
			}
		});

		JButton sportingEvent = new JButton("<HTML><center>Sporting Event");
		sportingEvent.setBackground(Color.orange);
		sportingEvent.setOpaque(true);
		sportingEvent.setBorder(BorderFactory.createLineBorder(Color.black, 7));
		sportingEvent.setBounds(610, 385, 100, 50);
		sportingEvent.setToolTipText("Position B12");
		frame.add(sportingEvent);
		sportingEvent.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				sportingEvent.setBackground(Color.red);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				sportingEvent.setBackground(Color.orange);
			}
		});
		sportingEvent.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent arg0)	{
				JOptionPane.showMessageDialog(frame.getComponent(0), "Attend Sporting event, hook up at the after party.  Gain 200 ISU Life Points");
				if(player1 == true)	{	
					player1isuPoints = player1isuPoints + 200;
					player1LifePoints.setText(String.valueOf(player1isuPoints));
					player1Position.setText("B12");
				}
				else	{
					player2isuPoints = player2isuPoints + 200;
					player2LifePoints.setText(String.valueOf(player2isuPoints));
					player2Position.setText("B12");
				}
				
			}
		});

		JButton drawCard4 = new JButton("<HTML><center>Draw a Card4");
		drawCard4.setBackground(Color.cyan);
		drawCard4.setOpaque(true);
		drawCard4.setBorder(BorderFactory.createLineBorder(Color.black, 7));
		drawCard4.setBounds(490, 385, 100, 50);
		drawCard4.setToolTipText("Position B13");
		frame.add(drawCard4);
		drawCard4.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				drawCard4.setBackground(Color.red);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				drawCard4.setBackground(Color.cyan);
			}
		});
		drawCard4.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent arg0)	{
				JOptionPane.showMessageDialog(frame.getComponent(0), "Draw an ISU Life Card");
				if(player1 == true)	{
					player1Position.setText("B13");
				}
				else	{
					player2Position.setText("B13");
				}
				
			}
		});

		JButton payDay = new JButton("<HTML><center>Pay Day");
		payDay.setBackground(Color.green);
		payDay.setOpaque(true);
		payDay.setBorder(BorderFactory.createLineBorder(Color.black, 7));
		payDay.setBounds(370, 385, 100, 50);
		payDay.setToolTipText("Position B14");
		frame.add(payDay);
		payDay.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				payDay.setBackground(Color.red);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				payDay.setBackground(Color.green);
			}
		});
		payDay.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent arg0)	{
				JOptionPane.showMessageDialog(frame.getComponent(0), "Pay Day! Collect $200");
				if(player1 == true)	{
					player1Money = player1Money + 200;
					player1MoneyTotal.setText("$ " + String.valueOf(player1Money));
					player1Position.setText("B14");
				}
				else	{
					player2Money = player2Money + 200;
					player2MoneyTotal.setText("$ " + String.valueOf(player2Money));
					player1Position.setText("B14");
				}
				
			}
		});

		JButton buyTV = new JButton("<HTML><center>Host Party");
		buyTV.setBackground(Color.orange);
		buyTV.setOpaque(true);
		buyTV.setBorder(BorderFactory.createLineBorder(Color.black, 7));
		buyTV.setBounds(250, 385, 100, 50);
		buyTV.setToolTipText("Position B15");
		frame.add(buyTV);
		buyTV.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				buyTV.setBackground(Color.red);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				buyTV.setBackground(Color.orange);
			}
		});
		buyTV.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent arg0)	{
				JOptionPane.showMessageDialog(frame.getComponent(0), "Buy 60 inch TV for the big game, pay $700");
				if(player1 == true)	{
					player1Money = player1Money - 700;
					player1MoneyTotal.setText("$ " + String.valueOf(player1Money));
					player1Position.setText("B15");
				}
				else	{
					player2Money = player2Money - 700;
					player2MoneyTotal.setText("$ " + String.valueOf(player2Money));
					player2Position.setText("B15");
				}
				
			}
		});

		JButton greekHouse = new JButton("<HTML><center>Greek House");
		greekHouse.setBackground(Color.orange);
		greekHouse.setOpaque(true);
		greekHouse.setBorder(BorderFactory.createLineBorder(Color.black, 7));
		greekHouse.setBounds(250, 455, 100, 50);
		greekHouse.setToolTipText("Position B16");
		frame.add(greekHouse);
		greekHouse.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				greekHouse.setBackground(Color.red);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				greekHouse.setBackground(Color.orange);
			}
		});
		greekHouse.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent arg0)	{
				JOptionPane.showMessageDialog(frame.getComponent(0), "Pledge Fraternity/Soroity.  Gain 1000 ISU Life Points.");
				if(player1 == true)	{	
					player1isuPoints = player1isuPoints + 1000;
					player1LifePoints.setText(String.valueOf(player1isuPoints));
					player1Position.setText("B16");
				}
				else	{
					player2isuPoints = player2isuPoints + 1000;
					player2LifePoints.setText(String.valueOf(player2isuPoints));
					player2Position.setText("B16");
				}
				
			}
		});

		JButton springBreak = new JButton("<HTML><center>Mexico ");
		springBreak.setBackground(Color.orange);
		springBreak.setOpaque(true);
		springBreak.setBorder(BorderFactory.createLineBorder(Color.black, 7));
		springBreak.setBounds(250, 525, 100, 50);
		springBreak.setToolTipText("Position B17");
		frame.add(springBreak);
		springBreak.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				springBreak.setBackground(Color.red);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				springBreak.setBackground(Color.orange);
			}
		});
		springBreak.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent arg0)	{
				JOptionPane.showMessageDialog(frame.getComponent(0), "Go to Mexico for Spring Break, have a blast! Gain 1000 life points");
				if(player1 == true)	{	
					player1isuPoints = player1isuPoints + 1000;
					player1LifePoints.setText(String.valueOf(player1isuPoints));
					player1Position.setText("B17");
				}
				else	{
					player2isuPoints = player2isuPoints + 1000;
					player2LifePoints.setText(String.valueOf(player2isuPoints));
					player2Position.setText("B17");
				}
				
			}
		});

		JButton wildParty = new JButton("<HTML><center>Wild Party! ");
		wildParty.setBackground(Color.orange);
		wildParty.setOpaque(true);
		wildParty.setBorder(BorderFactory.createLineBorder(Color.black, 7));
		wildParty.setBounds(250, 595, 100, 50);
		wildParty.setToolTipText("Position B18");
		frame.add(wildParty);
		wildParty.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				wildParty.setBackground(Color.red);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				wildParty.setBackground(Color.orange);
			}
		});
		wildParty.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent arg0)	{
				JOptionPane.showMessageDialog(frame.getComponent(0), "Host party, gets out of hand and windows get broken.  Lose Deposit pay $500");
				if(player1 == true)	{
					player1Money = player1Money -500;
					player1MoneyTotal.setText("$ " + String.valueOf(player1Money));
					player1Position.setText("B18");
				}
				else	{
					player2Money = player2Money -500;
					player2MoneyTotal.setText("$ " + String.valueOf(player2Money));
					player2Position.setText("B18");
				}
				
			}
		});

		JButton turn21 = new JButton("<HTML><center>Turn 21 ");
		turn21.setBackground(Color.orange);
		turn21.setOpaque(true);
		turn21.setBorder(BorderFactory.createLineBorder(Color.black, 7));
		turn21.setBounds(370, 595, 100, 50);
		turn21.setToolTipText("Position B19");
		frame.add(turn21);
		turn21.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				turn21.setBackground(Color.red);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				turn21.setBackground(Color.orange);
			}
		});
		turn21.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent arg0)	{
				JOptionPane.showMessageDialog(frame.getComponent(0), "Turn 21, go to the bars.  Your hung over for days.  Lose a turn");
				if(player1 == true)	{
					player1Position.setText("B19");
				}
				else	{
					player2Position.setText("B19");
				}
				
			}
		});

		JButton academicProbation = new JButton("<HTML><center>Academic Probation ");
		academicProbation.setBackground(Color.orange);
		academicProbation.setOpaque(true);
		academicProbation.setBorder(BorderFactory.createLineBorder(Color.black, 7));
		academicProbation.setBounds(490, 595, 100, 50);
		academicProbation.setToolTipText("Position B20");
		frame.add(academicProbation);
		academicProbation.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				academicProbation.setBackground(Color.red);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				academicProbation.setBackground(Color.orange);
			}
		});
		academicProbation.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent arg0)	{
				JOptionPane.showMessageDialog(frame.getComponent(0), "GPA falls to 1.98, get put on academic probation.  Gain 300 ISU Life Points");
				if(player1 == true)	{	
					player1isuPoints = player1isuPoints + 300;
					player1LifePoints.setText(String.valueOf(player1isuPoints));
					player1Position.setText("B20");
				}
				else	{
					player2isuPoints = player2isuPoints + 300;
					player2LifePoints.setText(String.valueOf(player2isuPoints));
					player2Position.setText("B20");
				}
				
			}
		});

		JButton payRaise = new JButton("<HTML><center>Pay Raise ");
		payRaise.setBackground(Color.orange);
		payRaise.setOpaque(true);
		payRaise.setBorder(BorderFactory.createLineBorder(Color.black, 7));
		payRaise.setBounds(610, 595, 100, 50);
		payRaise.setToolTipText("Position B21");
		frame.add(payRaise);
		payRaise.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				payRaise.setBackground(Color.red);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				payRaise.setBackground(Color.orange);
			}
		});
		payRaise.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent arg0)	{
				JOptionPane.showMessageDialog(frame.getComponent(0), "Boss likes your hard work gives pay raise, collect $300.");
				if(player1 == true)	{
					player1Money = player1Money + 300;
					player1MoneyTotal.setText("$ " + String.valueOf(player1Money));
					player1Position.setText("B21");
				}
				else	{
					player2Money = player2Money + 300;
					player2MoneyTotal.setText("$ " + String.valueOf(player2Money));
					player2Position.setText("B21");
				}
				
			}
		});

		JButton parkingTickets = new JButton("<HTML><center>Registration is Frozen ");
		parkingTickets.setBackground(Color.orange);
		parkingTickets.setOpaque(true);
		parkingTickets.setBorder(BorderFactory.createLineBorder(Color.black, 7));
		parkingTickets.setBounds(730, 595, 100, 50);
		parkingTickets.setToolTipText("Position B22");
		frame.add(parkingTickets);
		parkingTickets.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				parkingTickets.setBackground(Color.red);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				parkingTickets.setBackground(Color.orange);
			}
		});
		parkingTickets.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent arg0)	{
				JOptionPane.showMessageDialog(frame.getComponent(0), "You have 6 unpaid parking tickets.  Pay $300 to remove hold.");
				if(player1 == true)	{
					player1Money = player1Money - 300;
					player1MoneyTotal.setText("$ " + String.valueOf(player1Money));
					player1Position.setText("B22");
				}
				else	{
					player2Money = player2Money - 300;
					player2MoneyTotal.setText("$ " + String.valueOf(player2Money));
					player2Position.setText("B22");
				}
				
			}
		});

		JButton drawCard5 = new JButton("<HTML><center>Draw a Card5");
		drawCard5.setBackground(Color.cyan);
		drawCard5.setOpaque(true);
		drawCard5.setBorder(BorderFactory.createLineBorder(Color.black, 7));
		drawCard5.setBounds(730, 665, 100, 50);
		drawCard5.setToolTipText("Position B23");
		frame.add(drawCard5);
		drawCard5.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				drawCard5.setBackground(Color.red);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				drawCard5.setBackground(Color.cyan);
			}
		});
		drawCard5.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent arg0)	{
				JOptionPane.showMessageDialog(frame.getComponent(0), "Draw an ISU Life Card");
				if(player1 == true)	{
					player1Position.setText("B23");
				}
				else	{
					player2Position.setText("B23");
				}
				
			}
		});

		JButton cheating = new JButton("<HTML><center>Cheating ");
		cheating.setBackground(Color.orange);
		cheating.setOpaque(true);
		cheating.setBorder(BorderFactory.createLineBorder(Color.black, 7));
		cheating.setBounds(730, 735, 100, 50);
		cheating.setToolTipText("Position B24");
		frame.add(cheating);
		cheating.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				cheating.setBackground(Color.red);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				cheating.setBackground(Color.orange);
			}
		});
		cheating.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent arg0)	{
				JOptionPane.showMessageDialog(frame.getComponent(0), "Best Friend caught your Girlfriend/Boyfriend cheating on you.  Gain 500 ISU Life Points");
				if(player1 == true)	{	
					player1isuPoints = player1isuPoints + 500;
					player1LifePoints.setText(String.valueOf(player1isuPoints));
					player1Position.setText("B24");
				}
				else	{
					player2isuPoints = player2isuPoints + 500;
					player2LifePoints.setText(String.valueOf(player2isuPoints));
					player2Position.setText("B24");
				}
				
			}
		});

		JButton christmas = new JButton("<HTML><center>Merry Christmas ");
		christmas.setBackground(Color.orange);
		christmas.setOpaque(true);
		christmas.setBorder(BorderFactory.createLineBorder(Color.black, 7));
		christmas.setBounds(610, 735, 100, 50);
		christmas.setToolTipText("<html><b>Position B25<b>");
		frame.add(christmas);
		christmas.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				christmas.setBackground(Color.red);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				christmas.setBackground(Color.orange);
			}
		});
		christmas.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent arg0)	{
				JOptionPane.showMessageDialog(frame.getComponent(0), "Go home for winter break, collect $500 in Christmas Presents");
				if(player1 == true)	{
					player1Money = player1Money + 500;
					player1MoneyTotal.setText("$ " + String.valueOf(player1Money));
					player1Position.setText("B25");
				}
				else	{
					player2Money = player2Money + 500;
					player2MoneyTotal.setText("$ " + String.valueOf(player2Money));
					player2Position.setText("B25");
				}
				
			}
		});

		JButton gamingTourny = new JButton("<HTML><center>Gaming Tourny ");
		gamingTourny.setBackground(Color.orange);
		gamingTourny.setOpaque(true);
		gamingTourny.setBorder(BorderFactory.createLineBorder(Color.black, 7));
		gamingTourny.setBounds(490, 735, 100, 50);
		gamingTourny.setToolTipText("<html><b>Position B26<b>");
		frame.add(gamingTourny);
		gamingTourny.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				gamingTourny.setBackground(Color.red);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				gamingTourny.setBackground(Color.orange);
			}
		});
		gamingTourny.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent arg0)	{
				JOptionPane.showMessageDialog(frame.getComponent(0), "Win online Gaming Tournament.  Collect $500.");
				if(player1 == true)	{
					player1Money = player1Money + 500;
					player1MoneyTotal.setText("$ " + String.valueOf(player1Money));
					player1Position.setText("B26");
				}
				else	{
					player2Money = player2Money + 500;
					player2MoneyTotal.setText("$ " + String.valueOf(player2Money));
					player2Position.setText("B26");
				}
				
			}
		});

		JButton petition = new JButton("<HTML><center>Petition ");
		petition.setBackground(Color.orange);
		petition.setOpaque(true);
		petition.setBorder(BorderFactory.createLineBorder(Color.black, 7));
		petition.setBounds(370, 735, 100, 50);
		petition.setToolTipText("<html><b>Position B27<b>");
		frame.add(petition);
		petition.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				petition.setBackground(Color.red);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				petition.setBackground(Color.orange);
			}
		});
		petition.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent arg0)	{
				JOptionPane.showMessageDialog(frame.getComponent(0), "Start a petition on a bad professor.  Gain 300 ISU Life Points.");
				if(player1 == true)	{	
					player1isuPoints = player1isuPoints + 300;
					player1LifePoints.setText(String.valueOf(player1isuPoints));
					player1Position.setText("B27");
				}
				else	{
					player2isuPoints = player2isuPoints + 300;
					player2LifePoints.setText(String.valueOf(player2isuPoints));
					player2Position.setText("B27");
				}
				
			}
		});

		JButton payDay1 = new JButton("<HTML><center>Pay Day1");
		payDay1.setBackground(Color.green);
		payDay1.setOpaque(true);
		payDay1.setBorder(BorderFactory.createLineBorder(Color.black, 7));
		payDay1.setBounds(370, 793, 100, 50);
		payDay1.setToolTipText("<html><b>Position B28<b>");
		frame.add(payDay1);
		payDay1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				payDay1.setBackground(Color.red);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				payDay1.setBackground(Color.green);
			}
		});
		payDay1.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent arg0)	{
				JOptionPane.showMessageDialog(frame.getComponent(0), "Pay Day collect $300.");
				if(player1 == true)	{
					player1Money = player1Money + 300;
					player1MoneyTotal.setText("$ " + String.valueOf(player1Money));
					player1Position.setText("B28");
				}
				else	{
					player2Money = player2Money + 300;
					player2MoneyTotal.setText("$ " + String.valueOf(player2Money));
					player2Position.setText("B28");
				}
				
			}
		});

		JButton familyEmergency = new JButton("<HTML><center>Family Emergency");
		familyEmergency.setBackground(Color.orange);
		familyEmergency.setOpaque(true);
		familyEmergency.setBorder(BorderFactory.createLineBorder(Color.black, 7));
		familyEmergency.setBounds(370, 850, 100, 50);
		familyEmergency.setToolTipText("<html><b>Position 29<b>");
		frame.add(familyEmergency);
		familyEmergency.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				familyEmergency.setBackground(Color.red);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				familyEmergency.setBackground(Color.orange);
			}
		});
		familyEmergency.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent arg0)	{
				JOptionPane.showMessageDialog(frame.getComponent(0), "Death in the family, return home for the services.  Lose a turn.");
				if(player1 == true)	{
					player1Position.setText("29");
				}
				else	{
					player2Position.setText("29");
				}
				
			}
		});

		JButton careerFair = new JButton("<HTML><center>Career Fair ");
		careerFair.setBackground(Color.orange);
		careerFair.setOpaque(true);
		careerFair.setBorder(BorderFactory.createLineBorder(Color.black, 7));
		careerFair.setBounds(490, 850, 100, 50);
		careerFair.setToolTipText("<html><b>Position 30<b>");
		frame.add(careerFair);
		careerFair.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				careerFair.setBackground(Color.red);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				careerFair.setBackground(Color.orange);
			}
		});
		careerFair.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent arg0)	{
				JOptionPane.showMessageDialog(frame.getComponent(0), "Attend Career Fair, Make connections with a great company. Gain 500 ISU Life Points.");
				if(player1 == true)	{	
					player1isuPoints = player1isuPoints + 500;
					player1LifePoints.setText(String.valueOf(player1isuPoints));
					player1Position.setText("30");
				}
				else	{
					player2isuPoints = player2isuPoints + 500;
					player2LifePoints.setText(String.valueOf(player2isuPoints));
					player2Position.setText("30");
				}
				
			}
		});

		JButton studentLoan = new JButton("<HTML><center>Loan Interest ");
		studentLoan.setBackground(Color.orange);
		studentLoan.setOpaque(true);
		studentLoan.setBorder(BorderFactory.createLineBorder(Color.black, 7));
		studentLoan.setBounds(610, 850, 100, 50);
		studentLoan.setToolTipText("<html><b>Position 31<b>");
		frame.add(studentLoan);
		studentLoan.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				studentLoan.setBackground(Color.red);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				studentLoan.setBackground(Color.orange);
			}
		});
		studentLoan.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent arg0)	{
				JOptionPane.showMessageDialog(frame.getComponent(0), "Student Loan interest is due.  Pay $300.");
				if(player1 == true)	{
					player1Money = player1Money - 300;
					player1MoneyTotal.setText("$ " + String.valueOf(player1Money));
					player1Position.setText("31");
				}
				else	{
					player2Money = player2Money - 300;
					player2MoneyTotal.setText("$ " + String.valueOf(player2Money));
					player2Position.setText("31");
				}
				
			}
		});

		JButton end = new JButton("<HTML><center>Finish ");
		end.setBackground(Color.red);
		end.setOpaque(true);
		end.setBorder(BorderFactory.createLineBorder(Color.black, 7));
		end.setBounds(730, 850, 100, 50);
		studentLoan.setToolTipText("<html><b>Position FINISH<b>");
		frame.add(end);
		end.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				end.setBackground(Color.cyan);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				end.setBackground(Color.red);
			}
		});
		end.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent arg0)	{
				if(player1 == true)	{
					player1Position.setText("FINISH");
					player1FinalScore = player1isuPoints + player1Money/10;
					if((player1Position.getText().equals("FINISH")) && (!player2Position.getText().equals("FINISH")))	{
						JOptionPane.showMessageDialog(frame.getComponent(0), "Wait for Player 2 to finish.");
					}
					if((player1Position.getText().equals("FINISH")) && (player2Position.getText().equals("FINISH")))	{
						if (player1FinalScore > player2FinalScore)	{
							winner = "The Winner Is: Player 1!!!";
						}
						else if(player1FinalScore<player2FinalScore)	{
							winner = "The Winner Is: Player 2!!!";
						}
						else
							winner = "Player 1 and Player 2 Tie!!!";
						JOptionPane.showMessageDialog(frame.getComponent(0), winner + "\n" +"Player 1 Score: " + player1FinalScore +
								"\n" + "Player 2 Score: " + player2FinalScore);	
						System.exit(0);
					}	
				}
				
				else	{
					player2Position.setText("FINISH");
					player2FinalScore = player2isuPoints + player2Money/10;
					if((!player1Position.getText().equals("FINISH")) && (player2Position.getText().equals("FINISH")))	{
						JOptionPane.showMessageDialog(frame.getComponent(0), "Wait for Player 1 to finish.");
					}
					if((player1Position.getText().equals("FINISH")) && (player2Position.getText().equals("FINISH")))	{
						if (player1FinalScore > player2FinalScore)	{
							winner = "The Winner Is: Player 1!!!";
						}
						else if(player1FinalScore<player2FinalScore)	{
							winner = "The Winner Is: Player 2!!!";
						}
						else
							winner = "Player 1 and Player 2 Tie!!!";
						
						JOptionPane.showMessageDialog(frame.getComponent(0), winner + "\n" +"Player 1 Score: " + player1FinalScore +
								"\n" + "Player 2 Score: " + player2FinalScore);	
						 System.exit(0);
					}
				}
			}
		});
		
		JButton jb = new JButton();
		jb.setBorder(BorderFactory.createLineBorder(Color.black, 7));
		jb.setBounds(1400, 70, 200, 250); 
		frame.add(jb);
		List<Integer> card = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12));
		jb.setIcon(new ImageIcon("it.png"));
		
		jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)  {
				if(card == null || card.size() == 0)
					{
						JOptionPane.showMessageDialog(frame.getComponent(0), "All the cards in the deck are used. Deck is now being reshuffled. Pick another card");
						card.add(1);
						card.add(2);
						card.add(3);
						card.add(4);
						card.add(5);
						card.add(6);
						card.add(7);
						card.add(8);
						card.add(9);
						card.add(10);
						card.add(11);
						card.add(12);
					}
				else
				{
				int cards = card.get(new Random().nextInt(card.size()));

				switch(cards)
				{
				case 1:
					final ImageIcon icon = new ImageIcon("card1.png");
					JOptionPane.showMessageDialog(null, "", "Your Card", JOptionPane.INFORMATION_MESSAGE, icon);
					if(player1 == true)
					{
						player1Money = player1Money + 1000;
						player1MoneyTotal.setText("$ " + String.valueOf(player1Money));
					}
					else if(player1 == false)
					{
						player2Money = player2Money + 1000;
						player2MoneyTotal.setText("$ " + String.valueOf(player2Money));
					}
					card.remove(new Integer(1));
					break;
				case 2:
					final ImageIcon icon1 = new ImageIcon("card2.png");
					JOptionPane.showMessageDialog(null, "", "Your Card", JOptionPane.INFORMATION_MESSAGE, icon1);
					if(player1 == true)
					{
						player1Money = player1Money - 500;
						player1MoneyTotal.setText("$ " + String.valueOf(player1Money));
					}
					else if(player1 == false)
					{
						player2Money = player2Money - 500;
						player2MoneyTotal.setText("$ " + String.valueOf(player2Money));
					}
					card.remove(new Integer(2));
					break;
				case 3:
					final ImageIcon icon2 = new ImageIcon("card3.png");
					JOptionPane.showMessageDialog(null, "", "Your Card", JOptionPane.INFORMATION_MESSAGE, icon2);
					card.remove(new Integer(3));
					break;
				case 4:
					final ImageIcon icon3 = new ImageIcon("card4.png");
					JOptionPane.showMessageDialog(null, "", "Your Card", JOptionPane.INFORMATION_MESSAGE, icon3);
					if(player1 == true)
					{
						player1Money = player1Money - 500;
						player1MoneyTotal.setText("$ " + String.valueOf(player1Money));
					}
					else if(player1 == false)
					{
						player2Money = player2Money - 500;
						player2MoneyTotal.setText("$ " + String.valueOf(player2Money));
					}
					card.remove(new Integer(4));
					break;
				case 5:
					final ImageIcon icon4 = new ImageIcon("card5.png");
					JOptionPane.showMessageDialog(null, "", "Your Card", JOptionPane.INFORMATION_MESSAGE, icon4);
					if(player1 == true)
					{
						player1Money = player1Money - 1000;
						player1MoneyTotal.setText("$ " + String.valueOf(player1Money));
					}
					else if(player1 == false)
					{
						player2Money = player2Money - 1000;
						player2MoneyTotal.setText("$ " + String.valueOf(player2Money));
					}
					card.remove(new Integer(5));
					break;
				case 6:
					final ImageIcon icon5 = new ImageIcon("card6.png");
					JOptionPane.showMessageDialog(null, "", "Your Card", JOptionPane.INFORMATION_MESSAGE, icon5);
					if(player1 == true)
					{
						player1Money = player1Money + 400;
						player1MoneyTotal.setText("$ " + String.valueOf(player1Money));
					}
					else if(player1 == false)
					{
						player2Money = player2Money + 400;
						player2MoneyTotal.setText("$ " + String.valueOf(player2Money));
					}
					card.remove(new Integer(6));
					break;
				case 7:
					final ImageIcon icon6 = new ImageIcon("card7.png");
					JOptionPane.showMessageDialog(null, "", "Your Card", JOptionPane.INFORMATION_MESSAGE, icon6);
					card.remove(new Integer(7));
					break;
				case 8:
					final ImageIcon icon7 = new ImageIcon("card8.png");
					JOptionPane.showMessageDialog(null, "", "Your Card", JOptionPane.INFORMATION_MESSAGE, icon7);
					if(player1 == true)
					{
						player1Money = player1Money + 400;
						player1MoneyTotal.setText("$ " + String.valueOf(player1Money));
					}
					else if(player1 == false)
					{
						player2Money = player2Money + 400;
						player2MoneyTotal.setText("$ " + String.valueOf(player2Money));
					}
					card.remove(new Integer(8));
					break;
				case 9:
					final ImageIcon icon8 = new ImageIcon("card9.png");
					JOptionPane.showMessageDialog(null, "", "Your Card", JOptionPane.INFORMATION_MESSAGE, icon8);
					if(player1 == true)
					{
						player1Money = player1Money - 400;
						player1MoneyTotal.setText("$ " + String.valueOf(player1Money));
					}
					else if(player1 == false)
					{
						player2Money = player2Money - 400;
						player2MoneyTotal.setText("$ " + String.valueOf(player2Money));
					}
					card.remove(new Integer(9));
					break;
				case 10:
					final ImageIcon icon9 = new ImageIcon("card10.png");
					JOptionPane.showMessageDialog(null, "", "Your Card", JOptionPane.INFORMATION_MESSAGE, icon9);
					if(player1 == true)
					{
						player1Money = player1Money + 600;
						player1MoneyTotal.setText("$ " + String.valueOf(player1Money));
					}
					else if(player1 == false)
					{
						player2Money = player2Money + 600;
						player2MoneyTotal.setText("$ " + String.valueOf(player2Money));
					}
					card.remove(new Integer(10));
					break;
				case 11:
					final ImageIcon icon10 = new ImageIcon("card11.png");
					JOptionPane.showMessageDialog(null, "", "Your Card", JOptionPane.INFORMATION_MESSAGE, icon10);
					card.remove(new Integer(11));
					break;
				case 12:
					final ImageIcon icon11 = new ImageIcon("card12.png");
					JOptionPane.showMessageDialog(null, "", "Your Card", JOptionPane.INFORMATION_MESSAGE, icon11);
					card.remove(new Integer(12));
					break;
				}}	
				}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub

	}

}