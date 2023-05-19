package com.example.spring_telegram_bot.Commands;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface WorKerCommand {
    public SendMessage start(Update updata);
    public SendMessage sendDefaultMessage(Update update);
}