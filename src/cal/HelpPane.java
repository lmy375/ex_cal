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
		help.setText("\nʹ��˵����" +
				"\n\n" +
				"1.Linear���ڼ���һԪ���Իع�ϵ����A�಻ȷ���ȣ�" +
				"Average���ڼ���ƽ��ֵ��A�಻ȷ���ȡ�" +
				"���㹫ʽȡ�Ա�������ʵ��̲�P19��P49.\n" +
				"2.������������������1~200���ͼ�������ȷ��λ����1~15����������������á��޸ġ�" +
				"ע�����Sum��Averageֵ��ȷ������ֵ��ƽ����ͳ˻���Ϊ����ֵ��2����" +
				"���⵱���������ı�ʱ��ˢ�´��ڣ����´�����������Ϣ���㡣\n" +
				"3.������̻�����֮ǰ����Ľ���������ع�ϵ��bʱ������֮ǰ����õ���xƽ��ƽ��ֵ��" +
				"yƽ��ƽ��ֵ�����ݡ�������˵��¾�ȷ���½������������������ýϴ�ı���λ����\n" +
				"4.С��ʾ����������ʱ��ɰ�Tab���л�����һ����������Ч�ʡ�" +
				"�����Export Result���ɽ����ݵ�����ֱ�Ӹ��Ƶ�Excel�м��ɽ���һ������\n" +
				"5.���԰棬�緢�����������375393807@qq.com.ʮ�ָ�л��"+
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
