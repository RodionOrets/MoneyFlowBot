package com.rodionorets.MoneyFlowBot.bot;

import com.rodionorets.MoneyFlowBot.factory.UpdateProcessorProvider;
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

    private UpdateProcessorProvider updateProcessorProvider;

    @Autowired
    public MoneyFlowBot(UpdateProcessorProvider updateProcessorProvider)
    {
        this.updateProcessorProvider = updateProcessorProvider;
    }

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
        updateProcessorProvider.getProcessor(update).process(update);
    }
}
