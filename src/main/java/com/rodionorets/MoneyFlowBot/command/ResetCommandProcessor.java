package com.rodionorets.MoneyFlowBot.command;

import com.rodionorets.MoneyFlowBot.repository.JpaActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class ResetCommandProcessor implements TelegramUpdateProcessor
{
    private JpaActionRepository actionRepository;

    @Autowired
    public ResetCommandProcessor(JpaActionRepository actionRepository)
    {
        this.actionRepository = actionRepository;
    }

    @Override
    public BotApiMethod process(Update update)
    {
        var from = update.getMessage().getFrom();

        actionRepository.deleteAllByTelegramUserId(from.getId());

        return new SendMessage()
            .setChatId(update.getMessage().getChatId())
            .setText("All done, " + from.getFirstName() + ". Your history has been reset");
    }
}
