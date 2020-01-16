package com.woniuxy.entitys;

public class District {
	private int did;
	private String dname;
	private int pid;
	private int cid;
	public District() {
		super();
		// TODO Auto-generated constructor stub
	}
	public District(int did, String dname, int pid, int cid) {
		super();
		this.did = did;
		this.dname = dname;
		this.pid = pid;
		this.cid = cid;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	@Override
	public String toString() {
		return "District [did=" + did + ", dname=" + dname + ", pid=" + pid + ", cid=" + cid + "]";
	}
	
}
