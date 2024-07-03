package tn.esprit.ecommerceespritpi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.ecommerceespritpi.Entities.Accounts;
import tn.esprit.ecommerceespritpi.Repository.IAccountsRepository;

@Service
public class AccountsServiceImp implements IAccountsService {
    @Autowired
    IAccountsRepository accountsRepo;
    @Override
    public Accounts createInfluencerAccount(Accounts account) {
        return accountsRepo.save(account);
    }
}
