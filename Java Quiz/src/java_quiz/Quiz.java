package java_quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Quiz extends JFrame implements ActionListener{
	
	JButton next, submit, lifeline;
	public static int count =0;
	public static int timer = 30;
	public static int ans_given = 0;
	public static int score = 0;
	JLabel qno, question;
	String q[] [] = new String[10][5];
	String pa[][] = new String[10][1];
	String qa[][] = new String[10][2];
	JRadioButton opt1, opt2, opt3, opt4;
	ButtonGroup options;
	
	String username;
	Quiz(String username){
		this.username = username;
		
		setBounds(100, 30, 1300, 800);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("java_quiz/res/icons/5.jpg"));
		JLabel l1 = new JLabel (i1);
		l1.setBounds(0, 0, 1300, 392);
		add(l1);
		
		qno = new JLabel("");
		qno.setFont(new Font("tahoma", Font.PLAIN,20));
		qno.setBounds(100, 450, 40, 30);
		add(qno);
		
		question = new JLabel("");
		question.setFont(new Font("tahoma", Font.PLAIN,20));
		question.setBounds(150, 450, 700, 30);
		add(question);
		 
		q[0][0] = "What is the default value of int variable?";
        q[0][1] = "0";
        q[0][2] = "0.0";
        q[0][3] = "null";
        q[0][4] = "not defined";

        q[1][0] = "Which of the following is false about String?";
        q[1][1] = "String is immutable.";
        q[1][2] = "String can be created using new operator.";
        q[1][3] = "string is a primary data type.";
        q[1][4] = "None of the above.";

        q[2][0] = "Which method must be implemented by all threads?";
        q[2][1] = "run()";
        q[2][2] = "start()";
        q[2][3] = "wait()";
        q[2][4] = "stop()";

        q[3][0] = "Which is used to find and fix bugs in the Java programs?";
        q[3][1] = "JVM";
        q[3][2] = "JDB";
        q[3][3] = "JDK";
        q[3][4] = "JRE";

        q[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        q[4][1] = "Stack";
        q[4][2] = "String memory";
        q[4][3] = "Random storage space";
        q[4][4] = "Heap memory";

        q[5][0] = "How do you insert COMMENTS in Java code?";
        q[5][1] = "# This is a comment";
        q[5][2] = "// This is a comment";
        q[5][3] = "/* This is a comment";
        q[5][4] = "/* This is a comment*/";

        q[6][0] = "Which of the following is a mutable class in java?";
        q[6][1] = "java.lang.StringBuilder";
        q[6][2] = "java.lang.Short";
        q[6][3] = "java.lang.Byte";
        q[6][4] = "java.lang.String";

        q[7][0] = "In java, jar stands for?";
        q[7][1] = "Java Archive Runner";
        q[7][2] = "Java Archive";
        q[7][3] = "Java Application Resource";
        q[7][4] = "Java Application Runner";

        q[8][0] = "Which keyword is used for accessing the features of a package?";
        q[8][1] = "import";
        q[8][2] = "package";
        q[8][3] = "extends";
        q[8][4] = "export";
        

        q[9][0] = "To declare an array in Java, define the variable type with:";
        q[9][1] = "<>";
        q[9][2] = "[]";
        q[9][3] = "{}";
        q[9][4] = "()";
		
        qa[0][1] = "0";
        qa[1][1] = "string is a primary data type.";
        qa[2][1] = "run()";
        qa[3][1] = "JDB";
        qa[4][1] = "Heap memory";
        qa[5][1] = "// This is a comment";
        qa[6][1] = "java.lang.StringBuilder";
        qa[7][1] = "Java Archive";
        qa[8][1] = "import";
        qa[9][1] = "[]";
          
		opt1 = new JRadioButton("");
		opt1.setFont(new Font("Dialog", Font.PLAIN,16));
		opt1.setBounds(170, 520, 700, 30);
		opt1.setBackground(Color.WHITE);
		add(opt1);
		
		opt2 = new JRadioButton("");
		opt2.setFont(new Font("Dialog", Font.PLAIN,16));
		opt2.setBounds(170, 560, 700, 30);
		opt2.setBackground(Color.WHITE);
		add(opt2);
		
		opt3 = new JRadioButton("");
		opt3.setFont(new Font("Dialog", Font.PLAIN,16));
		opt3.setBounds(170, 600, 700, 30);
		opt3.setBackground(Color.WHITE);
		add(opt3);
		
		
		opt4 = new JRadioButton("");
		opt4.setFont(new Font("Dialog", Font.PLAIN,16));
		opt4.setBounds(170, 640, 700, 30);
		opt4.setBackground(Color.WHITE);
		add(opt4);
		
		options = new ButtonGroup();
		options.add(opt1);
		options.add(opt2);
		options.add(opt3);
		options.add(opt4);
		
		next = new JButton("Next");
		next.setFont(new Font("Tahoma", Font.PLAIN, 22));
		next.setBackground(Color.ORANGE);

		next.addActionListener(this);
		next.setBounds(1000, 620, 150, 30);
		add(next);
		
		
		lifeline = new JButton("50-50 Lifeline");
		lifeline.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lifeline.setBackground(Color.ORANGE);
	
		lifeline.addActionListener(this);
		lifeline.setBounds(1000, 660, 150, 30);
		add(lifeline);
		
		submit = new JButton("Submit");
		submit.setFont(new Font("Tahoma", Font.PLAIN, 22));
		submit.setEnabled(false);
		submit.setBackground(Color.ORANGE);
		
		submit.addActionListener(this);
		submit.setBounds(1000, 700, 150, 35);
		add(submit);
		
		start(0);
	}

	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == next) {
			repaint();
			opt1.setEnabled(true);
			opt2.setEnabled(true);
			opt3.setEnabled(true);
			opt4.setEnabled(true);
			ans_given = 1;
			if(options.getSelection() == null) {
				pa[count][0] = "";
			}else {
				 pa[count][0] = options.getSelection().getActionCommand();
			}
			
			if(count == 8) {
				next.setEnabled(false);
				submit.setEnabled(true);
			}
			
			count++;
			start(count);
		}else if(ae.getSource() == submit) {
			ans_given = 1;
			if(options.getSelection() == null) {
				pa[count][0] = "";
			}else {
				 pa[count][0] = options.getSelection().getActionCommand();
			}
			for(int i=0; i < pa.length ; i++) {
				if(pa[i][0].equals(qa[i][1])) {
					score+=10;
				}else {
					score+=0;
				}
			}
			this.setVisible(false);
			new Score(username, score).setVisible(true);	
			
		}else if (ae.getSource() == lifeline) {
			if(count == 2 || count == 4 || count == 6 || count == 8 || count == 10) {
				opt2.setEnabled(false);
				opt3.setEnabled(false);
				}else {
					opt1.setEnabled(false);
					opt4.setEnabled(false);
				}
			lifeline.setEnabled(false);
		}
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		String time = "Time Left - " + timer +  "seconds"; //15
		g.setColor(Color.RED);
		g.setFont(new Font("Tahoma", Font.BOLD, 22));
		g.drawString(time, 1000, 500);
		
		if(timer > 0) {
			g.drawString(time, 1000, 500);
		
		}else {
			
			g.drawString("Times Up!!", 1000, 550);
		}
		
		timer--; //29
		
		try {
			Thread.sleep(1000);
			repaint();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		if(ans_given == 1) {
			ans_given = 0;
				timer =30;
			}else if(timer <0) {
				timer = 30;
				opt1.setEnabled(true);
				opt2.setEnabled(true);
				opt3.setEnabled(true);
				opt4.setEnabled(true);
				
				if(count == 8) {
					next.setEnabled(false);
					submit.setEnabled(true);
				}
				
				if(count ==9) {
					if(options.getSelection() == null) {
						pa[count][0] = "";
					}else {
						 pa[count][0] = options.getSelection().getActionCommand();
					}
					for(int i=0; i < pa.length ; i++) {
						if(pa[i][0].equals(qa[i][1])) {
							score+=10;
						}else {
							score+=0;
						}
					}
					this.setVisible(false);
					new Score(username, score).setVisible(true);			}
			else {
				if(options.getSelection() == null) {
					pa[count][0] = "";
				}else {
					 pa[count][0] = options.getSelection().getActionCommand();
				}
				count++;
				start(count);
			}
	 	}
}
	
	
	public void start(int count) {
		qno.setText("" + (count  + 1) + ".");
		question.setText(q[count][0]);
		opt1.setLabel(q[count][1]);
		opt1.setActionCommand(q[count][1]);
		opt2.setLabel(q[count][2]);
		opt2.setActionCommand(q[count][2]);
		opt3.setLabel(q[count][3]);
		opt3.setActionCommand(q[count][3]);
		opt4.setLabel(q[count][4]);
		opt4.setActionCommand(q[count][4]);
	    options.clearSelection();
	} 
	public static void main(String[] args) {
		new Quiz("").setVisible(true);
	}
}
