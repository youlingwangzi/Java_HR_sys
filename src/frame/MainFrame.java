package frame;

/**
 * 1、菜单组件
    	JMenuBar	菜单条组件	树干
    	JMenu		菜单组件	树枝
    	JMenuItem	菜单项组件	树叶
	2、二级菜单制作
    	JMenu里面可以嵌套JMenu
	3、工具条组件
    	JToolBar	容器类组件
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.html.ImageView;

import com.sun.awt.AWTUtilities;

import dao.DeptDao;
import dao.JobDao;
import dao.StaffDao;
import entity.Dept;
import entity.Job;
import entity.staff;
public class MainFrame extends JFrame{
	//文件组定义组件
	JMenuBar jmb;//菜单条组件
	JMenu menu1, menu2, menu5;//主菜单：文件、编辑、格式、查看、帮助
	JMenuItem item7;//退出
	JMenuItem insertJItem, edItem, deletItem, freshItem;
	JMenuItem file,project;
	
	//帮助组定义组件
	JMenuItem hitem1,hitem2;
	JTextArea jta;
	
	//工具条
	JButton jb1,jb2,jb3,jb4,jb5;
	
	private JTable tab;
	private DefaultTableModel dtm;
	private List staffList;
	private Object[][]rowData;
	private List<Dept> deptList;
	private List<Job> jobList;
	private JLabel titlePicture;
	private GridBagLayout layout;
	FrameListener frameListener;
	JScrollPane jsp;
	
	//构造函数
	public MainFrame(){
		//构建组件
		//工具条
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/images/icon.png"));
		this.setIconImage(imageIcon.getImage());
		//AWTUtilities.setWindowOpaque(this, false);
		this.setUndecorated(true);
		this.setLayout(layout = new GridBagLayout());

		frameListener = new FrameListener(this);
		addMouseListener(frameListener);
		addMouseMotionListener(frameListener);  
		
		init();
		addControls();
		setLayout();
		addListener();
		
		//窗体设置
		this.setTitle("信息学院学生党支部人事管理系统");
		this.setSize(700, 600);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		

		}
		public int setRowData(){
			int row;
			StaffDao dao=new StaffDao();
			staffList=dao.getList();
			row=staffList.size();
			rowData=new Object[row][6];
			for(int i=0;i<row;i++){
				rowData[i][0]=i+1;
				staff s=(staff)staffList.get(i);
				rowData[i][1]=s.getStaffId();
				rowData[i][2]=s.getStaffName();
				rowData[i][3]=s.getDept().getDeptName();
				rowData[i][4]=s.getJob().getJobName();
				rowData[i][5]=s.getDetail();
			}
			return row;
		}
		public void init(){
			titlePicture = new JLabel();
			jb1=new JButton("添加员工");
			jb2=new JButton("删除员工");
			jb3=new JButton("编辑员工");
			jb4=new JButton("刷新列表");
			jb5=new JButton(" 退    出 ");
			
			jmb=new JMenuBar();
			//主菜单
			menu1=new JMenu("系统(S)");
			menu1.setMnemonic('S');//设置助记符
			menu2=new JMenu("员工管理(M)");
			menu2.setMnemonic('M');
			menu5=new JMenu("帮助(H)");
			menu5.setMnemonic('H');
			
			//文件--新建--子目录
			item7=new JMenuItem("退出(X)");
			item7.setMnemonic('X');
			
			insertJItem =new JMenuItem("添加员工(I)");
			insertJItem.setMnemonic('I');
			edItem =new JMenuItem("编辑员工(E)");
			edItem.setMnemonic('E');
			deletItem =new JMenuItem("删除员工(D)");
			deletItem.setMnemonic('D');
			freshItem =new JMenuItem("刷新列表(F)");
			freshItem.setMnemonic('F');
			
			hitem1=new JMenuItem("查看帮助(H)");
			hitem1.setMnemonic('H');
			hitem2=new JMenuItem("关于本系统(A)");
			hitem2.setMnemonic('A');
		}
		
		public void setControls(){
			//将菜单项添加到菜单上
			menu1.add(item7);
			
			menu2.add(insertJItem);
			menu2.add(edItem);
			menu2.add(deletItem);
			menu2.add(freshItem);
			
			menu5.add(hitem1);
			menu5.addSeparator();
			menu5.add(hitem2);
			
			//将菜单添加到菜单条上
			jmb.add(menu1);
			jmb.add(menu2);
			jmb.add(menu5);
			
			titlePicture.setIcon(new ImageIcon(getClass().getResource("/images/title2.png")));
			titlePicture.setMaximumSize(getSize());
			dtm=new DefaultTableModel(null,new String[]{"序号","员工编号","姓名","部门","职务","备注"});
			StaffDao dao=new StaffDao();
			staffList=dao.getList();
			for(int i=0;i<staffList.size();i++){
				staff s=(staff)staffList.get(i);
				dtm.addRow(new Object[]{i+1,s.getStaffId(),s.getStaffName(),s.getDept().getDeptName(),s.getJob().getJobName(),s.getDetail()});
			}
			tab = new JTable(dtm);
			tab.setRowHeight(25);
			tab.setBackground(new Color(240,240,240));
			TableColumn tableColumn0 = tab.getColumnModel().getColumn(0);
			TableColumn tableColumn1 = tab.getColumnModel().getColumn(1);
			TableColumn tableColumn5 = tab.getColumnModel().getColumn(5);
			tableColumn0.setPreferredWidth(7);
			tableColumn1.setPreferredWidth(15);
			tableColumn5.setPreferredWidth(160);
			jsp=new JScrollPane(tab);
			jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		}
		
		public void setLayout(){
			GridBagConstraints sBagConstraints = new GridBagConstraints();
			sBagConstraints.fill = GridBagConstraints.BOTH;
			sBagConstraints.gridwidth = 5;
			sBagConstraints.gridheight = 1;
			sBagConstraints.gridx = 0;
			sBagConstraints.gridy = 0;
			layout.setConstraints(jmb, sBagConstraints);
			sBagConstraints.gridwidth = 5;
			sBagConstraints.gridheight = 1;
			sBagConstraints.gridx = 0;
			sBagConstraints.gridy = 1;
			layout.setConstraints(titlePicture, sBagConstraints);

			sBagConstraints.gridwidth = 1;
			sBagConstraints.gridheight = 1;
			sBagConstraints.gridx = 0;
			sBagConstraints.gridy = 2;
			layout.setConstraints(jb1, sBagConstraints);
			sBagConstraints.gridwidth = 1;
			sBagConstraints.gridheight = 1;
			sBagConstraints.gridx = 1;
			sBagConstraints.gridy = 2;
			layout.setConstraints(jb2, sBagConstraints);
			sBagConstraints.gridwidth = 1;
			sBagConstraints.gridheight = 1;
			sBagConstraints.gridx = 2;
			sBagConstraints.gridy = 2;
			layout.setConstraints(jb3, sBagConstraints);
			sBagConstraints.gridwidth = 1;
			sBagConstraints.gridheight = 1;
			sBagConstraints.gridx = 3;
			sBagConstraints.gridy = 2;
			layout.setConstraints(jb4, sBagConstraints);
			sBagConstraints.gridwidth = 1;
			sBagConstraints.gridheight = 1;
			sBagConstraints.gridx = 4;
			sBagConstraints.gridy = 2;
			layout.setConstraints(jb5, sBagConstraints);
	/*		sBagConstraints.gridwidth = 1;
			sBagConstraints.gridheight = 1;
			sBagConstraints.gridx = 0;
			sBagConstraints.gridy = 2;
			layout.setConstraints(jtb, sBagConstraints);*/
			sBagConstraints.gridwidth = 5;
			sBagConstraints.gridheight = 1;
			sBagConstraints.weighty=1;
			sBagConstraints.gridx = 0;
			sBagConstraints.gridy = 3;
			layout.setConstraints(jsp, sBagConstraints);
			
		}
		
		public void addControls(){

			setControls();
			//设定布局管理器
			
			//加入组件
			this.add(jb1);
			this.add(jb2);
			this.add(jb3);
			this.add(jb4);
			this.add(jb5);
			
			//将菜单条添加到窗体上
			this.setJMenuBar(jmb);
			this.add(titlePicture);
			
			this.add(jsp);
		}
		
		public void addListener(){
			jb1.addActionListener(
					new ActionListener(){
						public void actionPerformed(ActionEvent e){
							insert info=new insert();
							info.setVisible(true);
						}
					}
				);
			jb2.addActionListener(
					new ActionListener(){
						public void actionPerformed(ActionEvent e){
						int [] sel=tab.getSelectedRows();
						if(sel.length==1){
							for(int i=0;i<sel.length;i++){
								int id=Integer.parseInt(tab.getValueAt(sel[i], 1).toString());
							
								StaffDao dao=new StaffDao();
								dao.del(id);
								MainFrame mf=new MainFrame();
								mf.setVisible(true);
								dispose();
							}
						}
						else 
							JOptionPane.showMessageDialog(null,"请选择删除对象！",
									"警告" ,JOptionPane.INFORMATION_MESSAGE);
						}
					}
				);
			jb3.addActionListener(
					new ActionListener(){
						public void actionPerformed(ActionEvent e){
							int sel=tab.getSelectedRow();
							if(sel!=-1){
								DeptDao deptdao=new DeptDao();
								deptList=deptdao.getList();
								JobDao jobdao=new JobDao();
								jobList=jobdao.getList();
								
								int id=Integer.parseInt(tab.getValueAt(sel, 1).toString());
								String name=tab.getValueAt(sel,2).toString();
								Dept dept1=new Dept();
								for(Dept dept:deptList){
									if(dept.getDeptName().equals (tab.getValueAt(sel, 3).toString())){
										dept1=dept;
										break;
									}
								}
								
								Job job1=new Job();
								for(Job job:jobList){
									if(job.getJobName().equals (tab.getValueAt(sel, 4).toString())){
										job1=job;
										break;
									}
								}
								String d=tab.getValueAt(sel,5).toString();
								staff Staff=new staff(id,name,dept1,job1,d);
								edit info=new edit(Staff);
								info.setVisible(true);
							}
							else
								JOptionPane.showMessageDialog(null,"请选择编辑对象！","警告" ,JOptionPane.INFORMATION_MESSAGE);
							
						}		
					}
				);
			jb4.addActionListener(
					new ActionListener(){
						public void actionPerformed(ActionEvent e){
							int rowCnt=dtm.getRowCount();
							int rowDate=setRowData();
							for(int i=0;i<rowCnt;i++){						
								dtm.removeRow(0);
							}
							for(int i=0;i<rowDate;i++){
								dtm.insertRow(i, rowData[i]);
							}
						}
					}
				);
			jb5.addActionListener(
					new ActionListener(){
						public void actionPerformed(ActionEvent e){
							System.exit(0);
						}
					}
				);
			item7.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO 自动生成的方法存根
					System.exit(0);
				}
			});
			
			insertJItem.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO 自动生成的方法存根
					insert info=new insert();
					info.setVisible(true);
				}
			});
			edItem.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO 自动生成的方法存根
					int sel=tab.getSelectedRow();
					if(sel!=-1){
						DeptDao deptdao=new DeptDao();
						deptList=deptdao.getList();
						JobDao jobdao=new JobDao();
						jobList=jobdao.getList();
						
						int id=Integer.parseInt(tab.getValueAt(sel, 1).toString());
						String name=tab.getValueAt(sel,2).toString();
						Dept dept1=new Dept();
						for(Dept dept:deptList){
							if(dept.getDeptName().equals (tab.getValueAt(sel, 3).toString())){
								dept1=dept;
								break;
							}
						}
						
						Job job1=new Job();
						for(Job job:jobList){
							if(job.getJobName().equals (tab.getValueAt(sel, 4).toString())){
								job1=job;
								break;
							}
						}
						String d=tab.getValueAt(sel,5).toString();
						staff Staff=new staff(id,name,dept1,job1,d);
						edit info=new edit(Staff);
						info.setVisible(true);
					}
					else
						JOptionPane.showMessageDialog(null,"请选择编辑对象！","警告" ,JOptionPane.INFORMATION_MESSAGE);
					
				}
			});
		deletItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				int [] sel=tab.getSelectedRows();
				if(sel.length==1){
					for(int i=0;i<sel.length;i++){
						int id=Integer.parseInt(tab.getValueAt(sel[i], 1).toString());
					
						StaffDao dao=new StaffDao();
						dao.del(id);
						MainFrame mf=new MainFrame();
						mf.setVisible(true);
						dispose();
					}
				}
				else 
					JOptionPane.showMessageDialog(null,"请选择删除对象！",
							"警告" ,JOptionPane.INFORMATION_MESSAGE);
				}
				
		});
			
		freshItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				int rowCnt=dtm.getRowCount();
				int rowDate=setRowData();
				for(int i=0;i<rowCnt;i++){						
					dtm.removeRow(0);
				}
				for(int i=0;i<rowDate;i++){
					dtm.insertRow(i, rowData[i]);
				}
			}
		});
			hitem1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO 自动生成的方法存根
					new Help();
				}
			});
			hitem2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO 自动生成的方法存根
					JOptionPane.showMessageDialog(null,"信息学院学生党支部人事管理系统\nV1.0\n开发者：幽灵王子",
							"关于本系统" ,JOptionPane.INFORMATION_MESSAGE);
				}
			});
		}
}

