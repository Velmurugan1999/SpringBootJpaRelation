package com.relation.onetomany.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relation.models.MedicalShop;
import com.relation.models.Transactions;
import com.relation.onetomany.dao.MedicalShopDao;
import com.relation.onetomany.dao.TransactionsDao;

@Service
public class MedicalShopService {
	@Autowired
	MedicalShopDao mdao;
	@Autowired
	TransactionsDao tdao;
	
	public List<MedicalShop> getAllDetails(){
		return mdao.findAll();
	}
	
	public MedicalShop getDetailsByShopId(int sid)
	{
		return mdao.findById(sid).get();
	}
	
	public List<Transactions> getAllTransactions(){
		return tdao.findAll();
	}
	
	public List<Transactions> getTransactionsByShopId(int sid)
	{
		return tdao.findTransactionsByShopId(sid);
	}
	
	public MedicalShop insertMedicalShop(MedicalShop shop)
	{
		return mdao.save(shop);
	}
	
	public Transactions insertTransaction(Transactions trans,int sid)
	{
		MedicalShop shop=mdao.findById(sid).get();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy");
		String date=simpleDateFormat.format(new Date());
		trans.setDate(date);
		trans.setShop(shop);
		return tdao.save(trans);
	}
	
	public MedicalShop deleteShop(int sid)
	{
		try {
			MedicalShop shop=mdao.findById(sid).get();
			mdao.delete(shop);
			return shop;
		}catch (Exception e) {
			System.out.println("No shop to delete");
			return null;
		}
	}
}
