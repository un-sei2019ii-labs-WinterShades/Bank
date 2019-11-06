package co.edu.unal.se1;

import android.content.Context;
import androidx.test.core.app.ApplicationProvider;
import org.junit.Test;

import co.edu.unal.se1.businessLogic.controller.UserController;

import static org.junit.Assert.*;

public class UserControllerTest {

    @Test
    public void verifyUser_notRegisteredUser_ReturnFalse(){
        UserController userController = new UserController();
        int testId = -1;
        String testPass = "password";
        boolean result = userController.verifyUser( testId , testPass , ApplicationProvider.getApplicationContext() );
        assertFalse( result );
    }
}
