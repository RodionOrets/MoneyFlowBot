package com.rodionorets.MoneyFlowBot.util.telegram;

import com.rodionorets.MoneyFlowBot.bot.MoneyFlowBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.Serializable;

@Service
public class ApiMethodExecutor
{
    private final MoneyFlowBot moneyFlowBot;

    @Autowired
    public ApiMethodExecutor(MoneyFlowBot moneyFlowBot)
    {
        this.moneyFlowBot = moneyFlowBot;
    }

    public <T extends Serializable, ApiMethod extends BotApiMethod<T>> T executeApiMethod(ApiMethod apiMethod)
    {
        try
        {
            return moneyFlowBot.execute(apiMethod);
        }
        catch (TelegramApiException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
