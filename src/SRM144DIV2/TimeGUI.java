package SRM144DIV2;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.math.BigInteger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class TimeGUI{
	public static void main(String args[]) throws IOException {
		new TimeGUI();
	}
	
	TimeGUI() throws IOException {
		
		//setting frame settings and layout
		final JFrame frame = new JFrame("Seconds Conversion System");
		final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		
		frame.setBounds((int)(dim.getHeight()/2),(int)(dim.getWidth()/5), 500, 80);
		frame.setSize(500, 150);
		frame.setLayout(new GridLayout(3,1));
		
		frame.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent windowEvent){
	             System.exit(0);
	          }        
	       });  
		
		//setting button functionality
		final Time t = new Time();
		
		final JPanel area = new JPanel();
		area.setLayout(null);
		
		final JLabel message = new JLabel("Enter the seconds:");
		final JTextField textArea = new JTextField("");
		final JLabel result = new JLabel(" Find out the H:M:S converstion!");
		final JButton submit = new JButton("Submit");
		final JScrollPane scroll = new JScrollPane(result);
		
		message.setLocation(10,0);
		message.setSize(200, 50);
		textArea.setLocation(153, 15);
		textArea.setSize(240, 20);
		textArea.requestFocus();
		scroll.setLocation(10, 45);
		scroll.setSize(475, 50);
		submit.setLocation(405, 15);
		submit.setSize(80, 20);
		
		area.add(message);
		area.add(textArea);
		area.add(submit);
		area.add(scroll);
		
		area.setOpaque(true);
		
		frame.setContentPane(area);
		
		submit.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	       	 
	        	try{
	        		
	        		int coded =Integer.parseInt(textArea.getText());

	        		result.setText("Your result is: "+ t.whatTime(coded));
	        	
	        		textArea.setText("");
	        		textArea.requestFocus();
	        		
	        	}
	        	catch(Exception x){
	        		String message="Please enter a valid integer!";
	        		
	        		JOptionPane.showMessageDialog(frame, message, "Error", 0);
	        		textArea.setText("");
	        		textArea.requestFocus();
	        	}
	        }
		});
		
		
		frame.setVisible(true);

	}

}
