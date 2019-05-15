package com.rodionorets.MoneyFlowBot.command;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface TelegramUpdateProcessor<T extends BotApiMethod>
{
    T process(Update update);
}
