package com.rodionorets.MoneyFlowBot.command;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class StartCommandProcessor implements TelegramUpdateProcessor<SendMessage>
{
    @Override
    public SendMessage process(Update update)
    {
        var user = update.getMessage().getFrom();

        String startCommandAnswerMessage =
                "Hi " + user.getFirstName() + "!\n" +
                        "I'm Money Flow Bot. I can record your incomes and expenses.\n" +
                        "At the moment you can use following commands:\n" +
                        "/income - to save your new income.\n " +
                        "Please use it in form of: /income {amount} {category}\n " +
                        "Example: /income 80000 Salary\n" +
                        "/expense - to save your new expense.\n" +
                        "Please use it in form of: /expense {amount} {category}\n" +
                        "Example: /expense 8000 Education\n";

        return new SendMessage()
                .setChatId(update.getMessage().getChatId())
                .setParseMode("markdown")
                .setText(startCommandAnswerMessage);
    }
}
