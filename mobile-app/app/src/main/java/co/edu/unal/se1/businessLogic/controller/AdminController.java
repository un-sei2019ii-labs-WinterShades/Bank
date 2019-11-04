package co.edu.unal.se1.businessLogic.controller;

import android.content.Context;

import co.edu.unal.se1.dataAccess.model.Account;
import co.edu.unal.se1.dataAccess.model.Admin;
import co.edu.unal.se1.dataAccess.model.User;
import co.edu.unal.se1.dataAccess.repository.AccountRepository;
import co.edu.unal.se1.dataAccess.repository.AdminRepository;
import co.edu.unal.se1.dataAccess.repository.UserRepository;

public class AdminController {

    private AdminRepository adminRepository;

    public AdminController() {

    }

    public void createAdmin(Admin admin, Context context) {

        adminRepository = new AdminRepository(context);
        adminRepository.createAdmin(admin);
        System.out.println("¡Admin creado satisfactoriamente!");
    }

    public boolean depositMoney(int sourceId, int targetId, double value, Context context) {

        UserRepository userRepository = new UserRepository(context);
        AccountRepository accountRepository = new AccountRepository(context);

        final Admin sourceAdmin = adminRepository.getAdminById(sourceId);
        System.out.println("Source User - ID: " + sourceAdmin.getId() +
                ", Name: " + sourceAdmin.getName() );

        final User targetUser = userRepository.getUserById(targetId);
        final Account targetAccount = accountRepository.getAccountById(targetId);
        System.out.println("Target User - ID: " + targetUser.getId() +
                ", Name: " + targetUser.getName() +
                ", Balance: " + targetAccount.getBalance());

        targetAccount.setBalance(targetAccount.getBalance() + value);
        accountRepository.updateAccount(targetAccount);

        final User updatedSourceUser = userRepository.getUserById(sourceId);
        System.out.println("Source User (updated) - ID: " + updatedSourceUser.getId() +
                ", Name: " + updatedSourceUser.getName() );

        final User updatedTargetUser = userRepository.getUserById(targetId);
        final Account updatedTargetAccount = accountRepository.getAccountById(targetId);
        System.out.println("Target User (updated) - ID: " + updatedTargetUser.getId() +
                ", Name: " + updatedTargetUser.getName() +
                ", Balance: " + updatedTargetAccount.getBalance());

        return true;

    }

}
