package com.example.spring_telegram_bot.Models;

import com.example.spring_telegram_bot.Helpers.PillsEnum;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Pills_list")
@Data
public class PillsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(name = "pills")
    @Enumerated
    PillsEnum pillsEnum;

    @Column(name = "time")
    String times;

    @Column(name = "igId")
    String telegramId;

}

