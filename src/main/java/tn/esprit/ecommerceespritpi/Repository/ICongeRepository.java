package tn.esprit.ecommerceespritpi.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.ecommerceespritpi.Entities.Conge;

import java.util.Date;
import java.util.List;

public interface ICongeRepository extends CrudRepository<Conge,Long> {
    @Query("SELECT c FROM Conge c WHERE (c.dateDebut <= :endDate AND c.dateFin >= :startDate)")
    List<Conge> findOverlappingConges(Date startDate, Date endDate);
}
