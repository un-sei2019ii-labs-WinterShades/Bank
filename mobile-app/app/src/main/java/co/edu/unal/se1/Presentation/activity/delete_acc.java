package co.edu.unal.se1.Presentation.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import co.edu.unal.se1.R;
import co.edu.unal.se1.businessLogic.controller.AccountController;
import co.edu.unal.se1.businessLogic.controller.UserController;

public class delete_acc extends AppCompatActivity {

    private UserController userController;
    private AccountController accountController;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar);

        final TextView delAcc = findViewById(R.id.delAccount);
        final Button  delete= findViewById(R.id.delete);


        final UserController userController = new UserController();
        final AccountController accountController = new AccountController();

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(" ------------------------------------------------------------ delete acc ----------------------------- ");
                int id = Integer.parseInt( delAcc.getText().toString());
                System.out.println("DELETE -> " + id);
                userController.deleteUser(id, getApplicationContext());
                System.out.println("DONE USER -> " + id);
                accountController.deleteAccount(id, getApplicationContext());
            }
        });

    }

}
