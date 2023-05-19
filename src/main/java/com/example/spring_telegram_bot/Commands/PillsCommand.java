package com.example.spring_telegram_bot.Commands;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

@Component
public class PillsCommand implements WorKerCommand {
    @Override
    public SendMessage start(Update updata) {
        if (!updata.getMessage().getText().equals("Подача заявлений на выписку рецептов")) {
            return null;
        }
        SendMessage sendMessage =new SendMessage();
        sendMessage.setChatId(updata.getMessage().getChatId().toString());
        KeyboardRow k1 = new KeyboardRow();
        k1.add(new KeyboardButton("Морфий"));
        k1.add(new KeyboardButton("Хлорпромазин"));
        KeyboardRow k2 = new KeyboardRow();
        k2.add(new KeyboardButton("Пипофезин"));
        k2.add(new KeyboardButton("Соталол"));
        KeyboardRow k3 = new KeyboardRow();
        k3.add(new KeyboardButton("Инсулин"));
        k3.add(new KeyboardButton("Баклофен"));

        List<KeyboardRow> list4 = new ArrayList<>();
        list4.add(k1);
        list4.add(k2);
        list4.add(k3);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(list4);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        sendMessage.setText("Выберите подходящее лекарство");
        return sendMessage;
    }

    @Override
    public SendMessage sendDefaultMessage(Update update) {
        return null;
    }
}

