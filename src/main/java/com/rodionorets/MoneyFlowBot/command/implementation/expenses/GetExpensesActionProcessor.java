package com.rodionorets.MoneyFlowBot.command.implementation.expenses;

import com.rodionorets.MoneyFlowBot.command.MoneyFlowActionProcessor;
import com.rodionorets.MoneyFlowBot.domain.ActionTypes;
import com.rodionorets.MoneyFlowBot.repository.MoneyFlowActionsRepository;
import com.rodionorets.MoneyFlowBot.util.moneyflowbot.QueriesAndProcessorNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.api.methods.send.SendMessage;

import java.util.List;

@Service(QueriesAndProcessorNames.Expenses.GET_EXPENSES_ACTION_PROCESSOR_NAME)
public class GetExpensesActionProcessor extends MoneyFlowActionProcessor {

    private MoneyFlowActionsRepository moneyFlowActionsRepository;

    @Autowired
    public GetExpensesActionProcessor(MoneyFlowActionsRepository moneyFlowActionsRepository) {
        this.moneyFlowActionsRepository = moneyFlowActionsRepository;
    }

    @Override
    public void process() {
        var telegramUserId = update.getInlineQuery().getFrom().getId();

        var totalUserExpensesAmount =
                moneyFlowActionsRepository.findAllByTelegramUserIdAndActions(telegramUserId, List.of(ActionTypes.EXPENSE))
                        .stream()
                        .mapToDouble(action -> action.getAmount().doubleValue())
                        .sum();

        String message = "Your total income amount is " + totalUserExpensesAmount;

        SendMessage sendMessage = new SendMessage().setText(message);

        executeApiMethod(sendMessage);
    }

}
