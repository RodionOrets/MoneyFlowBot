package com.rodionorets.MoneyFlowBot.bot;

import com.rodionorets.MoneyFlowBot.factory.MoneyFlowActionProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

@Component("moneyFlowBot")
public class MoneyFlowBot extends TelegramLongPollingBot {

    @Autowired
    @Qualifier("moneyFlowActionProvider")
    private MoneyFlowActionProvider moneyFlowActionProvider;

    @Value("${bot.username}")
    private String botUsername;

    @Value("${bot.token}")
    private String botToken;

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public void onUpdateReceived(Update update) {
        moneyFlowActionProvider.getCommand(update).process();
    }
}
