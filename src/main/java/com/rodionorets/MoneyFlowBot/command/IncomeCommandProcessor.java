package com.rodionorets.MoneyFlowBot.command;

import com.rodionorets.MoneyFlowBot.model.MoneyFlowAction;
import com.rodionorets.MoneyFlowBot.repository.JpaActionRepository;
import com.rodionorets.MoneyFlowBot.util.HelpMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class IncomeCommandProcessor implements TelegramUpdateProcessor<SendMessage>
{
    private JpaActionRepository actionRepository;

    @Autowired
    public IncomeCommandProcessor(JpaActionRepository actionRepository)
    {
        this.actionRepository = actionRepository;
    }

    @Override
    public SendMessage process(Update update)
    {
        Message message = update.getMessage();

        String[] messageTextParts = message.getText().split(" ");

        if (messageTextParts.length == 1)
        {
            return new SendMessage().setChatId(message.getChatId()).setText(HelpMessages.INCOME_HELP_MESSAGE);
        }

        BigDecimal amount = BigDecimal.valueOf(Double.valueOf(messageTextParts[1]));

        MoneyFlowAction action = new MoneyFlowAction(message.getFrom().getId(), amount, "INCOME", messageTextParts[2], LocalDateTime.now());

        actionRepository.save(action);

        return new SendMessage().setChatId(message.getChatId()).setText("Your income has been logged.");
    }
}
