package tn.esprit.ecommerceespritpi.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.ecommerceespritpi.Entities.Conge;
import tn.esprit.ecommerceespritpi.Repository.ICongeRepository;

import java.util.Date;
import java.util.List;

@Service
public class CongeServiceImp implements ICongeService {

    @Autowired
    ICongeRepository congeRepo;

    @Override
    public Conge addConge(Conge conge) {
        return congeRepo.save(conge);
    }

    @Override
    public String removeConge(Long id) {
        congeRepo.deleteById(id);
        return "Conge removed";
    }

    @Override
    public Conge updateConge(Conge conge) {
        Conge existingConge = congeRepo.findById(conge.getIdConge()).get();
        existingConge.setDateDebut(conge.getDateDebut());
        existingConge.setDateFin(conge.getDateFin());
        existingConge.setStatutConge(conge.getStatutConge());
        congeRepo.save(existingConge);
        return existingConge;
    }

    @Override
    public Conge getCongeById(Long id) {
        return congeRepo.findById(id).get();
    }

    @Override
    public List<Conge> getAllConges() {
        return (List<Conge>) congeRepo.findAll();
    }

    @Override
    public boolean isHolidayAvailable(Date startDate, Date endDate) {
        List<Conge> overlappingConges = congeRepo.findOverlappingConges(startDate, endDate);
        return overlappingConges.isEmpty();
    }
}