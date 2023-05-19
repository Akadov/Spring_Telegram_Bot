package com.example.spring_telegram_bot.Models;

import com.example.spring_telegram_bot.Helpers.DoctorEnum;
import com.example.spring_telegram_bot.Helpers.PillsEnum;
import lombok.Data;

import javax.persistence.*;

@Table(name = "telegram_user")
@Entity
@Data
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column (name = "username")
    String username;

    @Column(name = "telegram_id")
    String tgId;

    @Column(name = "name")
    String name;

    @Column(name = "wanted_doc")
    DoctorEnum doctorEnum;

    @Column(name = "wanted_pills")
    PillsEnum pillsEnum;
}