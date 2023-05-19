package com.example.spring_telegram_bot.Helpers;


import com.example.spring_telegram_bot.Models.PillsModel;
import com.example.spring_telegram_bot.Repos.PillsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;

@Component
public class PillsHelper {
    @Autowired
    PillsRepo pillsRepo;

    private static PillsHelper pillsHelper = null;


    public PillsHelper() {
        pillsHelper = this;

    }

    public static void save(PillsModel p) {
        pillsHelper.pillsRepo.save(p);
    }
    public static List<String> getFreetimes (PillsEnum ps){
        PillsTimeControl pillsTimeControl = new PillsTimeControl();
        List<PillsModel> pillsModelList = pillsHelper.pillsRepo.findPillsModelByPillsEnum(ps);
        List<String> freeTimes = new ArrayList<>();
        freeTimes = pillsTimeControl.getTime();

        List<String> list = new ArrayList<>();
        for (PillsModel pillsModel :pillsModelList){
            for (String str : freeTimes){
                if (pillsModel.getTimes().equals(str)){
                    list.add(pillsModel.getTimes());
                }
            }
        }
        freeTimes.remove(list);
        return freeTimes;
    }
}
