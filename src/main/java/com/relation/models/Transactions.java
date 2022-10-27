package com.relation.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="transactions")
public class Transactions {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int tid;
	@Column
	private String date;
	@Column
	private double totalprice;
	@Column
	private String customername;
	@ManyToOne
	@JoinColumn(name="sid")
	@JsonBackReference
	private MedicalShop shop;
	public Transactions()
	{
		
	}
	
	

	public Transactions(int tid, String date, double totalprice, MedicalShop shop) {
		super();
		this.tid = tid;
		this.date = date;
		this.totalprice = totalprice;
		this.shop = shop;
	}
	
	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}
	public MedicalShop getShop() {
		return shop;
	}
	public void setShop(MedicalShop shop) {
		this.shop = shop;
	}
	
	
}
