package cal;

import javax.swing.*;

public class CalFrame extends JFrame  {
	JTabbedPane tab;
	LinearPane line;
	HelpPane help;
	AveragePane average;
	public CalFrame(){
		super("Linear Calculator ");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/**
		 * set WindowsLookAndfeel
		 */
		try{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		}
		catch(Exception e){			
		}
		
		tab = new JTabbedPane(JTabbedPane.LEFT);
				
		
		line = new LinearPane(this);
		JScrollPane scrollLine = new JScrollPane(line, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		
		average = new AveragePane(this);
		help = new HelpPane();
		
		tab.addTab("Linear", scrollLine);
		tab.addTab("Average", average);
		tab.addTab("Help", help);
		
			
		//this.setSize(500, 300);
		setContentPane(tab);
		
		pack();
		setVisible(true);
	}
	
	
	
	public static void main(String args[]){
		CalFrame c= new CalFrame();
	}

}
