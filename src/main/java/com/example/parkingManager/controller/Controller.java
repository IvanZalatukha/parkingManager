package com.example.parkingManager.controller;

import com.example.parkingManager.model.Parking;
import com.example.parkingManager.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@org.springframework.stereotype.Controller
public class Controller {
    private ParkingService parkingService;


    @Autowired(required = true)
    @Qualifier(value = "parkingService")
    public void setParkingService(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    @RequestMapping(value = "parkings", method = RequestMethod.GET)
    public String listParkings(Model model) {
        model.addAttribute("parking", new Parking());
        model.addAttribute("listParkings", this.parkingService.getAllParkings());
        return "parkings";
    }

    @RequestMapping(value = "parkings/add", method = RequestMethod.POST)
    public String addParking(@ModelAttribute("parking") Parking parking) {
        if (parking.getId() == 0) {
            this.parkingService.addParking(parking);
        } else {
            this.parkingService.updateParking(parking);
        }
        return "redirect:/parkings";
    }

    @RequestMapping(value = "/remove/{id}")
    public String removeParking(@PathVariable("id") int id) {
        this.removeParking(id);
        return "redirect:/parkings";
    }

    @RequestMapping("edit/{id}")
    public String editBook(@PathVariable("id") int id, Model model){
        model.addAttribute("book", this.parkingService.getParkingById(id));
        model.addAttribute("listBooks", this.parkingService.getAllParkings());
        return "parkings";
    }
    @RequestMapping("parkingdata/{id}")
    public String parkingData(@PathVariable("id") int id, Model model) {
        model.addAttribute("parking", this.parkingService.getParkingById(id));
        return "parkingdata";
    }

}
