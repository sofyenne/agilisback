package tn.ISTIC.Models;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;


public class Cum {
	
	
	private float summontant ;
	private float sumquantite ;
	private float sumkilometre ;
	
	public Cum() {};
	public Cum(float summontant, float sumquantite, float sumkilometre) {
		super();
		this.summontant = summontant;
		this.sumquantite = sumquantite;
		this.sumkilometre = sumkilometre;
	}
	public float getSummontant() {
		return summontant;
	}
	public void setSummontant(float summontant) {
		this.summontant = summontant;
	}
	public float getSumquantite() {
		return sumquantite;
	}
	public void setSumquantite(float sumquantite) {
		this.sumquantite = sumquantite;
	}
	public float getSumkilometre() {
		return sumkilometre;
	}
	public void setSumkilometre(float sumkilometre) {
		this.sumkilometre = sumkilometre;
	}
	
	

}
