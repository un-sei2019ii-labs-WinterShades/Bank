package co.edu.unal.se1.Presentation.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import co.edu.unal.se1.R;
import co.edu.unal.se1.businessLogic.controller.*;
import co.edu.unal.se1.dataAccess.model.*;

public class create_user extends AppCompatActivity {

    private UserController userController;
    private AccountController accountController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        final EditText idInput = findViewById(R.id.id);
        final EditText nameInput = findViewById(R.id.name1);
        final EditText balanceInput = findViewById(R.id.saldo1);
        final EditText password = findViewById(R.id.password1);


        Button createButton = findViewById(R.id.createUser);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                User user = new User();
                Account account = new Account();
                user.setId(Integer.parseInt(idInput.getText().toString()));
                account.setId(Integer.parseInt(idInput.getText().toString()));
                user.setName(nameInput.getText().toString());
                account.setBalance(Long.parseLong(balanceInput.getText().toString()));
                user.setPassword(password.getText().toString());

                userController = new UserController();
                userController.createUser(user, getApplicationContext());
                accountController = new AccountController();
                accountController.createAccount(account, getApplicationContext());
            }
        });




    }

}
