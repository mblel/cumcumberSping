package model;

import java.io.Serializable;
import java.util.Date;


public class Adresse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String adr;
	String pays;
	String designation;
	Date dateEffet;

	public Adresse(String adr, String pays, String designation, Date dateEffet) {
		super();
		this.adr = adr;
		this.pays = pays;
		this.designation = designation;
		this.dateEffet = dateEffet;
	}

	public String getAdr() {
		return adr;
		
	}

	public void setAdr(String adr) {
		this.adr = adr;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public Date getDateEffet() {
		return dateEffet;
	}

	public void setDateEffet(Date dateEffet) {
		this.dateEffet = dateEffet;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

}
