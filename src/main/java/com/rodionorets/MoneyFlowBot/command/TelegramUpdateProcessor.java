package com.rodionorets.MoneyFlowBot.command;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface TelegramUpdateProcessor
{
    void process(Update update);
}
