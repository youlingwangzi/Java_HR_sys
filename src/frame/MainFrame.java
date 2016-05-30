package frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.DeptDao;
import dao.JobDao;
import dao.StaffDao;
import entity.Dept;
import entity.Job;
import entity.staff;

@SuppressWarnings("serial")
public class MainFrame extends JFrame{
	private JTable tab;
	private JScrollPane sp;
	private DefaultTableModel dtm;
	private JButton btnAdd1;
	private JButton btnAdd2;
	private JButton btnAdd3;
	private JButton btnAdd4;
	private JButton btnAdd5;
	private List staffList;
	private List<Dept> deptList;
	private List<Job> jobList;
	private Object[][]rowData;
	
	public MainFrame(){
		this.setTitle("人事管理系统");
		this.setBounds(100, 100, 800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setLayout(null);
		
		StaffDao dao=new StaffDao();
		staffList=dao.getList();
		
		dtm=new DefaultTableModel(null,new String[]{"序号","员工编号","姓名","部门","职务","备注"});
		for(int i=0;i<staffList.size();i++){
			staff s=(staff)staffList.get(i);
			dtm.addRow(new Object[]{i+1,s.getStaffId(),s.getStaffName(),s.getDept().getDeptName(),s.getJob().getJobName(),s.getDetail()});
		}
		
		tab=new JTable(dtm);
		sp=new JScrollPane(tab);
		sp.setBounds(45, 30, 550, 500);
		this.add(sp);
		
		btnAdd1=new JButton("添加员工");
		btnAdd1.setBounds(650, 100, 100, 30);
		this.add(btnAdd1);
		btnAdd2=new JButton("删除员工");
		btnAdd2.setBounds(650, 150, 100, 30);
		this.add(btnAdd2);
		btnAdd3=new JButton("编辑员工");
		btnAdd3.setBounds(650, 200, 100, 30);
		this.add(btnAdd3);
		btnAdd4=new JButton("刷新");
		btnAdd4.setBounds(650, 250, 100, 30);
		this.add(btnAdd4);
		btnAdd5=new JButton("退出");
		btnAdd5.setBounds(650, 300, 100, 30);
		this.add(btnAdd5);
		btnAdd1.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						insert info=new insert();
						info.setVisible(true);
					}
				}
			);
		btnAdd2.addActionListener(
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
						JOptionPane.showMessageDialog(null,"请选择删除对象！","警告" ,JOptionPane.INFORMATION_MESSAGE);
						
					}
				}
			);
		btnAdd3.addActionListener(
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
		btnAdd4.addActionListener(
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
		btnAdd5.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						System.exit(0);
					}
				}
			);
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
}
	
	
