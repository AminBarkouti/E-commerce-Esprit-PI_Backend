package tn.esprit.ecommerceespritpi.Repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.ecommerceespritpi.Entities.Accounts;

public interface IAccountsRepository extends CrudRepository<Accounts, Long> {
}
