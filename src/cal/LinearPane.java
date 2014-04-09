package cal;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.text.*;

import assi.*;

public class LinearPane extends JPanel implements ActionListener{
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
	
	public CalTextField[] y;
	public JLabel ySum;
	public JLabel yAverage;
	
	public JLabel[] xx;
	public JLabel xxSum;
	public JLabel xxAverage;
	
	public JLabel[] yy;
	public JLabel yySum;
	public JLabel yyAverage;
	
	public JLabel[] xy;
	public JLabel xySum;
	public JLabel xyAverage;
	
	public JLabel b;
	public JLabel a;
	public JLabel r;
	public JLabel ub;
	public JLabel ua;
	
	
	
	
	
	public LinearPane(CalFrame f){
		
		super();
		frame=f;
		nf = new DecimalFormat();
		nf.setGroupingUsed(false);
	 	nf.setMaximumFractionDigits(accuracy);
	//	nf.setMinimumFractionDigits(accuracy);
		nf2 = new DecimalFormat();
		nf2.setGroupingUsed(false);
	//	nf2.setMinimumFractionDigits(accuracy*2);
		nf2.setMaximumFractionDigits(accuracy*2);
		
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
		centerPane.setLayout(new GridLayout(6, number+3));
		/**
		 *5south pane
		 */
		JPanel resultPane = new JPanel();
		resultPane.setLayout(new GridLayout(2,5));
		resultPane.add(new JLabel("b="));
		b = new JLabel();
		resultPane.add(b);
		resultPane.add(new JLabel("a="));
		a = new JLabel();
		resultPane.add(a);
		resultPane.add(new JLabel("r="));
		r = new JLabel();
		resultPane.add(r);
		resultPane.add(new JLabel("u(b)="));
		ub = new JLabel();
		resultPane.add(ub);
		resultPane.add(new JLabel("u(a)="));
		ua = new JLabel();
		resultPane.add(ua);
		
		
		
		calButton = new JButton("Calculate");
		calButton.addActionListener(this);
		resultPane.add(calButton);	
		
		exportResult= new JButton("Export Result");
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
		
		/**
		 * y line
		 */
		centerPane.add(new JLabel("Y"));
		y =new CalTextField[number];
		for(int i = 0;i<number;i++){
			y[i]= new CalTextField();
			centerPane.add(y[i]);
		}
		ySum= new JLabel();
		centerPane.add(ySum);
		yAverage = new JLabel();
		centerPane.add(yAverage);
		
		/**
		 * x*x line
		 */
		centerPane.add(new JLabel("X^2"));
		xx =new JLabel[number];
		for(int i = 0;i<number;i++){
			xx[i] = new JLabel();
			centerPane.add(xx[i]);
		}
		xxSum= new JLabel();
		centerPane.add(xxSum);
		xxAverage = new JLabel();
		centerPane.add(xxAverage);
		
		/**
		 * y*y line
		 */
		centerPane.add(new JLabel("Y^2"));
		yy =new JLabel[number];
		for(int i = 0;i<number;i++){
			yy[i] = new JLabel();
			centerPane.add(yy[i]);
		}
		yySum= new JLabel();
		centerPane.add(yySum);
		yyAverage = new JLabel();
		centerPane.add(yyAverage);
		
		
		/**
		 * x*y line
		 */
		centerPane.add(new JLabel("X*Y"));
		xy =new JLabel[number];
		for(int i = 0;i<number;i++){
			xy[i] = new JLabel();
			centerPane.add(xy[i]);
		}
		xySum= new JLabel();
		centerPane.add(xySum);
		xyAverage = new JLabel();
		centerPane.add(xyAverage);
		
		
		
		
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
		 * calculate y line
		 */
		ySum.setText(nf.format(getSum(y)));
		yAverage.setText(nf.format(getSum(y)/(double)number));
		
		/**
		 * calculate x^2 line
		 */
		for(int i = 0 ;i<number;i++){
			try{
				double d= Double.parseDouble(x[i].calText());
				xx[i].setText(nf2.format(d*d));
			}
			catch(NumberFormatException nfe){
			//	JOptionPane.showMessageDialog(null, "Check the input!", "Error", JOptionPane.ERROR_MESSAGE);
			//	x[i].setText(0+"");
				xx[i].setText(0+"");
				}			
		}
		xxSum.setText(nf2.format(getSum(xx)));
		xxAverage.setText(nf2.format(getSum(xx)/(double)number));
		
		/**
		 * calculate y^2 line
		 */
		for(int i = 0 ;i<number;i++){
			try{
				double d= Double.parseDouble(y[i].calText());
				yy[i].setText(nf2.format(d*d));
			}
			catch(NumberFormatException nfe){
			//	JOptionPane.showMessageDialog(null, "Check the input!", "Error", JOptionPane.ERROR_MESSAGE);
			//	y[i].setText(0+"");
				yy[i].setText(0+"");
				}			
		}
		yySum.setText(nf2.format(getSum(yy)));
		yyAverage.setText(nf2.format(getSum(yy)/(double)number));
		
		/**
		 * calculate xy line
		 */
		for(int i = 0 ;i<number;i++){
			try{
				double dx= Double.parseDouble(x[i].getText());
				double dy= Double.parseDouble(y[i].getText());
				xy[i].setText(nf2.format(dx*dy));
			}
			catch(NumberFormatException nfe){
			//	JOptionPane.showMessageDialog(null, "Check the input!", "Error", JOptionPane.ERROR_MESSAGE);
			
				xy[i].setText(0+"");
				}			
		}
		xySum.setText(nf2.format(getSum(xy)));
		xyAverage.setText(nf2.format(getSum(xy)/(double)number));
		
		
		/**
		 * calculate b , a , r , u(b)
		 */
		double _x = Double.parseDouble(xAverage.getText());
		double _y = Double.parseDouble(yAverage.getText());
		double _xx = Double.parseDouble(xxAverage.getText());
		double _yy = Double.parseDouble(yyAverage.getText());
		double _xy = Double.parseDouble(xyAverage.getText());
		
		b.setText(nf2.format((_x*_y-_xy)/(_x*_x-_xx)));

		double _b = Double.parseDouble(b.getText());
		a.setText(nf2.format(_y-_b*_x));
		
		r.setText(nf2.format( (_xy-_x*_y)/Math.sqrt( (_xx-_x*_x)*(_yy-_y*_y)  )   )   );
		double _r= Double.parseDouble(r.getText());
		
		ub.setText(nf2.format(_b* Math.sqrt( 1.0/(double)(number-2) * (1.00/(_r*_r)-1.00) ) ) );
		
		double _ub= Double.parseDouble(ub.getText());
		ua.setText(nf2.format(_ub*Math.sqrt(_xx)));
		
		
		
		
		
		
		
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
			//	nf2.setMinimumFractionDigits(2*accuracy);
				nf2.setMaximumFractionDigits(2*accuracy);
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
