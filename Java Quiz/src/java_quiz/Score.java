package java_quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Score extends JFrame implements ActionListener{
        
	   Score(String username, int score){
		   setBounds(300, 150, 800, 600);
		   getContentPane().setBackground(Color.WHITE);
		   setLayout(null);
		   
		   ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("java_quiz/res/icons/creditscore.png"));
		   JLabel l1 = new JLabel(i1);
			l1.setBounds(0, 130, 400, 500);
		    add(l1);
		    
		    JLabel l2 = new JLabel(" Thankyou " + username +  " for playing Java Quiz ");
		    l2.setBounds(45, 30, 700, 30);
		    l2.setFont(new Font("Mongolian Baiti",Font.PLAIN, 26));
		    add(l2);
		    
		    JLabel l3 = new JLabel("Your Score is " + score);
		    l3.setBounds(480, 200, 500, 30);
		    l3.setFont(new Font("JOKERMAN",Font.PLAIN, 26));
		    add(l3);
		    
		    JButton b1 = new JButton("Play Again");
		    b1.setBounds(520, 250, 120, 25);
		    b1.setBackground(Color.ORANGE);
			
			b1.addActionListener(this);
		    add(b1);
	   }
	   
	   public void actionPerformed(ActionEvent ae) {
		   this.setVisible(false); 
		   new JavaQuiz().setVisible(true);
	   }
	   	
	   public static void main (String[] args) {
		   new Score("", 0).setVisible(true);
	   }
	   }
