package chap14;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Calculator extends JFrame{
	
	JLabel l_num1,l_op,l_num2,l_result;
	JTextField t_num1,t_op,t_num2,t_result;
	JButton b_cal,b_reset;
	
	public Calculator() {
		// TODO Auto-generated constructor stub
		this.setTitle("计算器");;
		this.setSize(300, 250);
		this.setLocation(50, 50);
		init();
		this.setVisible(true);
	}
	public void init(){
		this.setLayout(new GridLayout(5,2,5,5));
		l_num1 = new JLabel("操作数1",JLabel.CENTER);
		l_op = new JLabel("运 算 符",JLabel.CENTER);
		l_num2 = new JLabel("操作数2",JLabel.CENTER);
		l_result = new JLabel("结    果",JLabel.CENTER);
		t_num1 = new JTextField();
		t_op = new JTextField();
		t_num2 = new JTextField();
		t_result = new JTextField();
		JButton b_cal = new JButton("计算");
		b_cal.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cal();
			}
			
		});
		b_reset = new JButton("重置");
		b_reset.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				t_num1.setText("");
				t_op.setText("");
				t_num2.setText("");
				t_result.setText("");
			}
			
		});
		this.add(l_num1);
		this.add(t_num1);
		this.add(l_op);
		this.add(t_op);
		this.add(l_num2);
		this.add(t_num2);
		this.add(l_result);
		this.add(t_result);
		this.add(b_cal);
		this.add(b_reset);
	}
	public void cal(){
		float num1 = Float.parseFloat(t_num1.getText());
		char op = t_op.getText().charAt(0);
		float num2 = Float.parseFloat(t_num2.getText());
		
		switch(op) {
		   case '+': t_result.setText(""+(num1+num2));break;
		   case '-': t_result.setText(""+(num1-num2));break;
		   case '*': t_result.setText(""+(num1*num2));break;
		   case '/': t_result.setText(""+(num1/num2));break;
		   default: JOptionPane.showMessageDialog(this,"您输入了非法的运算符","警告对话框",JOptionPane.WARNING_MESSAGE);
		   			t_op.setText("");
		}
	}
	
}
