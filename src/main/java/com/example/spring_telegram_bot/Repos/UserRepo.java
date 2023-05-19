package com.example.spring_telegram_bot.Repos;

import com.example.spring_telegram_bot.Models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserModel, Long> {
    UserModel findUSerModelByTgId(String id);

}
