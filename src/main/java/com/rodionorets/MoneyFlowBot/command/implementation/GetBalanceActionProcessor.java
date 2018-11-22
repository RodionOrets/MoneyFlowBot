package com.rodionorets.MoneyFlowBot.command.implementation;

import com.rodionorets.MoneyFlowBot.command.MoneyFlowActionProcessor;
import com.rodionorets.MoneyFlowBot.constants.MoneyFlowActionTypeStrings;
import com.rodionorets.MoneyFlowBot.entity.MoneyFlowAction;
import com.rodionorets.MoneyFlowBot.repository.MoneyFlowActionsRepository;
import com.rodionorets.MoneyFlowBot.constants.QueriesAndProcessorNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.api.methods.send.SendMessage;

import java.math.BigDecimal;

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

        var actions = moneyFlowActionsRepository.findAllByTelegramUserId(telegramUserId);

        BigDecimal balance = BigDecimal.ZERO;
        BigDecimal incomingDebts = BigDecimal.ZERO;
        BigDecimal outgoingDebts = BigDecimal.ZERO;

        for (MoneyFlowAction action : actions) {
            String actionType = action.getActionType();

            switch (actionType) {
                case MoneyFlowActionTypeStrings.INCOME:
                case MoneyFlowActionTypeStrings.EXPENSE:
                    balance = balance.add(action.getAmount());
                    break;
                case MoneyFlowActionTypeStrings.INCOMING_DEBT:
                    incomingDebts = incomingDebts.add(action.getAmount());
                    break;
                case MoneyFlowActionTypeStrings.OUTGOING_DEBT:
                    outgoingDebts = outgoingDebts.add(action.getAmount());
                    break;
            }
        }

        String message =
                "Your total balance is: " + balance +
                "\nAmount of your incoming debts: " + incomingDebts +
                "\nAmount of your outgoing debts: " + outgoingDebts;

        SendMessage sendMessage = new SendMessage().setText(message);

        executeApiMethod(sendMessage);
    }

}
