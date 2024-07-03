package tn.esprit.ecommerceespritpi.Repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.ecommerceespritpi.Entities.User;

public interface IUserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
}
