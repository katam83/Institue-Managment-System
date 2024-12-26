package LoginPac;

public class Student {
	private String Name;
	private int Age;
	private long Mobile;
	private String Address;
	private String Email;
	private String Course;
	private int sid;
	
	public Student(int sid,String Name, int Age, long Mobile, String Address, String Email, String Course) {
		super();
		this.Name = Name;
		this.Age = Age;
		this.Mobile = Mobile;
		this.Address = Address;
		this.Email = Email;
		this.Course = Course;
		this.sid = sid;
	}
	public Student(long mobile) {
		super();
		this.Mobile = mobile;
	}
	
	public Student(String email) {
		super();
		this.Email = email;
	}
	public Student(String name, int age, long mobile, String address, String email, String course) {
		super();
		this.Name = name;
		this.Age = age;
		this.Mobile = mobile;
		this.Address = address;
		this.Email = email;
		this.Course = course;
	 }
	
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public long getMobile() {
		return Mobile;
	}
	public void setMobile(long mobile) {
		Mobile = mobile;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getCourse() {
		return Course;
	}
	public void setCourse(String course) {
		Course = course;
	}
	
	
	

}
