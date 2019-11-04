package co.edu.unal.se1.businessLogic.controller;

import android.content.Context;

import co.edu.unal.se1.dataAccess.model.*;
import co.edu.unal.se1.dataAccess.repository.*;

public class AccountController {

    private AccountRepository accountRepository;
    private UserRepository userRepository;

    public AccountController() {

    }

    public void createAccount(Account account, Context context) {

        accountRepository = new AccountRepository(context);
        accountRepository.createAccount(account);
        System.out.println("¡Cuenta creada satisfactoriamente!");
    }

    public boolean sendMoney(int sourceId, int targetId, double value, Context context) {

        userRepository = new UserRepository(context);
        accountRepository = new AccountRepository(context);

        final User sourceUser = userRepository.getUserById(sourceId);
        final Account sourceAccount = accountRepository.getAccountById(sourceId);
        System.out.println("Source User - ID: " + sourceUser.getId() +
                ", Name: " + sourceUser.getName() +
                ", Balance: " + sourceAccount.getBalance());

        if (sourceAccount.getBalance() >= value) {

            final User targetUser = userRepository.getUserById(targetId);
            final Account targetAccount = accountRepository.getAccountById(targetId);
            System.out.println("Target User - ID: " + targetUser.getId() +
                    ", Name: " + targetUser.getName() +
                    ", Balance: " + targetAccount.getBalance());

            sourceAccount.setBalance(sourceAccount.getBalance() - value);
            targetAccount.setBalance(targetAccount.getBalance() + value);
            accountRepository.updateAccount(sourceAccount);
            accountRepository.updateAccount(targetAccount);

            final User updatedSourceUser = userRepository.getUserById(sourceId);
            final Account updatedSourceAccount = accountRepository.getAccountById(sourceId);
            System.out.println("Source User (updated) - ID: " + updatedSourceUser.getId() +
                    ", Name: " + updatedSourceUser.getName() +
                    ", Balance: " + updatedSourceAccount.getBalance());

            final User updatedTargetUser = userRepository.getUserById(targetId);
            final Account updatedTargetAccount = accountRepository.getAccountById(targetId);
            System.out.println("Target User (updated) - ID: " + updatedTargetUser.getId() +
                    ", Name: " + updatedTargetUser.getName() +
                    ", Balance: " + updatedTargetAccount.getBalance());

            return true;

        } else {

            return false;
        }

    }

    public long getBalanceById( int id , Context context ){
        accountRepository = new AccountRepository(context);
        Account  account = accountRepository.getAccountById( id );
        return account.getBalance();
    }

}
