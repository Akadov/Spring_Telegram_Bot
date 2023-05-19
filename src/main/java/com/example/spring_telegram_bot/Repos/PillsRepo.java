package com.example.spring_telegram_bot.Repos;


import com.example.spring_telegram_bot.Helpers.PillsEnum;
import com.example.spring_telegram_bot.Models.PillsModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PillsRepo extends JpaRepository<PillsModel, Long> {
    List<PillsModel> findPillsModelByPillsEnum(PillsEnum p);
}
