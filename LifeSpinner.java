import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LifeSpinner extends JFrame implements ActionListener,Runnable
{
	//Declaration of variables
    public int seconds;
    JButton start;
    JPanel panel; 
    Spinner spin;
    int flag=0;
    int spinSeconds;
    int minimumSpinTime; 
    int maximumSpinTime; 
    
    //Constructor
    public LifeSpinner() {
       super("LifeSpinner");
        setSize(510,680);
        setLayout(null);
      
        //Adds the panel
        panel=new JPanel();
        panel.setBackground(Color.black);
        panel.setBounds(0,0,500,500);
        add(panel);



        
          
        //Set the minimum and maximum spin time
        minimumSpinTime=80;
        maximumSpinTime=190;
      
       //Set windows resizable to false. Set default close operation. 
       setResizable(false);
     
   }
    
    public JButton getButton()
    {
    	start=new JButton("Spin");
    	start.addActionListener(this);
    	return start;
    }
    public JPanel getPanel ()
    {
    	//Adds the panel
        panel=new JPanel();
        panel.setBackground(Color.black);
        panel.setBounds(1100, 450,500,500);
        add(panel);


        //Add Start button
 
        
          
        //Set the minimum and maximum spin time
        minimumSpinTime=80;
        maximumSpinTime=190;
      
       //Set windows resizable to false. Set default close operation. 
       setResizable(false);
       
       
       return panel;
    }
    
    
    
    public static void main(String args[]) {
        new LifeSpinner().setVisible(true);
}

   public void actionPerformed(ActionEvent e){
       spin=new Spinner(this);
        panel.add(spin);
       //Calculates a random time between the minimum and maximum spin time that was set above.
       spinSeconds = minimumSpinTime + (int)(Math.random() * maximumSpinTime);
       spinSeconds=(spinSeconds/10)*10;
      
      
        //Start Thread
        if(flag==0){
           Thread spinner=new Thread(this);
           spinner.start();
           flag=1;
       }
        seconds=0;
        

   }
  
   //needle method
   public void run()
   {

       seconds=0;
       while(true)
       {
              
           try {
               //Increment seconds if less than spinSeconds
               if(seconds<spinSeconds){
                   seconds=seconds+1;
               }
               //Rotation of the needle based on the random time
               if(seconds >0 && seconds<spinSeconds/2){
                   Thread.sleep(10);
               }
               else if(seconds >spinSeconds/2 && seconds<(3*spinSeconds/4)){
                   Thread.sleep(15);
               }
               else if(seconds >(3*spinSeconds/4) && seconds<(3.5*spinSeconds/4)){
                   Thread.sleep(20);
               }
               else if(seconds >(3.5*spinSeconds/4) && seconds<(3.8*spinSeconds/4)){
                   Thread.sleep(25);
               }
               else{
                       Thread.sleep(50);
               }
           }catch (InterruptedException ex) {}

           spin.repaint();
       }
   }


}


//Spinner class
class Spinner extends JPanel{

    LifeSpinner parent;
  
    public Spinner(LifeSpinner parent1){
        setSize(520,530);
        parent=parent1;
    }


   //Creating the spinner
   public void paintComponent(Graphics g) {
        g.setColor(new Color(0,0,0));
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.WHITE);
        g.fillOval(5, 5,480,480);
        g.setColor(new Color(255,0,0));
        g.fillOval(10, 10,470,470);
        g.setColor(Color.BLACK);
        g.fillOval(237,237,15,15);
        g.setFont(g.getFont().deriveFont(Font.BOLD,32));
       
        for(int i=1;i<=12;i++){
           if(i%2==0){
               g.drawString(Integer.toString((i/2)%6+1),240-(i/12)*11+(int)(210*Math.sin(i*Math.PI/6)),253-(int)(210*Math.cos(i*Math.PI/6)));
           }
       }
      
      
        double minimumSpinTimedeg=(double)Math.PI/30;
        int x,y;

        //Rotating the spinner
        x=245+(int)(210*Math.sin(parent.seconds*minimumSpinTimedeg));
        y=245-(int)(210*Math.cos(parent.seconds*minimumSpinTimedeg));
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(10));
        g.drawLine(245,245,x,y);

    }

}