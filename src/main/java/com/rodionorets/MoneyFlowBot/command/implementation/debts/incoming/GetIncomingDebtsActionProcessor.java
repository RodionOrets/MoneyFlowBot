package com.rodionorets.MoneyFlowBot.command.implementation.debts.incoming;

import com.rodionorets.MoneyFlowBot.command.MoneyFlowActionProcessor;
import com.rodionorets.MoneyFlowBot.domain.ActionTypes;
import com.rodionorets.MoneyFlowBot.repository.MoneyFlowActionsRepository;
import com.rodionorets.MoneyFlowBot.util.moneyflowbot.MoneyFlowActionsTotalAmountCalculator;
import com.rodionorets.MoneyFlowBot.util.moneyflowbot.QueriesAndProcessorNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.api.methods.send.SendMessage;

import java.util.List;

@Service(QueriesAndProcessorNames.Debts.Incoming.GET_INCOMING_DEBTS_ACTION_PROCESSOR_NAME)
public class GetIncomingDebtsActionProcessor extends MoneyFlowActionProcessor {

    private MoneyFlowActionsRepository moneyFlowActionsRepository;

    @Autowired
    public GetIncomingDebtsActionProcessor(MoneyFlowActionsRepository moneyFlowActionsRepository) {
        this.moneyFlowActionsRepository = moneyFlowActionsRepository;
    }

    @Override
    public void process() {
        var telegramUserId = update.getInlineQuery().getFrom().getId();

        var incomingDebts = moneyFlowActionsRepository.findAllByTelegramUserIdAndActions(telegramUserId, List.of(ActionTypes.INCOMING_DEBT));

        var totalIncomingDebtsAmount = MoneyFlowActionsTotalAmountCalculator.calculateTotalAmount(incomingDebts);

        var message = "Your total amount of incoming debts is: " + totalIncomingDebtsAmount;

        var sendMessage = new SendMessage().setText(message);

        executeApiMethod(sendMessage);
    }

}
