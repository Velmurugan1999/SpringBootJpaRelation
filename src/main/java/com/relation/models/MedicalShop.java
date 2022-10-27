package com.relation.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="medicalshop")
public class MedicalShop {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int shopid;
	@Column
	private String shopname;
	@Column
	private String location;
	@OneToMany(mappedBy="shop",cascade = CascadeType.REMOVE)
	private List<Transactions> transactions;
	public MedicalShop() {
		
	}
	
	public MedicalShop(int shopid, String shopname, String location, List<Transactions> transactions) {
		super();
		this.shopid = shopid;
		this.shopname = shopname;
		this.location = location;
		this.transactions = transactions;
	}
	public int getShopid() {
		return shopid;
	}
	public void setShopid(int shopid) {
		this.shopid = shopid;
	}
	public String getShopname() {
		return shopname;
	}
	public void setShopname(String shopname) {
		this.shopname = shopname;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public List<Transactions> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transactions> transactions) {
		this.transactions = transactions;
	}
	
}
