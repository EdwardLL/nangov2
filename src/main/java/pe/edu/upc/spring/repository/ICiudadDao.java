package pe.edu.upc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Ciudad;

@Repository
public interface ICiudadDao extends JpaRepository<Ciudad, Integer> {

}
