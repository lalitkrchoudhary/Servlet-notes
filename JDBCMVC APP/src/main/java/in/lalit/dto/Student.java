package in.lalit.dto;

import java.io.Serializable;

public class Student implements Serializable{
	private static final long serialVersion =1L;
	
	private Integer sid;
	private String sname;
	private Integer sage;
	private String sadd;
	
	
	static {
		System.out.println("Student.class is loading....");
	}


	public Integer getSid() {
		return sid;
	}


	public void setSid(Integer sid) {
		this.sid = sid;
	}


	public String getSname() {
		return sname;
	}


	public void setSname(String sname) {
		this.sname = sname;
	}


	public Integer getSage() {
		return sage;
	}


	public void setSage(Integer sage) {
		this.sage = sage;
	}


	public String getSadd() {
		return sadd;
	}


	public void setSadd(String sadd) {
		this.sadd = sadd;
	}
	
	


	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", sage=" + sage + ", sadd=" + sadd + "]";
	}


	public static long getSerialversion() {
		return serialVersion;
	}

	
}
	
	