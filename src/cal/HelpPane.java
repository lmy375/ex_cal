package cal;
import javax.swing.*;
import java.awt.*;
public class HelpPane extends JPanel{
	JTextArea help;
	public HelpPane(){
		super();
		
		help = new JTextArea();
		help.setEditable(false);
		help.setLineWrap(true);
		help.setText("\n使用说明：" +
				"\n\n" +
				"1.Linear用于计算一元线性回归系数及A类不确定度，" +
				"Average用于计算平均值及A类不确定度。" +
				"计算公式取自北航基物实验教材P19和P49.\n" +
				"2.事先设置数据组数（1~200）和计算结果精确的位数（1~15），点击“更新设置”修改。" +
				"注意对于Sum和Average值精确到设置值，平方项和乘积项为设置值的2倍。" +
				"另外当数据组数改变时会刷新窗口，导致窗口中所有信息清零。\n" +
				"3.计算过程会利用之前计算的结果，如计算回归系数b时会利用之前计算得到的x平方平均值、" +
				"y平方平均值等数据。可能因此导致精确度下降。建议计算过程中设置较大的保留位数。\n" +
				"4.小提示：输入数据时候可按Tab键切换至下一格，提升输入效率。" +
				"点击“Export Result”可将数据导出，直接复制到Excel中即可进行一步处理。\n" +
				"5.测试版，如发现问题可致信375393807@qq.com.十分感谢。"+
				"\n\n\n" +
				"Linear Calculator \n" +
				"Version: 1.00 beta\n" +
				"Copyright BUAA-SCSE-Moon. All rights reserved.\n" +
				"");

		JScrollPane scroll = new JScrollPane(help, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		setLayout(new GridLayout(1,1));
		this.add(scroll);
		
	}

}
