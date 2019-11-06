package co.edu.unal.se1;

import android.content.Context;
import androidx.test.core.app.ApplicationProvider;
import org.junit.Test;

import co.edu.unal.se1.businessLogic.controller.AccountController;
import co.edu.unal.se1.businessLogic.controller.UserController;
import co.edu.unal.se1.dataAccess.model.Account;

import static org.junit.Assert.*;

public class AccountControllerTest {
    @Test
    public void getBalancebyId_withNewAccount(){
        AccountController accountController = new AccountController();
        int testId = -1;
        long testBalance = 500;
        Account account = new Account();
        account.setId( testId );
        account.setBalance( testBalance );
        accountController.createAccount( account , ApplicationProvider.getApplicationContext() );
        long result = accountController.getBalanceById( testId , ApplicationProvider.getApplicationContext() );
        accountController.deleteAccount( testId , ApplicationProvider.getApplicationContext() );
        assertEquals( testBalance , result );
    }
}
