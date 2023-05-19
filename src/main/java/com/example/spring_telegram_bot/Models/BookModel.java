package com.example.spring_telegram_bot.Models;


import com.example.spring_telegram_bot.Helpers.DoctorEnum;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "book_list")
@Data
public class BookModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(name = "doctor")
    @Enumerated
    DoctorEnum doctorEnum;

    @Column(name = "time")
    String time;

    @Column(name = "igId")
    String tgId;

}
