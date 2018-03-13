import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class cards extends JFrame implements ActionListener
{
	static JPanel jp = new JPanel();
	static JButton jb = new JButton();
	static List<String> card = new ArrayList<String>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"));
	static int money;

		private static void theCards(JFrame frame)
		{
			jb.setIcon(new ImageIcon("it.png"));
			jp.add(jb);
			frame.add(jp);
			jb.addActionListener(new ActionListener()
		{
			 public void actionPerformed(ActionEvent arg0)
			 {
			 Collections.shuffle(Arrays.asList(card));
//			 String cards = card.			 
				 switch(card.size())
					{
					case 1:
						final ImageIcon icon = new ImageIcon("card1.png");
				        JOptionPane.showMessageDialog(null, "", "Your Card", JOptionPane.INFORMATION_MESSAGE, icon);
				
				        card.remove(0);
						break;
					case 2:
						final ImageIcon icon1 = new ImageIcon("card2.png");
				        JOptionPane.showMessageDialog(null, "", "Your Card", JOptionPane.INFORMATION_MESSAGE, icon1);
			
						card.remove(1);
						break;
					case 3:
						final ImageIcon icon2 = new ImageIcon("card3.png");
				        JOptionPane.showMessageDialog(null, "", "Your Card", JOptionPane.INFORMATION_MESSAGE, icon2);
				
				        card.remove(2);
						break;
					case 4:
						final ImageIcon icon3 = new ImageIcon("card4.png");
				        JOptionPane.showMessageDialog(null, "", "Your Card", JOptionPane.INFORMATION_MESSAGE, icon3);
			
				        card.remove(3);
						break;
					case 5:
						final ImageIcon icon4 = new ImageIcon("card5.png");
				        JOptionPane.showMessageDialog(null, "", "Your Card", JOptionPane.INFORMATION_MESSAGE, icon4);
				
				        card.remove(4);
						break;
					case 6:
						final ImageIcon icon5 = new ImageIcon("card6.png");
				        JOptionPane.showMessageDialog(null, "", "Your Card", JOptionPane.INFORMATION_MESSAGE, icon5);
			
				        card.remove(5);
						break;
					case 7:
						final ImageIcon icon6 = new ImageIcon("card7.png");
				        JOptionPane.showMessageDialog(null, "", "Your Card", JOptionPane.INFORMATION_MESSAGE, icon6);
		
				        card.remove(6);
						break;
					case 8:
						final ImageIcon icon7 = new ImageIcon("card8.png");
				        JOptionPane.showMessageDialog(null, "", "Your Card", JOptionPane.INFORMATION_MESSAGE, icon7);
		
						card.remove(7);
						break;
					case 9:
						final ImageIcon icon8 = new ImageIcon("card9.png");
				        JOptionPane.showMessageDialog(null, "", "Your Card", JOptionPane.INFORMATION_MESSAGE, icon8);
		
				        card.remove(8);
						break;
					case 10:
						final ImageIcon icon9 = new ImageIcon("card10.png");
				        JOptionPane.showMessageDialog(null, "", "Your Card", JOptionPane.INFORMATION_MESSAGE, icon9);
	
				        card.remove(9);
						break;
//					case 11:
//						final ImageIcon icon10 = new ImageIcon("card11.png");
//						JOptionPane.showMessageDialog(null, "", "Your Card", JOptionPane.INFORMATION_MESSAGE, icon10);
//						break;
//					
//				 case 12:
//					 final ImageIcon icon11 = new ImageIcon("card12.png");
//					 JOptionPane.showMessageDialog(null, "", "Your Card", JOptionPane.INFORMATION_MESSAGE, icon11);
//					 break;
			 }}
				});
	}
		
	  public static void main(String[] args)
	  {
		JFrame frame = new JFrame("Game of Life");
		frame.setSize(1000, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theCards(frame);
		frame.setVisible(true);
	  }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
}

