package com.rodionorets.MoneyFlowBot.command;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class HelpCommandProcessor implements TelegramUpdateProcessor<SendMessage>
{

    @Override
    public SendMessage process(Update update)
    {
        return null;
    }
}
