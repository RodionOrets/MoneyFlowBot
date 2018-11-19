package com.rodionorets.MoneyFlowBot.bot;

import com.rodionorets.MoneyFlowBot.command.MoneyFlowActionProcessor;
import com.rodionorets.MoneyFlowBot.factory.MoneyFlowActionProcessorProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

@Component("moneyFlowBot")
public class MoneyFlowBot extends TelegramLongPollingBot {

    private final String botUsername;

    private final String botToken;

    private final MoneyFlowActionProcessorProvider moneyFlowActionProcessorProvider;

    @Autowired
    public MoneyFlowBot(
            @Value("${bot.username}") String botUsername,
            @Value("${bot.token}") String botToken,
            @Qualifier("moneyFlowActionProvider") MoneyFlowActionProcessorProvider moneyFlowActionProcessorProvider) {
        this.botUsername = botUsername;
        this.botToken = botToken;
        this.moneyFlowActionProcessorProvider = moneyFlowActionProcessorProvider;
    }

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
        var processor = moneyFlowActionProcessorProvider.getProcessor(update);
        processor.process();
    }
}
