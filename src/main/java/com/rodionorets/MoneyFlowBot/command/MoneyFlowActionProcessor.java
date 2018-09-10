package com.rodionorets.MoneyFlowBot.command;

import com.rodionorets.MoneyFlowBot.bot.MoneyFlowBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.telegram.telegrambots.api.methods.BotApiMethod;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.io.Serializable;

// TODO(4): Consider processing not telegram.Update object but custom wrapper
public abstract class MoneyFlowActionProcessor {

    @Autowired
    @Qualifier("moneyFlowBot")
    private MoneyFlowBot moneyFlowBot;

    private Update update;

    public void setUpdate(Update update) {
        this.update = update;
    }

    protected Update getUpdate() {
        return update;
    }

    public abstract void process();

    protected <T extends Serializable, ApiMethod extends BotApiMethod<T>> void executeApiMethod(ApiMethod apiMethod) {
        try {
            moneyFlowBot.execute(apiMethod);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}
