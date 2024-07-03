package tn.esprit.ecommerceespritpi.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ecommerceespritpi.Authentication.AuthenticationService;
import tn.esprit.ecommerceespritpi.Entities.Accounts;
import tn.esprit.ecommerceespritpi.Entities.User;
import tn.esprit.ecommerceespritpi.Services.IAccountsService;

import java.util.Collections;

@RestController
@RequestMapping("/accounts")
@CrossOrigin(origins = "http://localhost:4200")
public class AccountsController {
    @Autowired
    IAccountsService accountsService;

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/influencers/")
    public Accounts createInfluencerAccount(@RequestBody Accounts accounts) {
        return accountsService.createInfluencerAccount(accounts);
    }

    @PostMapping("/token")
    public ResponseEntity<?> GenerateToken(@RequestBody User user) {
        String token = authenticationService.authenticate(user.getEmail(), user.getPassword());
        if (token == null) {
            return ResponseEntity.status(401).body(Collections.singletonMap("error", "Invalid email or password"));
        }
        return ResponseEntity.ok(Collections.singletonMap("token", token));
    }
}
