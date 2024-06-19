package tn.esprit.ecommerceespritpi.Services;

import tn.esprit.ecommerceespritpi.Entities.Conge;

import java.util.Date;
import java.util.List;

public interface ICongeService {
    Conge addConge(Conge conge);

    String removeConge(Long id);

    Conge updateConge(Conge conge);

    Conge getCongeById(Long id);

    List<Conge> getAllConges();
    boolean isHolidayAvailable(Date startDate, Date endDate);

}