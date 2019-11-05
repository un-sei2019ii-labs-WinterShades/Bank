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

    public boolean adminNotExists( int id , Context context ){
        AdminRepository adminRepository = new AdminRepository( context );
        Admin admin = adminRepository.getAdminById( id );
        return admin == null;
    }

    public boolean verifyAdmin( int id , String password , Context context ){
        adminRepository = new AdminRepository(context);
        Admin admin = adminRepository.getAdminById( id );
        System.out.println(" :: " + admin.getId() + " - " + admin.getPassword());
        return admin.getPassword().equals( password );
    }

    public boolean depositMoney(int sourceId, int targetId, long value, Context context) {

        AdminRepository adminRepository = new AdminRepository(context);
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

        final Admin updatedSourceAdmin = adminRepository.getAdminById(sourceId);
        System.out.println("Source User (updated) - ID: " + updatedSourceAdmin.getId() +
                ", Name: " + updatedSourceAdmin.getName() );

        final User updatedTargetUser = userRepository.getUserById(targetId);
        final Account updatedTargetAccount = accountRepository.getAccountById(targetId);
        System.out.println("Target User (updated) - ID: " + updatedTargetUser.getId() +
                ", Name: " + updatedTargetUser.getName() +
                ", Balance: " + updatedTargetAccount.getBalance());

        return true;

    }

}
