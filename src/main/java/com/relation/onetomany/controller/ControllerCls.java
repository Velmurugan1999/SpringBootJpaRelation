package com.relation.onetomany.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.relation.models.MedicalShop;
import com.relation.models.Transactions;
import com.relation.onetomany.service.MedicalShopService;

@RestController
@RequestMapping(path="/medicalshop")
public class ControllerCls {
	@Autowired
	MedicalShopService medicalShopService;
	
	@GetMapping("/allshop")
	public List<MedicalShop> getallMedicalShop(){
		return medicalShopService.getAllDetails();
	}
	
	@GetMapping("/shopdetails/{sid}")
	public MedicalShop getShopById(@PathVariable int sid)
	{
		return medicalShopService.getDetailsByShopId(sid);
	}
	
	@GetMapping("/transactions/{sid}")
	public List<Transactions> getTransactionBySid(@PathVariable int sid)
	{
		return medicalShopService.getTransactionsByShopId(sid);
	}
	
	@GetMapping("/alltransactions")
	public List<Transactions> getAllTransactions()
	{
		return medicalShopService.getAllTransactions();
	}
	
	@PostMapping("/inserttransactions/{sid}")
	public Transactions insertTransaction(@PathVariable int sid,@RequestBody Transactions trans)
	{
		return medicalShopService.insertTransaction(trans,sid);
	}
	
	@PostMapping("/insertshop")
	public MedicalShop insertShop(@RequestBody MedicalShop shop)
	{
		return medicalShopService.insertMedicalShop(shop);
	}
	
	@DeleteMapping("/delete/{sid}")
	public MedicalShop deleteShop(@PathVariable int sid)
	{
		return medicalShopService.deleteShop(sid);
	}
}
