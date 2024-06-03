package com.wipro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.wipro.entity.VolvoBus;
import com.wipro.service.VolvoBusService;

import java.util.List;

@RestController
@RequestMapping("/api/buses")
public class VolvoBusController {

    @Autowired
    private VolvoBusService busService;

    @PutMapping
    public List<VolvoBus> getAllBuses() {
        return busService.findAllBuses();
    }

    @GetMapping("{id}")
    public VolvoBus getBusById(@PathVariable Long id) {
    	id = (long) 1;
    	System.out.println(busService.findBusById(id)+"   krjgbriugb");
        return busService.findBusById(id).orElse(null);
    }

    @GetMapping("route")
    public List<VolvoBus> getBusesByRoute(@RequestParam String source, @RequestParam String destination) {
        return busService.findVolvoBusByRoute(source, destination);
    }

    @PostMapping
    public VolvoBus saveBus(@RequestBody VolvoBus bus) {
        return busService.addVolvoBus(bus);
    }

    @PutMapping("{id}")
    public VolvoBus updateBus(@PathVariable Long id, @RequestBody VolvoBus updatedBus) {
        return busService.updateVolvoBusById(id, updatedBus);
    }

    @DeleteMapping("{id}")
    public void deleteBus(@PathVariable Long id) {
        busService.deleteVolvoBusById(id);
    }
}
