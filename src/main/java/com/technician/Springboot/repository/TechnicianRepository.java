package com.technician.Springboot.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.technician.Springboot.model.Technician;


import org.springframework.stereotype.Repository;

@Repository
public interface TechnicianRepository extends JpaRepository<Technician,Long>{


  @Query("SELECT t FROM Technician t WHERE LOWER(t.TechID) = LOWER(:TechID) AND LOWER(t.password) = LOWER(:password)")
  public Technician find(@Param("TechID") Long TechID,@Param("password") String password);

 
}

































// public Optional<Technician> findById(Long TechID);

// public Optional<Technician> findByPassword(String password);
 
 //public Optional<Technician> findByPasswordandID(String password,Long TechID);
 
 //@Query("SELECT t FROM Technician t WHERE LOWER(t.TechID) = LOWER(:TechID) AND LOWER(t.password) = LOWER(:password)")
 //public List<Technician> find(@Param("TechID") Long TechID,@Param("password") String password);

//public Technician findByIdPassword(Long TechID,String password);
//public Technician findByEmailandPassword(String email,String Password);

//public  List<Technician> findByTechIDAndPassword(String email, String password);
