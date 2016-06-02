package frame;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.DeptDao;
import dao.JobDao;
import dao.StaffDao;
import entity.Dept;
import entity.Job;
import entity.staff;

@SuppressWarnings("serial")
public class insert extends JFrame{
	private JButton btnAdd;
	private JButton btnAdd1;
	private JTextField txt;
	private JScrollPane scrollpane;
	private JTextArea txt1;
	private JLabel lab;
	private JComboBox comb;
	private JComboBox comb1;
	private List<Dept> deptList;
	private List<Job> jobList;

	private JLabel titlePicture;
	private String[] item={"--请选择--"}; 
	
	public insert(){
		ImageIcon imageIcon = new ImageIcon(getClass().getResource("/images/icon.png"));
		this.setIconImage(imageIcon.getImage());
		//this.setUndecorated(true);

		FrameListener frameListener = new FrameListener(this);
		addMouseListener(frameListener);
		addMouseMotionListener(frameListener);  
		
		this.setTitle("添加新员工");
		this.setBounds(500, 200, 310, 400);
		
		titlePicture = new JLabel();
		titlePicture.setIcon(new ImageIcon(getClass().getResource("/images/insert_title.png")));
		titlePicture.setMaximumSize(getSize());
		titlePicture.setBounds(0, 0, 300, 40);
		this.add(titlePicture);
		
		this.setLayout(null);
		lab=new JLabel("姓     名: ");
		lab.setBounds(20, 45, 100, 50);
		this.add(lab);
		txt=new JTextField();
		txt.setBounds(90, 55, 190, 30);
		this.add(txt);
		
		
		lab=new JLabel("部     门: ");
		lab.setBounds(20, 100, 100, 30);
		this.add(lab);
		comb=new JComboBox(item);
		DeptDao deptDao=new DeptDao();
		deptList=deptDao.getList();
		for(Dept dept:deptList){
			comb.addItem(dept.getDeptName());
		}
		comb.setBounds(90, 100, 190, 30);
		this.add(comb);
	
		lab=new JLabel("职     务: ");
		lab.setBounds(20, 150, 100, 30);
		this.add(lab);
		comb1=new JComboBox(item);
		JobDao jobDao=new JobDao();
		jobList=jobDao.getList();
		for(Job job:jobList){
			comb1.addItem(job.getJobName());
		}
		comb1.setBounds(90, 150, 190, 30);
		this.add(comb1);
		
		lab=new JLabel("备     注: ");
		lab.setBounds(20, 200, 100, 30);
		this.add(lab);
		txt1=new JTextArea();
		txt1.setLineWrap(true);
		scrollpane=new JScrollPane(txt1);
		scrollpane.setBounds(90, 200, 190, 100);
		this.add(scrollpane);
		
		
		btnAdd=new JButton("保存");
		btnAdd.setBounds(30, 320, 100, 30);
		this.add(btnAdd);
		btnAdd.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						StaffDao dao=new StaffDao();
					
						Dept dept1=new Dept();
						for(Dept dept:deptList){
							if(dept.getDeptName().equals (comb.getSelectedItem().toString())){
								dept1=dept;
								break;
							
							}
						}
						Job job1=new Job();
						for(Job job:jobList){
							if(job.getJobName().equals (comb1.getSelectedItem().toString())){
								job1=job;
								break;
							}
						}
						if((txt.getText().isEmpty())||(comb.getSelectedItem().toString().equals("--请选择--"))||(comb1.getSelectedItem().toString().equals("--请选择--")))
							JOptionPane.showMessageDialog(null,"姓名、部门或职位不能为空！","警告" ,JOptionPane.INFORMATION_MESSAGE);
						else{
							staff s=new staff(txt.getText(),dept1,job1,txt1.getText());
							dao.insert(s);
							dispose();
							
						}
						//mainFrame = new MainFrame();
					}
				}
			);
		
		
		btnAdd1=new JButton("退出");
		btnAdd1.setBounds(160,320, 100, 30);
		this.add(btnAdd1);
		btnAdd1.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						//setVisible(false);
						dispose();
					}
				}
			);
		
	}

}
