
package com.technician.Springboot.controller;
import java.io.Console;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.technician.Springboot.exception.ResourceNotFoundException;
import com.technician.Springboot.repository.TechnicianRepository;
import com.technician.Springboot.service.TechnicianService;
import com.technician.Springboot.model.Technician;

@CrossOrigin(origins = "http://localhost:3000")
//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class TechnicianController {
   @Autowired
   private TechnicianRepository technicianRepository;
   @Autowired
   private TechnicianService service;
   
   
  // Get all technicians 
   @GetMapping("/technician")
   public List<Technician> getAllTechnicians(){
	   return technicianRepository.findAll();
   }
   
   
   
   //get technician by TechID rest API
   @GetMapping("/technician/{techID}")
   public ResponseEntity<Technician> getTechnicianById(@PathVariable Long techID){
	   Technician technician = technicianRepository.findById(techID)
			   .orElseThrow(() -> new ResourceNotFoundException("TECHNICIAN NOT FOUND WITH TECHID"+ techID));

	   return ResponseEntity.ok(technician);
	  
   }
   
   //search Technician API
   @PostMapping("/search-technician")
   public ResponseEntity<Technician> searchTechnicianById(@RequestBody Technician technician)throws Exception{
	   Long TechID = technician.getTechID();
	   Technician searchtechnician = technicianRepository.findById(TechID)
			   .orElseThrow(() -> new ResourceNotFoundException("TECHNICIAN NOT FOUND WITH TECHID"));

	   return ResponseEntity.ok(searchtechnician);
	  
   }
   
  
   
 //  create technician rest API
 @PostMapping("/technicians")
 public Technician createTechnician(@RequestBody Technician technician) {
	   return technicianRepository.save(technician);
 } 
 
 

//login rest API
@PostMapping("/technician-login")
public Technician TechnicianLogin(@RequestBody Technician technician)throws Exception 
{
	Long TechID = technician.getTechID();
	 String Password = technician.getPassword();
	 
	 Technician technicianObject = null;
	 if(TechID != null && Password != null)
	 {
		  technicianObject = technicianRepository.find(TechID,Password);
		 
	 }
	 
	 if(technicianObject == null) {
		   throw new Exception("Invalid TechicianID or Password");
	 }
	 
	 
	 return technicianObject ;
	 
	
} 




//delete technician rest API
@DeleteMapping("/techniciand/{techID}")
public ResponseEntity<Map<String,Boolean>>deleteTechnician(@PathVariable Long techID){
	   Technician technician = technicianRepository.findById(techID)
			   .orElseThrow(() -> new ResourceNotFoundException("TECHNICIAN NOT FOUND WITH TECHID"+ techID));
	  
	   technicianRepository.delete(technician);
	   Map<String,Boolean>response = new HashMap<>();
	   response.put("deleted", Boolean.TRUE);
	   return ResponseEntity.ok(response);  
}

//update technician API
@PutMapping("/updateTechnician/{techID}")
public ResponseEntity<Technician> updateTechnician(@PathVariable Long techID,@RequestBody Technician technicianDetails){
	   Technician technician = technicianRepository.findById(techID)
			   .orElseThrow(() -> new ResourceNotFoundException("TECHNICIAN NOT FOUND WITH TECHID"+ techID));
technician.setName(technicianDetails.getName());
technician.setNumber(technicianDetails.getNumber());   
technician.setEmail(technicianDetails.getEmail()); 
technician.setGender(technicianDetails.getGender()); 
technician.setPassword(technicianDetails.getPassword()); 
technician.setPermanentAddress(technicianDetails.getPermanentAddress()); 
technician.setCommunicationAddress(technicianDetails.getCommunicationAddress()); 
	   Technician updatedTechnician = technicianRepository.save(technician);
	   return ResponseEntity.ok(updatedTechnician);
	  
}


//Forgot Password Rest API
@PutMapping("/forgot-password")
public ResponseEntity<Technician> forgotPassword(@RequestBody Technician technicianDetails){
	Long TechID = technicianDetails.getTechID();
	String TechPassword = technicianDetails.getPassword();
	  Technician technician = technicianRepository.findById(TechID)
			   .orElseThrow(() -> new ResourceNotFoundException("TECHNICIAN NOT FOUND WITH TECHID"+ TechID));
	  

technician.setPassword(TechPassword);

	   Technician updatedTechnician = technicianRepository.save(technician);
	   return ResponseEntity.ok(updatedTechnician);
	  
}




}



































/*
//loginTechnician rest API
@PostMapping("/login")
public Optional<Technician> logintechnician(@RequestBody Technician technician) throws Exception
{
Long variableTechID = technician.getTechID();
String variablePassword = technician.getPassword();
Optional<Technician> technicianObject = null;
Optional<Technician> technicianObject2 = null;

//if(variableTechID != null /*&& variablePassword != null*///) {
//	    technicianObject = service.fetchTechnicianByIdandPassword(variableTechID/*, variablePassword*/);
	 // --- technicianObject2 = service.fetchTechnicianByPassword(variablePassword);
//}
//if(variablePassword != null) {
//	 technicianObject2 = service.fetchTechnicianByPassword(variablePassword);
	 
//}
/*
if(variableTechID != null && variablePassword != null)
{
	  technicianObject = service.fetchTechnicianByIdandPassword(variableTechID);
	  technicianObject2 = service.fetchTechnicianByPassword(variablePassword);
}

if(technicianObject == null || technicianObject2 == null) {
	   throw new Exception("Invalid TechicianID or Password");
}


return technicianObject ;
}*/
/*
//----------------------------------------------------------------------------
//loginTechnician rest API
@PostMapping("/login1")
public Optional<Technician> logintechnician2(@RequestBody Technician technician) throws Exception
{
Long variableTechID2 = technician.getTechID();
String variablePassword2 = technician.getPassword();

Optional<Technician> technicianObject3 = null;

if(variableTechID2 != null && variablePassword2 != null) {

	technicianObject3 = service.fetchTechnicianByTechIDandPassword(variablePassword2,variableTechID2);
	   
}
if(technicianObject3 == null) {
	   throw new Exception("Invalid Credentials");
}
return technicianObject3;}

 
*/
//-----------------------------------------------------------------------------*/
/*
@PostMapping("/loginapi")
public List<com.technician.Springboot.model.Technician> Technician(@RequestBody Technician technician)throws Exception 
{
	Long variableTechID = technician.getTechID();
	 String variablePassword = technician.getPassword();
	 List<Technician> technicianObject = null;
	 if(variableTechID != null && variablePassword != null)
	 {
	 technicianObject = technicianRepository.find(variableTechID,variablePassword);
		 
	 }
	 
	 if(technicianObject == null) {
		   throw new Exception("Invalid TechicianID or Password");
	 }
	 
	 
	 return technicianObject ;
	 
	 
	 //  return technicianRepository.find(variableTechID,variablePassword);
} 
*/

