package entity;

public class staff {
	private Integer staffId;
	private  String staffName;
	private Dept dept;
	private Job job;
	//private Integer dept_id;
	//private Integer job_id;
	private String detail;

	public staff() {
		super();
		
	}
	public staff( String staffName, Dept dept, Job job,String detail) {
		super();
		this.staffName = staffName;
		this.dept = dept;
		this.job = job;
		this.detail = detail;
	}
	public staff(Integer staffId, String staffName, Dept dept, Job job,
			String detail) {
		super();
		this.staffId = staffId;
		this.staffName = staffName;
		this.dept = dept;
		this.job = job;
		this.detail = detail;
	}
	public Integer getStaffId() {
		return staffId;
	}
	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	

}
