package com.rodionorets.MoneyFlowBot.command;

import com.rodionorets.MoneyFlowBot.repository.JpaActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.rodionorets.MoneyFlowBot.util.DateTimeUtil.toNiceTimestampString;

@Service
public class IncomesCommandProcessor implements TelegramUpdateProcessor<SendMessage>
{
    private JpaActionRepository actionRepository;

    @Autowired
    public IncomesCommandProcessor(JpaActionRepository actionRepository)
    {
        this.actionRepository = actionRepository;
    }

    @Override
    public SendMessage process(Update update)
    {
        var message = update.getMessage();

        var messageTextParts = message.getText().split(" ");

        var incomes = actionRepository.findByTelegramUserIdAndAction(message.getFrom().getId(), "INCOME");

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
            incomes.stream().filter(a -> a.getCategory().equals(messageTextParts[1]))
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
