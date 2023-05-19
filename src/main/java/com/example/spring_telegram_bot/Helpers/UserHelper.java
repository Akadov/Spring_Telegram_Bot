package com.example.spring_telegram_bot.Helpers;

import com.example.spring_telegram_bot.Models.UserModel;
import com.example.spring_telegram_bot.Repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserHelper {

    final
    UserRepo userRepo;

    public UserHelper(UserRepo userRepo) {
        this.userRepo = userRepo;
        helper = this;
    }
    private static UserHelper helper = null;

    public static void saveUser(UserModel u){
        helper.userRepo.save(u);
    }

    public static UserModel findUser(String tgId){
        UserModel userModel;
        userModel = helper.userRepo.findUSerModelByTgId(tgId);
        return userModel;
    }
}
