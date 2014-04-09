package assi;
import javax.swing.*;
import cal.*;

public class OutputField extends JFrame{
	JTextArea output;
	public OutputField(AveragePane a){
		super("Output");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(600,400);
		output = new JTextArea();
		output.append("No.");
		for(int i=0;i<AveragePane.number;i++){
			output.append("\t"+(i+1));			
		}
		output.append("\tSum\tAverage\n");
		output.append("x");
		for(int i =0;i<AveragePane.number;i++){
			output.append("\t"+a.x[i].calText());
		}
		output.append("\t"+a.xSum.getText());
		output.append("\t"+a.xAverage.getText());
		
		output.append("\n");
		output.append("\n");
		
		output.append("ƽ��ֵ��׼ƫ�A�಻ȷ���ȣ�s(x)= ");
		output.append(a.sx.getText());	
		
		
		JScrollPane scroll = new JScrollPane(output, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		setContentPane(scroll);
		setVisible(true);
	}
	
	
	
	public OutputField(LinearPane a){
		super("Output");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(600,400);
		output = new JTextArea();
		/**
		 * title line
		 */
		output.append("No.");
		for(int i=0;i<AveragePane.number;i++){
			output.append("\t"+(i+1));			
		}
		output.append("\tSum\tAverage\n");
		
		/**
		 * x line
		 */
		output.append("x");
		
		for(int i =0;i<AveragePane.number;i++){
			output.append("\t"+a.x[i].calText());
		}
		output.append("\t"+a.xSum.getText());
		output.append("\t"+a.xAverage.getText());
		
		/**
		 * y line
		 */
		output.append("\ny");
		for(int i =0;i<AveragePane.number;i++){
			output.append("\t"+a.y[i].calText());
		}
		output.append("\t"+a.ySum.getText());
		output.append("\t"+a.yAverage.getText());
		
		/**
		 * x^2 line
		 */
		output.append("\nx^2");
		for(int i =0;i<AveragePane.number;i++){
			output.append("\t"+a.xx[i].getText());
		}
		output.append("\t"+a.xxSum.getText());
		output.append("\t"+a.xxAverage.getText());
		
		/**
		 * y^2 line
		 */
		output.append("\ny^2");
		for(int i =0;i<AveragePane.number;i++){
			output.append("\t"+a.yy[i].getText());
		}
		output.append("\t"+a.yySum.getText());
		output.append("\t"+a.yyAverage.getText());
		
		/**
		 * xy line
		 */
		output.append("\nx*y");
		for(int i =0;i<AveragePane.number;i++){
			output.append("\t"+a.xy[i].getText());
		}
		output.append("\t"+a.xySum.getText());
		output.append("\t"+a.xyAverage.getText());
		
		output.append("\n");
		output.append("\n");
		output.append("�ع鷽��ϵ�� b= "+a.b.getText()+"\n");
		output.append("�ع鷽�̳����� a= "+a.a.getText()+"\n");
		output.append("�ع鷽�̱��ʽ  y = a + bx = "+a.a.getText()+"+ "+a.b.getText()+"x\n");
		output.append("�ع�ϵ��  r = "+a.r.getText()+"\n");
		output.append("A�಻ȷ���� u(b)= "+a.ub.getText()+"\t");
		output.append("u(a)= "+a.ua.getText());
				
		
		
		JScrollPane scroll = new JScrollPane(output, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		setContentPane(scroll);
		setVisible(true);
	}
}
