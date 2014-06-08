package SRM144DIV1;

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

public class LotterySwing {
	public static void main(String args[]) throws IOException {
		new LotterySwing();
	}
	
	LotterySwing() throws IOException {
		
		//setting frame settings and layout
		final JFrame frame = new JFrame("Lottery Ranking System");
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
		final Lottery h = new Lottery();
		
		final JPanel area = new JPanel();
		area.setLayout(null);
		
		final JLabel message = new JLabel("Enter the lottery settings:");
		final JTextField textArea = new JTextField("\"INDIGO: 93 8 T F\",\"ORANGE: 29 8 F T\",\"VIOLET: 76 6 F F\",\"BLUE: 100 8 T T\",\"RED: 99 8 T T\",\"GREEN: 78 6 F T\",\"YELLOW: 75 6 F F\"");
		final JLabel result = new JLabel(" Find out which lottery is best!");
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
	        		
	        		String coded =textArea.getText();
	        		if(coded.equalsIgnoreCase("")||coded==null){
	        			throw new Exception();
	        		}
	        		int count = coded.length() - coded.replace(":", "").length();
	        		String[] compare = new String[count];
	        		int pos1=1;
	        		int pos2=coded.indexOf("\"",pos1);
	        		
	        		for(int i=0;i<count;i++){
	        			//"INDIGO: 93 8 T F","ORANGE: 29 8 F T","VIOLET: 76 6 F F","BLUE: 100 8 T T","RED: 99 8 T T","GREEN: 78 6 F T","YELLOW: 75 6 F F"
	        			
	        			if(i<=count-2){
	        				
		        			compare[i]=coded.substring(pos1, pos2);
		        			pos1=pos2+3;
		        			pos2=coded.indexOf("\",\"",pos2+1);
	        			}
	        			else{
	        				
	        				compare[i]=coded.substring(pos1, coded.length()-1);
	        			}
	        			
	        			
	        		}
	        		
	        		compare = h.sortByOdds(compare);
	        		result.setText("Your best bet is in this order: ");
	        		for(int i=0;i<compare.length;i++){
	        			result.setText(result.getText()+" "+compare[i]);
	        		}
	        		textArea.setText("");
	        		textArea.requestFocus();
	        		
	        	}
	        	catch(Exception x){
	        		String message="Please enter a valid value!\nFormat: \"NAME OF LOTTERY: NUM_OF_CHOICES NUM_OF_BLANKS SORTED_T_F UNIQUE_T_F\"!";
	        		
	        		JOptionPane.showMessageDialog(frame, message, "Error", 0);
	        		textArea.setText("");
	        		textArea.requestFocus();
	        	}
	        }
		});
		
		
		frame.setVisible(true);

	}

}
