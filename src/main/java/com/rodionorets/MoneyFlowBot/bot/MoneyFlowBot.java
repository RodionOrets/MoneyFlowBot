package com.rodionorets.MoneyFlowBot.bot;

import com.rodionorets.MoneyFlowBot.factory.MoneyFlowCommandProcessorProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class MoneyFlowBot extends TelegramLongPollingBot
{
    @Value("${bot.username}")
    private String botUsername;

    @Value("${bot.token}")
    private String botToken;

    @Autowired
    private MoneyFlowCommandProcessorProvider moneyFlowCommandProcessorProvider;

    @Override
    public String getBotUsername()
    {
        return botUsername;
    }

    @Override
    public String getBotToken()
    {
        return botToken;
    }

    @Override
    public void onUpdateReceived(Update update)
    {
        moneyFlowCommandProcessorProvider.getProcessor(update).process(update);
    }
}
