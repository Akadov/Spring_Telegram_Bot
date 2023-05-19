package com.example.spring_telegram_bot.Commands.BooksCommand;

import com.example.spring_telegram_bot.Commands.WorKerCommand;
import com.example.spring_telegram_bot.Helpers.DoctorEnum;
import com.example.spring_telegram_bot.Helpers.DoctorHelper;
import com.example.spring_telegram_bot.Helpers.UserHelper;
import com.example.spring_telegram_bot.Models.UserModel;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

@Component
public class LorCommand implements WorKerCommand {
    @Override
    public SendMessage start(Update updata) {
        if (!updata.getMessage().getText().equals("Лор")){
            return null;
        }
        UserModel userModel = UserHelper.findUser(updata.getMessage().getFrom().getId().toString());
        userModel.setDoctorEnum(DoctorEnum.LOR);
        UserHelper.saveUser(userModel);
        return sendDefaultMessage(updata);
    }

    @Override
    public SendMessage sendDefaultMessage(Update update) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId().toString());
        sendMessage.setText("Выберите подходящее время");

        List<String> list = DoctorHelper.getFreetimes(DoctorEnum.LOR);
        KeyboardRow k1 = new KeyboardRow();
        k1.add(new KeyboardButton(list.get(0)));
        k1.add(new KeyboardButton(list.get(1)));

        List<KeyboardRow> list1 =new ArrayList<>();
        list1.add(k1);


        KeyboardRow k2 = new KeyboardRow();
        if (list.size()>2){
            for (int i = 2; i < list.size(); i++) {
                k2.add(new KeyboardButton(list.get(i)));
            }
            list1.add(k2);
        }
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(list1);

        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;

    }
}

