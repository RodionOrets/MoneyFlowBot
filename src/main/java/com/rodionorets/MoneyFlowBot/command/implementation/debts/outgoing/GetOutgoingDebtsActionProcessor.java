package com.rodionorets.MoneyFlowBot.command.implementation.debts.outgoing;

import com.rodionorets.MoneyFlowBot.command.MoneyFlowActionProcessor;
import com.rodionorets.MoneyFlowBot.domain.ActionTypes;
import com.rodionorets.MoneyFlowBot.repository.MoneyFlowActionsRepository;
import com.rodionorets.MoneyFlowBot.util.moneyflowbot.QueriesAndProcessorNames;
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

        var totalIncomingDebtsAmount =
                moneyFlowActionsRepository.findAllByTelegramUserIdAndActions(telegramUserId, List.of(ActionTypes.OUTGOING_DEBT))
                        .stream()
                        .mapToDouble(action -> action.getAmount().doubleValue())
                        .sum();

        var message = "Your total amount of outgoing debts is: " + totalIncomingDebtsAmount;

        var sendMessage = new SendMessage().setText(message);

        executeApiMethod(sendMessage);
    }

}
