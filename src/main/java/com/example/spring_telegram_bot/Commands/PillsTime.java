package com.example.spring_telegram_bot.Commands;


import com.example.spring_telegram_bot.Helpers.PillsHelper;
import com.example.spring_telegram_bot.Helpers.PillsTimeControl;
import com.example.spring_telegram_bot.Helpers.UserHelper;
import com.example.spring_telegram_bot.Models.PillsModel;
import com.example.spring_telegram_bot.Models.UserModel;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

@Component
public class PillsTime implements WorKerCommand {
    @Override
    public SendMessage start(Update updata) {
        PillsTimeControl pillsTimeControl = new PillsTimeControl();
        List<String> list = pillsTimeControl.getTime();
        boolean ifThisCommand = false;
        for (String str: list){
            if (updata.getMessage().getText().equals(str)){
                ifThisCommand = true;
            }
        }
        if (ifThisCommand){
            return null;
        }
        PillsModel pillsModel = new PillsModel();
        pillsModel.setTimes(updata.getMessage().getText().toString());

        UserModel userModel ;
        userModel = UserHelper.findUser(updata.getMessage().getFrom().getId().toString());

        pillsModel.setTelegramId(updata.getMessage().getFrom().getId().toString());
        pillsModel.setPillsEnum(userModel.getPillsEnum());

        PillsHelper.save(pillsModel);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(updata.getMessage().getChatId().toString());
        sendMessage.setText("Вы успешно подали заявку на выписку рецепта");
        return sendMessage;
    }

    @Override
    public SendMessage sendDefaultMessage(Update update) {
        return null;
    }
}

