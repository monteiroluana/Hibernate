package br.com.tereos.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;


public class Kriging {

	
	private int id;
	private Date krigingTs;
	private Date init;
	private Date end;
	private String[] dates;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getKrigingTs() {
		return krigingTs;
	}
	public void setKrigingTs(Date krigingTs) {
		this.krigingTs = krigingTs;
	}
	public Date getInit() {
		return init;
	}
	public void setInit(Date init) {
		this.init = init;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public String[] getDates() {
		return dates;
	}
	public void setDates(String[] dates) {
		this.dates = dates;
	}	
}
