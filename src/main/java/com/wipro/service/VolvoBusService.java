package com.wipro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.entity.VolvoBus;
import com.wipro.repository.VolvoBusRepository;

@Service
public class VolvoBusService {
	@Autowired
	VolvoBusRepository busRepository;
	


	public List<VolvoBus> findAllBuses() {
		return busRepository.findAll();
	}

	public Optional<VolvoBus> findBusById(Long id) {
		return busRepository.findById(id);
	}

	public List<VolvoBus> findVolvoBusByRoute(String source, String destination) {
		return busRepository.findBySourceAndDestination(source, destination);
	}

	public VolvoBus addVolvoBus(VolvoBus bus) {
		return busRepository.save(bus);
	}

	public VolvoBus updateVolvoBusById(Long id, VolvoBus updatedBus) {
		Optional<VolvoBus> existingBusOptional = busRepository.findById(id);

        if (existingBusOptional.isPresent()) {
            VolvoBus existingBus = existingBusOptional.get();
            existingBus.setSource(updatedBus.getSource());
            existingBus.setDestination(updatedBus.getDestination());
            existingBus.setAmount(updatedBus.getAmount());

            return busRepository.save(existingBus);
        } else {
            throw new RuntimeException("Bus with ID " + id + " not found");
        }
	}

	public void deleteVolvoBusById(Long id) {
		busRepository.deleteById(id);
		
	}

}
