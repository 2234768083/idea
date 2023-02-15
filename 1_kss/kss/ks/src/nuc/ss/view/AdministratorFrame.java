/**
 * @Title Administrator.java
 * @Author 2113042702许馨月
 * @Discription
 * @Date 2022年12月27日
 */
package nuc.ss.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;




@SuppressWarnings({ "serial", "unused" })
public class AdministratorFrame extends JFrame{

	JButton b_car, b_cost, b_cord, b_driver;
	
	protected String type;
	public AdministratorFrame(){
		setTitle("管理员");
		setSize(450, 260);
		setLocation(700, 200);
		init();
		setVisible(true);
	}
	
	void init() {
		b_car = new JButton("车辆管理页面");
		b_cost = new JButton("物流车队费用管理");
		b_cord = new JButton("油卡");
		b_driver = new JButton("司机管理页面");
		
		b_car.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// 跳转车辆管理界面
				new CarFrame();
			}
		});
		b_cost.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// 跳转物流车队费用管理
				new CostFrame();
				
			}
		});
		b_cord.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// 跳转油卡界面
				new OilCardFrame();
			}
		});
		b_driver.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// 跳转司机管理界面
				new DriverFrame();
			}
		});
		
		
		this.setLayout(null);//自定义布局
		
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(2, 2, 5, 5));
		
		p.add(b_car);
		p.add(b_cost);
		
		p.add(b_cord);
		p.add(b_driver);
		
		
		p.setBounds(5, 5, 375, 185);
		
		this.add(p);
	}

	/**
	 * 
	 */
	protected void showMessage() {
		// TODO Auto-generated method stub
		
	}
}
