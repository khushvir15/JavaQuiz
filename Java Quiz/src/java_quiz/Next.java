package java_quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Next extends JFrame implements ActionListener{

	JButton b1, b2;
	String username;
	Next(String username){                                 //constructor
		this.username = username;
		setBounds(300, 200, 800, 500);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel l1 = new JLabel("Welcome " + username +" to Java Quiz");
		l1.setForeground(Color.ORANGE);
		l1.setFont(new Font("Viner Hand ITC",Font.BOLD, 28));
		l1.setBounds(50, 20, 700, 30);
		add(l1);
		
		
		
		
		JLabel l2 = new JLabel("");
		l2.setForeground(Color.ORANGE);
		l2.setFont(new Font("Mongolian Baiti", Font.PLAIN, 16));
		l2.setBounds(20, 0, 600, 350);
		l2.setText(
				"<html>"+
		                "There are 10 questions. " + "<br><br>" +
                        "Each question contain 10 points." + "<br><br>" + 
                        "If you forgot to submit, the quiz is automatically submit." + "<br><br>" +

	        	"</html>"
				);
		add(l2);
		
		
		
		
		
		JLabel l3 = new JLabel("");
		l3.setFont(new Font("Mongolian Baiti", Font.PLAIN, 16));
		l3.setBounds(20, 150, 600, 350);
		l3.setText(
				"<html>"+
						"Rules -" + "<br><br>" +  
                        "* In each and every question You got a lifeline but you use it at once ." + "<br><br>" + 
                        "* For each question you got 30 seconds to answer it." + "<br><br>" + 

	        	"</html>"
				);
		add(l3);
		
		



		b1 = new JButton("Back");
		b1.setBounds(250, 400, 100, 30);
		b1.setBackground(Color.orange);
		// b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		add(b1);
		
		
		b2 = new JButton("Start");
		b2.setBounds(400, 400, 100, 30);
		b2.setBackground(Color.orange);
		//b2.setForeground(Color.WHITE);
		b2.addActionListener(this);
		add(b2);
		
		
		
		
		setVisible(true);
		
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == b1) {
			this.setVisible(false);
			new JavaQuiz().setVisible(true);
		}else if(ae.getSource() == b2) {
			this.setVisible(false);
			new Quiz(username).setVisible(true);	
		}
	}
	
	public static void main(String[] args) {                              //main method
		new Next("");
	}
}
