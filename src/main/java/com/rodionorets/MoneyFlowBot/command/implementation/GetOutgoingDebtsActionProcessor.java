package com.rodionorets.MoneyFlowBot.command.implementation;

import com.rodionorets.MoneyFlowBot.command.MoneyFlowActionProcessor;
import com.rodionorets.MoneyFlowBot.constants.MoneyFlowActionTypeStrings;
import com.rodionorets.MoneyFlowBot.repository.MoneyFlowActionsRepository;
import com.rodionorets.MoneyFlowBot.util.moneyflowbot.MoneyFlowActionsTotalAmountCalculator;
import com.rodionorets.MoneyFlowBot.constants.QueriesAndProcessorNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.api.methods.send.SendMessage;

import java.util.List;

@Service(QueriesAndProcessorNames.Debts.Outgoing.GET_OUTGOING_DEBTS_ACTION_PROCESSOR_NAME)
public class GetOutgoingDebtsActionProcessor extends MoneyFlowActionProcessor {

    private MoneyFlowActionsRepository moneyFlowActionsRepository;

    @Autowired
    public GetOutgoingDebtsActionProcessor(MoneyFlowActionsRepository moneyFlowActionsRepository) {
        this.moneyFlowActionsRepository = moneyFlowActionsRepository;
    }

    @Override
    public void process() {
        var telegramUserId = update.getInlineQuery().getFrom().getId();

        var outgoingDebts = moneyFlowActionsRepository.findAllByTelegramUserIdAndActions(telegramUserId, List.of(MoneyFlowActionTypeStrings.OUTGOING_DEBT));

        var totalOutgoingDebtsAmount = MoneyFlowActionsTotalAmountCalculator.calculateTotalAmount(outgoingDebts);

        var message = "Your total amount of outgoing debts is: " + totalOutgoingDebtsAmount;

        var sendMessage = new SendMessage().setText(message);

        executeApiMethod(sendMessage);
    }

}
