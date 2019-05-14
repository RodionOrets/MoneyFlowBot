package com.rodionorets.MoneyFlowBot.command;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.Serializable;

@Service
public class IncomesCommandProcessor implements TelegramUpdateProcessor
{
    @Override
    public <T extends Serializable> BotApiMethod<T> process(Update update)
    {
        return null;
    }
}
