package com.rodionorets.MoneyFlowBot.command;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.Serializable;

public interface TelegramUpdateProcessor
{
    <T extends Serializable> BotApiMethod<T> process(Update update);
}
