package com.example.spring_telegram_bot;


import com.example.spring_telegram_bot.Commands.*;
import com.example.spring_telegram_bot.Commands.BooksCommand.*;
import com.example.spring_telegram_bot.Commands.PillsCommands.*;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class Bot extends TelegramLongPollingBot {


    @Override
    public String getBotUsername() {
        return "@saika_1232_bot";
    }


    @Override
    public String getBotToken(){
        return "5751817449:AAEPJOnG1cJxScSj2mFtfYh8gE_oMn5aeKk";
    }

    @Override
    public void onUpdateReceived(Update update) {
        KeyboardRow k = new KeyboardRow();

        k.add(new KeyboardButton("Long In"));

        k.add(new KeyboardButton("Запись к врачу"));

        k.add(new KeyboardButton("Подача заявлений на выписку рецептов"));
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId().toString());
        sendMessage.setText("Выберите дейсткие");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(Collections.singletonList(k));
        sendMessage.setReplyMarkup(replyKeyboardMarkup);

        List<WorKerCommand> list = new ArrayList<>();
        list.add(new LoginCommand());
        list.add(new BookCommand());
        list.add(new ChooseTime());

        list.add(new AllergologCommand());
        list.add(new GinekologCommand());
        list.add(new HirurgCommand());
        list.add(new LorCommand());
        list.add(new OkulistCommand());
        list.add(new TerapevtCommand());

        list.add(new PillsCommand());
        list.add(new PillsTime());
        list.add(new BaclofenCommand());
        list.add(new HlorpromazinCommand());
        list.add(new InsulinCommand());
        list.add(new MorfinCommand());
        list.add(new PipofezinCommand());
        list.add(new SotalolCommand());




        SendMessage s;
        for (WorKerCommand w: list){
            if ((s = w.start(update))!=null){
                sendMessage = s;
                break;
            }
        }


        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}