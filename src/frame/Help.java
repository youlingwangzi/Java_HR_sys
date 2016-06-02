package frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class Help extends JFrame{

	//设定组件
	//主页面北部
	JLabel jl1;//标签 
	
	//主页面南部
	JButton jb1,jb2,jb3;//按钮
	JPanel jp1;//面板
	
	//主页面中部
	JTabbedPane jtp;//选项卡窗格
	JPanel jp2,jp3,jp4;//面板
	
	JLabel jl2,jl3,jl4,jl5;//标签
	JTextField jtf;//文本框
	JPasswordField jpf;//密码框
	JButton jb4;//按钮
	JCheckBox jcb1,jcb2;//复选框
	
	//JPanel3组件
	JLabel jl6,jl7;//标签
	JTextField jtf1;
	JPasswordField jpf1;
	
	//JPanel4组件
	JLabel jl8,jl9;//标签
	JTextField jtf2;
	JPasswordField jpf2;
	JLabel insertJLabel, insertTextJLabel;
	JLabel editJLabel, editTextLabel;
	
	//构造函数
	public Help(){
		//创建组件
		//创建JFrame北部JLabel1组件
		jl1=new JLabel(new ImageIcon(getClass().getResource("/images/help_title.png")));

		//创建JFrame中部JPanel2组件
		
		jtp=new JTabbedPane();//选项卡窗格
		jp2=new JPanel();
		jp3=new JPanel();
		
		//创建JFrame南部JPanel1组件
		jp1=new JPanel();
		jb1=new JButton("关       闭");
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				dispose();
			}
		});
		
		//设置布局管理器
		jp2.setLayout(new BorderLayout());
		jp3.setLayout(new BorderLayout());
		
		//
		insertJLabel = new JLabel(new ImageIcon(getClass().getResource("/images/insert.png")));
		insertTextJLabel = new JLabel("<HTML><h2>要新建员工</h2><p></p><p>单击菜单栏：管理员工->新建员工</p><p>或者直接在工具栏中点击新建员工按钮</p></HTML>");
		insertJLabel.setBorder(BorderFactory.createLineBorder(Color.blue, 5));
		
		editTextLabel = new JLabel("<HTML><h2>要编辑员工</h2><p>请先在列表中选中要编辑的员工</p><p>然后单击菜单栏：管理员工->编辑员工</p><p>或者直接在工具栏中点击编辑员工按钮</p></HTML>");
		
		//加入组件
		//将组件添加到JPanel2中
		jp2.add(insertTextJLabel,BorderLayout.CENTER);
		
		//将组件添加到JPanel3中
		jp3.add(editTextLabel,BorderLayout.CENTER);
		
		//添加到JPanel1中
		jp1.add(jb1);
		
		//将面板添加到选项卡窗格上
		jtp.add("添加人员",jp2);//第一个参数代表选项卡名称，第二个参数代表对应的面板
		jtp.add("编辑人员",jp3);
		
		//将JLabel1添加到Frame北部
		this.add(jl1,BorderLayout.NORTH);
		
		//将JPanle2添加到Frame中部
		this.add(jtp,BorderLayout.CENTER);
		
		//将JPanel1添加到Frame南部
		this.add(jp1,BorderLayout.SOUTH);
		
		//窗体设置
		this.setTitle("帮助");
		//ImageIcon icon=new ImageIcon("图片路径");
		//this.setIconImage(icon.getImage());
		this.setIconImage((new ImageIcon("images/icon.png")).getImage());
		this.setBounds(500,200,360,300);
		this.setVisible(true);
	}
}
