package co.edu.unal.se1;

import co.edu.unal.se1.businessLogic.controller.AccountController;
import co.edu.unal.se1.dataAccess.model.Account;

import android.content.Context;
import androidx.test.core.app.ApplicationProvider;
import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = 24)
public class AccountControllerTest {

    private Context context = ApplicationProvider.getApplicationContext();

    @Test
    public void getBalancebyId_withNewAccount(){
        AccountController accountController = new AccountController();
        int testId = -1;
        long testBalance = 500;
        Account account = new Account();
        account.setId( testId );
        account.setBalance( testBalance );
        accountController.createAccount( account , context );
        long result = accountController.getBalanceById( testId , context );
        accountController.deleteAccount( testId , context );
        assertEquals( testBalance , result );
    }
}
