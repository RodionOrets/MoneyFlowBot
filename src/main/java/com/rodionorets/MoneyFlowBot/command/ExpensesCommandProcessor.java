package com.rodionorets.MoneyFlowBot.command;

import com.rodionorets.MoneyFlowBot.repository.ActionRepositoryStub;
import com.rodionorets.MoneyFlowBot.util.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.time.LocalDateTime;

import static com.rodionorets.MoneyFlowBot.util.DateTimeUtil.toNiceTimestampString;

@Service
public class ExpensesCommandProcessor implements TelegramUpdateProcessor<SendMessage>
{
    private ActionRepositoryStub repositoryStub;

    @Autowired
    public ExpensesCommandProcessor(ActionRepositoryStub repositoryStub)
    {
        this.repositoryStub = repositoryStub;
    }

    public SendMessage process(Update update)
    {
        var message = update.getMessage();

        var messageTextParts = message.getText().split(" ");

        var incomes = repositoryStub.getActions(message.getFrom().getId())
                .stream()
                .filter(a -> a.getAction().equals("EXPENSE"));

        var answerMessageText = new StringBuilder();
        if (messageTextParts.length == 1)
        {
            incomes.forEach(a ->
                    answerMessageText
                            .append(toNiceTimestampString(a.getTimestamp()))
                            .append(" : ")
                            .append(a.getAmount())
                            .append(" : ")
                            .append(a.getCategory())
                            .append("\n"));
        }
        else
        {
            incomes.filter(a -> a.getCategory().equals(messageTextParts[1]))
                    .forEach(a ->
                            answerMessageText
                                    .append(toNiceTimestampString(a.getTimestamp()))
                                    .append(" : ")
                                    .append(a.getAmount())
                                    .append("\n"));
        }

        return new SendMessage().setChatId(message.getChatId()).setText(answerMessageText.toString());
    }
}
