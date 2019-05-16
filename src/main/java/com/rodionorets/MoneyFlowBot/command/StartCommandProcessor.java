package com.rodionorets.MoneyFlowBot.command;

import com.rodionorets.MoneyFlowBot.util.HelpMessages;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;

@Service
public class StartCommandProcessor implements TelegramUpdateProcessor<SendMessage>
{
    @Override
    public SendMessage process(Update update)
    {
        User user = update.getMessage().getFrom();

        return new SendMessage()
            .setChatId(update.getMessage().getChatId())
            .setParseMode("markdown")
            .setText(HelpMessages.startMessageFor(user));
    }
}
