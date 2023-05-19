package com.example.spring_telegram_bot.Helpers;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class PillsTimeControl {
    private List<String> time = new ArrayList<>();

    public PillsTimeControl() {
        this.time.add("09:00");
        this.time.add("09:30");

        this.time.add("10:00");
        this.time.add("10:30");

        this.time.add("11:00");
        this.time.add("11:30");

        this.time.add("12:00");
        this.time.add("12:30");
    }
}
