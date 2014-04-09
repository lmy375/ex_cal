package cal;

import java.text.DecimalFormat;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import assi.*;

public class AveragePane extends JPanel implements ActionListener{
	CalFrame frame;
	
	/**
	 * number set button
	 */
	JButton setNum;
	
	JTextField numText;
	public static int number=8;
	
	JTextField accText;
	DecimalFormat nf;
	DecimalFormat nf2;
	static int accuracy=5;
	
	/**
	 * calculate button
	 */
	JButton calButton;
	JButton exportResult;
	
	
	public CalTextField[] x;
	public JLabel xSum;
	public JLabel xAverage;
	
	public JLabel sx;
	
	
	
	public AveragePane(CalFrame f){
		
		super();
		frame=f;
		nf = new DecimalFormat();
		nf.setGroupingUsed(false);
	 	nf.setMaximumFractionDigits(accuracy);
	 	nf2 = new DecimalFormat();
		nf2.setGroupingUsed(false);
	 	nf2.setMaximumFractionDigits(2*accuracy);
		
		JPanel mainPane = new JPanel();
		mainPane.setLayout(new BorderLayout());
		/**
		 *  setting  button
		 */
		setNum= new JButton("更新设置");
		setNum.addActionListener(this);
		
		JLabel num = new JLabel("设置组数");
		numText = new JTextField(number+"");
		JLabel acc = new JLabel("保留小数位数");
		accText = new JTextField(accuracy+"");
				
		/**
		 * north pane
		 */
		
		JPanel northPane = new JPanel();
		JPanel numPane = new JPanel();
		numPane.setLayout(new GridLayout(1,5));
		numPane.add(num);
		numPane.add(numText);
		numPane.add(acc);
		numPane.add(accText);
		numPane.add(setNum);
		northPane.add(numPane);
		mainPane.add("North",northPane );
		
		JPanel centerPane = new JPanel();
		centerPane.setLayout(new GridLayout(2, number+3));
		/**
		 *south pane
		 */
		
		JPanel resultPane = new JPanel();
		resultPane.setLayout(new GridLayout(1,4));
		resultPane.add(new JLabel("s(x)="));
		sx= new JLabel();
		resultPane.add(sx);
				
		calButton = new JButton("Calculate");
		calButton.addActionListener(this);
		resultPane.add(calButton);	
		
		exportResult = new JButton("Export Result");
		exportResult.addActionListener(this);
		resultPane.add(exportResult);	
		
		
		mainPane.add("South", resultPane);
		
		
		/**
		 * title line
		 */
		centerPane.add(new JLabel("No."));
		for(int i = 1;i<=number; i++){
			centerPane.add(new JLabel(""+i));
		}
		centerPane.add(new JLabel("Sum"));
		centerPane.add(new JLabel("Average"));
		
		
		/**
		 * x line
		 */
		centerPane.add(new JLabel("X"));
		x =new CalTextField[number];
		for(int i = 0;i<number;i++){
			x[i]= new CalTextField();
			centerPane.add(x[i]);
		}
		xSum= new JLabel();
		centerPane.add(xSum);
		xAverage = new JLabel();
		centerPane.add(xAverage);
				
		
		mainPane.add("Center", centerPane);
		
		
		this.add(mainPane);
		
	}
	
	
	/**
	 * get sum of a set of components
	 * @param c
	 * @param n
	 * @return the sum
	 */	
	public double getSum(CalTextField[] c){
		double result =0;
		for(int i= 0 ;i<number; i++){
			try{
				result+=Double.parseDouble(c[i].calText());
			}
			catch(NumberFormatException nfe){
				JOptionPane.showMessageDialog(null, "Check the input!", "Error", JOptionPane.ERROR_MESSAGE);
				c[i].setText(0+"");
				result =0;
			}
		}			
		return result;
	}
	public double getSum(JLabel[] c){
		double result=0;
		for(int i= 0 ;i<number; i++){
			try{
				result+=Double.parseDouble(c[i].getText());
			}
			catch(NumberFormatException nfe){
				JOptionPane.showMessageDialog(null, "Check the input!", "Error", JOptionPane.ERROR_MESSAGE);
				c[i].setText(0+"");
				result =0;
			}
		}			
		return result;
	}
	
	/**
	 * calculate the table
	 */
	public void calculate(){
		
		/**
		 * calculate x line
		 */
		xSum.setText(nf.format(getSum(x)));
		xAverage.setText(nf.format(getSum(x)/(double)number));
			
		/**
		 * calculate sx
		 */
		double d=0 ;
		double a = getSum(x)/(double)number;
		for(int i = 0 ;i<number;i++){
			try{
				double tmp =Double.parseDouble(x[i].getText());
				d+=(tmp-a)*(tmp-a);
			}
			catch(Exception e ){}			
		}
		sx.setText(nf2.format(Math.sqrt(d/((double)(number)*(double)(number-1)))));
		
		
	}
	
	
	/**
	 * action for buttons
	 */
	public void actionPerformed(ActionEvent ae){
		Object src = ae.getSource();
		
		/**
		 * Change the setting
		 */
		if(src==setNum){
			try{
				int n = number;
				int a = accuracy;
				number=Integer.parseInt(numText.getText());
				if(number<1||number>200){
					JOptionPane.showMessageDialog(null, "Illegal number!", "Error", JOptionPane.ERROR_MESSAGE);
					number=n;
				}
				accuracy = Integer.parseInt(accText.getText());
				if(accuracy<1||accuracy>15){
					JOptionPane.showMessageDialog(null, "Illegal accuracy!", "Error", JOptionPane.ERROR_MESSAGE);
					accuracy=a;
					
				}
				
				nf.setMaximumFractionDigits(accuracy);
			//	nf.setMinimumFractionDigits(accuracy);
				nf2.setMaximumFractionDigits(accuracy*2);
				if(number!=n){
					CalFrame c = new CalFrame();
					frame.dispose();
				}
				
			}
			catch(NumberFormatException nfe){
				JOptionPane.showMessageDialog(null, "Check the input!", "Error", JOptionPane.ERROR_MESSAGE);
				numText.setText(8+"");
				accText.setText(5+"");
			}
						
		}
		
		/**
		 * Calculate
		 */
		if(src==calButton) calculate();
		
		
		/**
		 * export the table
		 */
		if(src==exportResult) {OutputField f = new OutputField(this);}
	}

}
