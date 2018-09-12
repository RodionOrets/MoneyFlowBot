package com.rodionorets.MoneyFlowBot.command.implementation.balance;

import com.rodionorets.MoneyFlowBot.command.MoneyFlowActionProcessor;
import com.rodionorets.MoneyFlowBot.domain.ActionTypes;
import com.rodionorets.MoneyFlowBot.repository.MoneyFlowActionsRepository;
import com.rodionorets.MoneyFlowBot.util.moneyflowbot.QueriesAndProcessorNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.api.methods.send.SendMessage;

@Service(QueriesAndProcessorNames.Balance.GET_BALANCE_ACTION_PROCESSOR_NAME)
public class GetBalanceActionProcessor extends MoneyFlowActionProcessor {

    private final MoneyFlowActionsRepository moneyFlowActionsRepository;

    @Autowired
    public GetBalanceActionProcessor(MoneyFlowActionsRepository moneyFlowActionsRepository) {
        this.moneyFlowActionsRepository = moneyFlowActionsRepository;
    }

    @Override
    public void process() {
        var telegramUserId = update.getInlineQuery().getFrom().getId();
        var userActions = moneyFlowActionsRepository.findAllByTelegramUserId(telegramUserId);

        var userBalance = userActions.stream()
                .filter(action -> action.getActionType().equals(ActionTypes.INCOME) || action.getActionType().equals(ActionTypes.EXPENSE))
                .mapToDouble(action -> action.getAmount().doubleValue())
                .sum();

        var userDebtsStream = userActions.stream()
                .filter(action -> action.getActionType().equals(ActionTypes.INCOMING_DEBT) || action.getActionType().equals(ActionTypes.OUTGOING_DEBT));

        var incomingDebtsSum = userDebtsStream
                .filter(action -> action.getActionType().equals(ActionTypes.INCOMING_DEBT))
                .mapToDouble(action -> action.getAmount().doubleValue())
                .sum();

        var outgoingDebtsSum = userDebtsStream
                .filter(action -> action.getActionType().equals(ActionTypes.OUTGOING_DEBT))
                .mapToDouble(action -> action.getAmount().doubleValue())
                .sum();

        String message =
                "Your total balance is: " + userBalance +
                "\nAmount of your incoming debts: " + incomingDebtsSum +
                "\nAmount of your outgoing debts: " + outgoingDebtsSum;

        SendMessage sendMessage = new SendMessage()
                .setText(message);

        executeApiMethod(sendMessage);
    }

}
