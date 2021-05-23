package tn.ISTIC.Repository;



import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;

import tn.ISTIC.Models.Transaction;

public interface TransacRepository extends JpaRepository<Transaction , Integer>{

	@Query(value= "SELECT *  FROM transaction t WHERE t.Region = :region and t.date>= :datedeb  and t.date<= :datefin and t.code_uf=:codeuf" , nativeQuery = true) 
	List<Transaction> getByregionAndDate(@Param(value="datedeb") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate datedeb,@Param(value="datefin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate datefin,@Param(value="region")String region ,@Param(value="codeuf")String codeuf);
	
	@Query(value="SELECT SUM(t.montant)  From transaction t WHERE t.Region = :region and t.date>= :datedeb  and t.date<= :datefin and t.code_uf=:codeuf", nativeQuery = true)
	float cum(@Param(value="codeuf")String codeuf,@Param(value="region")String region ,@Param(value="datedeb") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate datedeb,@Param(value="datefin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate datefin) ;
	
	@Query(value="SELECT SUM(t.quantite)  From transaction t WHERE t.Region = :region and t.date>= :datedeb  and t.date<= :datefin and t.code_uf=:codeuf", nativeQuery = true)
	float sumquantite(@Param(value="codeuf")String codeuf ,@Param(value="region")String region ,@Param(value="datedeb") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate datedeb,@Param(value="datefin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate datefin) ;
	
	@Query(value="SELECT SUM(t.kilometrage)  From transaction t WHERE t.Region = :region and t.date>= :datedeb  and t.date<= :datefin and t.code_uf=:codeuf", nativeQuery = true)
	float sumkilometre(@Param(value="codeuf")String codeuf ,@Param(value="region")String region ,@Param(value="datedeb") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate datedeb,@Param(value="datefin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate datefin) ;

	
	
	
	//transaction by type carburan 
	@Query(value= "SELECT *  FROM transaction t WHERE t.typecarburant = :typecarburant and t.date>= :datedeb  and t.date<= :datefin and t.code_uf=:codeuf" , nativeQuery = true) 
	List<Transaction> getBytypecarburantAndDate(@Param(value="codeuf")String codeuf ,@Param(value="typecarburant")String typecarburant ,@Param(value="datedeb") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate datedeb,@Param(value="datefin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate datefin);
	
	@Query(value="SELECT SUM(t.montant)  From transaction t WHERE t.typecarburant = :typecarburant and t.date>= :datedeb  and t.date<= :datefin and t.code_uf=:codeuf", nativeQuery = true)
	float summontantc(@Param(value="codeuf")String codeuf ,@Param(value="typecarburant")String typecarburant ,@Param(value="datedeb") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate datedeb,@Param(value="datefin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate datefin) ;
	
	@Query(value="SELECT SUM(t.quantite)  From transaction t WHERE t.typecarburant = :typecarburant and t.date>= :datedeb  and t.date<= :datefin and t.code_uf=:codeuf", nativeQuery = true)
	float sumqantc(@Param(value="codeuf")String codeuf ,@Param(value="typecarburant")String typecarburant ,@Param(value="datedeb") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate datedeb,@Param(value="datefin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate datefin) ;
	
	@Query(value="SELECT SUM(t.kilometrage)  From transaction t WHERE t.typecarburant = :typecarburant and t.date>= :datedeb  and t.date<= :datefin and t.code_uf=:codeuf", nativeQuery = true)
	float sumkiloc(@Param(value="codeuf")String codeuf ,@Param(value="typecarburant")String typecarburant ,@Param(value="datedeb") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate datedeb,@Param(value="datefin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate datefin) ;
	
	
	
	
	
	// transaction by numvehicule
	@Query(value= "SELECT *  FROM transaction t WHERE t.numvehicule = :numvehicule and t.date>= :datedeb  and t.date<= :datefin and t.code_uf=:codeuf" , nativeQuery = true) 
	List<Transaction> getBytvehiculeAndDate(@Param(value="codeuf")String codeuf ,@Param(value="numvehicule")long numvehicule ,@Param(value="datedeb") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate datedeb,@Param(value="datefin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate datefin);
	
	@Query(value="SELECT SUM(t.montant)  From transaction t WHERE t.numvehicule = :numvehicule and t.date>= :datedeb  and t.date<= :datefin and t.code_uf=:codeuf", nativeQuery = true)
	float summontv(@Param(value="codeuf")String codeuf ,@Param(value="numvehicule")long  numvehicule ,@Param(value="datedeb") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate datedeb,@Param(value="datefin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate datefin) ;
	
	@Query(value="SELECT SUM(t.kilometrage)  From transaction t WHERE t.numvehicule = :numvehicule and t.date>= :datedeb  and t.date<= :datefin and t.code_uf=:codeuf", nativeQuery = true)
	float sumkilov(@Param(value="codeuf")String codeuf ,@Param(value="numvehicule")long  numvehicule ,@Param(value="datedeb") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate datedeb,@Param(value="datefin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate datefin) ;
	
	@Query(value="SELECT SUM(t.quantite)  From transaction t WHERE t.numvehicule = :numvehicule and t.date>= :datedeb  and t.date<= :datefin and t.code_uf=:codeuf", nativeQuery = true)
	float sumquantv(@Param(value="codeuf")String codeuf ,@Param(value="numvehicule")long  numvehicule ,@Param(value="datedeb") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate datedeb,@Param(value="datefin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate datefin) ;
	
	
}
