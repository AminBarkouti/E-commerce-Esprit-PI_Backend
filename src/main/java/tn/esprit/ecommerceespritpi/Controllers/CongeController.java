package tn.esprit.ecommerceespritpi.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ecommerceespritpi.Entities.Conge;
import tn.esprit.ecommerceespritpi.Services.ICongeService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/Conge")
public class CongeController {

    @Autowired
    ICongeService congeService;

    @GetMapping("/listConge")
    public List<Conge> getConges() {
        return congeService.getAllConges();
    }

    @PostMapping("/addConge")
    public Conge addConge(@RequestBody Conge conge) {
        return congeService.addConge(conge);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteConge(@PathVariable("id") Long id){
        return congeService.removeConge(id);
    }

    @GetMapping("/getById/{id}")
    public Conge getById(@PathVariable("id") Long id) {
        return congeService.getCongeById(id);
    }

    @PutMapping("/updateConge")
    public Conge updateConge(@RequestBody Conge conge) {
        return congeService.updateConge(conge);
    }

    @GetMapping("/isHolidayAvailable")
    public boolean isHolidayAvailable(@RequestParam("startDate") Date startDate, @RequestParam("endDate") Date endDate) {
        return congeService.isHolidayAvailable(startDate, endDate);
    }
}