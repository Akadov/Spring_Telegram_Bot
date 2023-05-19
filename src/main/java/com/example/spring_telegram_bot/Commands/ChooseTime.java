package com.example.spring_telegram_bot.Commands;


import com.example.spring_telegram_bot.Helpers.DoctorHelper;
import com.example.spring_telegram_bot.Helpers.TimeControl;
import com.example.spring_telegram_bot.Helpers.UserHelper;
import com.example.spring_telegram_bot.Models.BookModel;
import com.example.spring_telegram_bot.Models.UserModel;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.ArrayList;
import java.util.List;

@Component
public class ChooseTime implements WorKerCommand{
    @Override
    public SendMessage start(Update updata) {
        TimeControl timeControl = new TimeControl();
        List<String> list = timeControl.getTimes();
        boolean ifThisCommand = false;
        for (String str: list){
            if (updata.getMessage().getText().equals(str)){
                ifThisCommand = true;
            }
        }
        if (ifThisCommand){
            return null;
        }
        BookModel bookModel = new BookModel();
        bookModel.setTime(updata.getMessage().getText().toString());

        UserModel userModel =new UserModel();
        userModel = UserHelper.findUser(updata.getMessage().getFrom().getId().toString());

        bookModel.setTgId(updata.getMessage().getFrom().getId().toString());
        bookModel.setDoctorEnum(userModel.getDoctorEnum());

        DoctorHelper.save(bookModel);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(updata.getMessage().getChatId().toString());
        sendMessage.setText("Вы успешно записались к вречу");
        return sendMessage;
    }

    @Override
    public SendMessage sendDefaultMessage(Update update) {
        return null;
    }
}
