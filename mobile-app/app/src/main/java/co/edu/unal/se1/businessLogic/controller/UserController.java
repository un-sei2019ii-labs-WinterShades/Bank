package co.edu.unal.se1.businessLogic.controller;

import android.content.Context;

import co.edu.unal.se1.dataAccess.model.User;
import co.edu.unal.se1.dataAccess.repository.UserRepository;

public class UserController {

    private UserRepository userRepository;

    public UserController() {

    }

    public void createUser(User user, Context context) {

        userRepository = new UserRepository(context);
        userRepository.createUser(user);
        System.out.println("¡Usuario creado satisfactoriamente!");
    }

}
