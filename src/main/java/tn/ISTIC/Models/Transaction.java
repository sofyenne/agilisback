package tn.ISTIC.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

import java.time.LocalDate;
import java.time.LocalDateTime;




@Entity

public class Transaction {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id ; 
	@JsonFormat(pattern="yyyy-MM-dd" ,shape=JsonFormat.Shape.STRING)
	private LocalDate date ;
	private String code_uf ; 
	private long montant ; 
	private long quantite ;
	private long kilometrage ;
	private String region ; 
	private long numvehicule ; 
	private String marque ; 
	private String typecarburant ;
	private long numtransaction ;

	
	
     public Transaction() {}



	public Transaction(long id, LocalDate date, String code_uf, long montant, long quantite, long kilometrage,
			String region, long numvehicule, String marque, String typecarburant, long numtransaction) {
		super();
		Id = id;
		this.date = date;
		this.code_uf = code_uf;
		this.montant = montant;
		this.quantite = quantite;
		this.kilometrage = kilometrage;
		this.region = region;
		this.numvehicule = numvehicule;
		this.marque = marque;
		this.typecarburant = typecarburant;
		this.numtransaction = numtransaction;
	}



	public long getId() {
		return Id;
	}



	public void setId(long id) {
		Id = id;
	}



	public LocalDate getDate() {
		return date;
	}



	public void setDate(LocalDate date) {
		this.date = date;
	}



	public String getCode_uf() {
		return code_uf;
	}



	public void setCode_uf(String code_uf) {
		this.code_uf = code_uf;
	}



	public long getMontant() {
		return montant;
	}



	public void setMontant(long montant) {
		this.montant = montant;
	}



	public long getQuantite() {
		return quantite;
	}



	public void setQuantite(long quantite) {
		this.quantite = quantite;
	}



	public long getKilometrage() {
		return kilometrage;
	}



	public void setKilometrage(long kilometrage) {
		this.kilometrage = kilometrage;
	}



	public String getRegion() {
		return region;
	}



	public void setRegion(String region) {
		this.region = region;
	}



	public long getNumvehicule() {
		return numvehicule;
	}



	public void setNumvehicule(long numvehicule) {
		this.numvehicule = numvehicule;
	}



	public String getMarque() {
		return marque;
	}



	public void setMarque(String marque) {
		this.marque = marque;
	}



	public String getTypecarburant() {
		return typecarburant;
	}



	public void setTypecarburant(String typecarburant) {
		this.typecarburant = typecarburant;
	}



	public long getNumtransaction() {
		return numtransaction;
	}



	public void setNumtransaction(long numtransaction) {
		this.numtransaction = numtransaction;
	}


	

	
	
	
}
