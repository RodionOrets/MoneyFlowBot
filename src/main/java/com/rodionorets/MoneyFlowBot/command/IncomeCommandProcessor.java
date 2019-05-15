package com.rodionorets.MoneyFlowBot.command;

import com.rodionorets.MoneyFlowBot.model.MoneyFlowAction;
import com.rodionorets.MoneyFlowBot.repository.ActionRepositoryStub;
import com.rodionorets.MoneyFlowBot.util.HelpMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class IncomeCommandProcessor implements TelegramUpdateProcessor<SendMessage>
{
    private ActionRepositoryStub repositoryStub;

    @Autowired
    public IncomeCommandProcessor(ActionRepositoryStub repositoryStub)
    {
        this.repositoryStub = repositoryStub;
    }

    @Override
    public SendMessage process(Update update)
    {
        var message = update.getMessage();

        var messageTextParts = message.getText().split(" ");

        if (messageTextParts.length == 1)
        {
            return new SendMessage().setChatId(message.getChatId()).setText(HelpMessages.INCOME_HELP_MESSAGE);
        }

        var amount = BigDecimal.valueOf(Double.valueOf(messageTextParts[1]));

        var action = new MoneyFlowAction(message.getFrom().getId(), amount, "INCOME", messageTextParts[2], LocalDateTime.now());

        repositoryStub.addAction(action);

        return new SendMessage().setChatId(message.getChatId()).setText("Recorded");
    }
}
