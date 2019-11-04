package co.edu.unal.se1.Presentation.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import androidx.appcompat.app.AppCompatActivity;
import co.edu.unal.se1.R;
import co.edu.unal.se1.businessLogic.controller.*;
import co.edu.unal.se1.dataAccess.*;
import co.edu.unal.se1.dataAccess.db.Database;
import co.edu.unal.se1.dataAccess.model.Account;
import co.edu.unal.se1.dataAccess.model.User;
import co.edu.unal.se1.dataAccess.dao.UserDao;
import co.edu.unal.se1.dataAccess.repository.*;
import co.edu.unal.se1.dataAccess.db.Database;
import co.edu.unal.se1.dataAccess.*;
import co.edu.unal.se1.dataAccess.repository.UserRepository;

public class new_main extends AppCompatActivity {

    public static int idUser;

    public void abrir_create( View view){
        Intent intent = new Intent(this, crear_usuario.class );
        startActivity(intent);
    }

    public void abrir_saldo (View view){
        Intent intent = new Intent (this, ver_saldo.class);
        startActivity(intent);

    }

    private UserController userController;
    private AccountController accountController;


    public boolean verificar (int id, String password){
        UserController userController = new UserController();
        return userController.verifyUser( id , password , getApplicationContext() );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_main);

        final EditText idInput = findViewById(R.id.userID);
        final EditText passInput = findViewById(R.id.password);

        Button login = findViewById(R.id.logIn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final boolean verify = verificar( Integer.parseInt( idInput.getText().toString() ) , passInput.getText().toString() ) ;
                if (verify){
                    idUser = Integer.parseInt( idInput.getText().toString() );
                    abrir_saldo(v);
                }
            }
        });

    }



}