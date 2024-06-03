package com.wipro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.entity.VolvoBus;
@Repository
public interface VolvoBusRepository extends JpaRepository<VolvoBus, Long> {

	List<VolvoBus> findBySourceAndDestination(String source, String destination);


}
