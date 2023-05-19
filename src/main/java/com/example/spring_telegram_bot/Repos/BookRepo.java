package com.example.spring_telegram_bot.Repos;

import com.example.spring_telegram_bot.Helpers.DoctorEnum;
import com.example.spring_telegram_bot.Models.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<BookModel, Long> {
    List<BookModel> findBookModelByDoctorEnum(DoctorEnum d);
}
