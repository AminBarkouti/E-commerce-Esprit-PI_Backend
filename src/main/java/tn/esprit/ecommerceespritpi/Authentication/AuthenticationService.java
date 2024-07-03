package tn.esprit.ecommerceespritpi.Authentication;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.ecommerceespritpi.Entities.User;
import tn.esprit.ecommerceespritpi.Repository.IUserRepository;

@Service
public class AuthenticationService {
    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    public String authenticate(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return jwtTokenProvider.createToken(user);
        }
        return null;
    }
}
