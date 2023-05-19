package com.example.spring_telegram_bot.Commands;


import com.example.spring_telegram_bot.Helpers.UserHelper;
import com.example.spring_telegram_bot.Models.UserModel;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.Collections;

@Component
public class LoginCommand implements WorKerCommand {
    @Override
    public SendMessage start(Update updata) {
        if (updata.getMessage().getText().equals("Log In")
                &&!updata.getMessage().getText().equals("Оставте своё имя")
                &&!updata.getMessage().getText().equals("Остаться анонимом")){
            return null;
        }
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(updata.getMessage().getChatId().toString());
        if (updata.getMessage().getText().equals("Log In")){
            KeyboardRow keyboardRow = new KeyboardRow();
            keyboardRow.add(new KeyboardButton("Оставте своё имя"));
            keyboardRow.add(new KeyboardButton("Остаться анонимом"));
            sendMessage.setText("Выберите действие");
            ReplyKeyboardMarkup replyKeyboardMarkup =new ReplyKeyboardMarkup();
            replyKeyboardMarkup.setKeyboard(Collections.singletonList(keyboardRow));
            sendMessage.setReplyMarkup(replyKeyboardMarkup);
        }
        UserModel userModel = new UserModel();
        userModel.setUsername(updata.getMessage().getFrom().getUserName());
        userModel.setTgId(updata.getMessage().getFrom().getId().toString());
        if (updata.getMessage().getText().equals("Остаться анонимом")){
            sendMessage.setText("Пользователь сохранен");
            UserHelper.saveUser(userModel);
        }
        if (updata.getMessage().getText().equals("Оставте своё имя")){
            userModel.setName(updata.getMessage().getFrom().getFirstName());
            sendMessage.setText("Пользователь сохранен");
            UserHelper.saveUser(userModel);
        }
        return sendMessage;
    }

    @Override
    public SendMessage sendDefaultMessage(Update update) {
        return null;
    }
}