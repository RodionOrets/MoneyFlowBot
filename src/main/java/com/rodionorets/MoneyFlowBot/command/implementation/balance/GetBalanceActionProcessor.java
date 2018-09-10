package com.rodionorets.MoneyFlowBot.command.implementation.balance;

import com.rodionorets.MoneyFlowBot.command.MoneyFlowActionProcessor;
import com.rodionorets.MoneyFlowBot.domain.ActionTypes;
import com.rodionorets.MoneyFlowBot.domain.MoneyFlowAction;
import com.rodionorets.MoneyFlowBot.repository.MoneyFlowActionsRepository;
import com.rodionorets.MoneyFlowBot.util.QueriesAndProcessorNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;

import java.math.BigDecimal;
import java.util.Collection;

@Service(QueriesAndProcessorNames.Balance.GET_BALANCE_ACTION_PROCESSOR_NAME)
public class GetBalanceActionProcessor extends MoneyFlowActionProcessor {

    @Autowired
    private MoneyFlowActionsRepository moneyFlowActionsRepository;

    @Override
    public void process() {
        var update = getUpdate();
        var telegramUserId = update.getInlineQuery().getFrom().getId();
        var userActions = moneyFlowActionsRepository.findAllByTelegramUserId(telegramUserId);

        var userBalance = userActions.stream()
                .filter(action -> action.getActionType().equals(ActionTypes.INCOME) || action.getActionType().equals(ActionTypes.EXPENSE))
                .map(MoneyFlowAction::getAmount)
                .mapToDouble(BigDecimal::doubleValue)
                .sum();

        String message = "Your balance is " + userBalance;

        SendMessage sendMessage = new SendMessage()
                .setText(message);

        executeApiMethod(sendMessage);
    }

}
