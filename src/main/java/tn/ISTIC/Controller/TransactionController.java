package tn.ISTIC.Controller;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.ISTIC.Models.Cum;
import tn.ISTIC.Models.Transaction;
import tn.ISTIC.Repository.TransacRepository;

@RestController
@RequestMapping(value = "/responsable")
public class TransactionController {
	
	
	@Autowired
	private TransacRepository transacRepo ;

	
	
	@PostMapping("/charger")
	@ResponseBody
	public List<Transaction> createuser (@RequestBody List<Transaction> transac) {
		return transacRepo.saveAll(transac);
		
	}
	
	
	
	@GetMapping("/region")
	@ResponseBody
	public List<Transaction>getall(String region , String codeuf ,@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate datedeb ,@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate datefin ){
		List<Transaction>listtransaction = transacRepo.getByregionAndDate(datedeb , datefin ,region ,codeuf );
		return listtransaction ;
	}
	@GetMapping("/region/cum")
	@ResponseBody
	public Cum getcum(String codeuf ,String region ,@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate datedeb ,@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate datefin ) {
		Cum cum = new Cum();
		cum.setSummontant(transacRepo.cum(codeuf,region, datedeb, datefin));
		cum.setSumkilometre(transacRepo.sumkilometre(codeuf,region, datedeb, datefin));
		cum.setSumquantite(transacRepo.sumquantite(codeuf,region, datedeb, datefin));
		return cum ; 
	}
	
	@GetMapping("/vehicule")
	@ResponseBody
	public List<Transaction>getallbyvehicule(String codeuf,long numvehicule ,@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate datedeb ,@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate datefin ){
		List<Transaction>listtransaction = transacRepo.getBytvehiculeAndDate(codeuf,numvehicule ,datedeb , datefin );
		return listtransaction ;
	}
	
	@GetMapping("/vehicule/cum")
	@ResponseBody
	public Cum getcum(String codeuf,long numvehicule ,@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate datedeb ,@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate datefin) {
		Cum cum = new Cum();
		cum.setSummontant(transacRepo.summontv(codeuf,numvehicule, datedeb, datefin));
		cum.setSumkilometre(transacRepo.sumkilov(codeuf,numvehicule, datedeb, datefin));
		cum.setSumquantite(transacRepo.sumquantv(codeuf,numvehicule, datedeb, datefin));
		return cum ; 
	}
	
	@GetMapping("/typecarburant")
	@ResponseBody
	public List<Transaction>getallbytypecarburant(String codeuf,String typecarburant ,@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate datedeb ,@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate datefin ){
		List<Transaction>listtransaction = transacRepo.getBytypecarburantAndDate(codeuf,typecarburant ,datedeb , datefin );
		return listtransaction ;
	}
	
	@GetMapping("/typecarburant/cum")
	@ResponseBody
	public Cum getcumm(String codeuf,String typecarburant ,@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate datedeb ,@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate datefin) {
		Cum cum = new Cum();
		cum.setSummontant(transacRepo.summontantc(codeuf,typecarburant, datedeb, datefin));
		cum.setSumkilometre(transacRepo.sumkiloc(codeuf,typecarburant, datedeb, datefin));
		cum.setSumquantite(transacRepo.sumqantc(codeuf,typecarburant, datedeb, datefin));
		return cum ; 
	}
}
