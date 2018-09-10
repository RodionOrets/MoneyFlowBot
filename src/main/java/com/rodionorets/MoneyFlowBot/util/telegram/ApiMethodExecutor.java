package com.rodionorets.MoneyFlowBot.util.telegram;

import com.rodionorets.MoneyFlowBot.bot.MoneyFlowBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.api.methods.BotApiMethod;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.io.Serializable;

@Service("apiMethodExecutor")
public class ApiMethodExecutor {

    private final MoneyFlowBot moneyFlowBot;

    @Autowired
    public ApiMethodExecutor(@Qualifier("moneyFlowBot") MoneyFlowBot moneyFlowBot) {
        this.moneyFlowBot = moneyFlowBot;
    }

    public <T extends Serializable, ApiMethod extends BotApiMethod<T>> void executeApiMethod(ApiMethod apiMethod) {
        try {
            moneyFlowBot.execute(apiMethod);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
