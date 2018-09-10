package com.rodionorets.MoneyFlowBot.command.implementation.incomes;

import com.rodionorets.MoneyFlowBot.command.MoneyFlowActionProcessor;
import com.rodionorets.MoneyFlowBot.domain.ActionTypes;
import com.rodionorets.MoneyFlowBot.domain.MoneyFlowAction;
import com.rodionorets.MoneyFlowBot.repository.MoneyFlowActionsRepository;
import com.rodionorets.MoneyFlowBot.util.QueriesAndProcessorNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.api.methods.send.SendMessage;

import java.math.BigDecimal;

@Service(QueriesAndProcessorNames.Incomes.GET_INCOMES_ACTION_PROCESSOR_NAME)
public class GetIncomesActionProcessor extends MoneyFlowActionProcessor {

    private MoneyFlowActionsRepository moneyFlowActionsRepository;

    @Autowired
    public GetIncomesActionProcessor(MoneyFlowActionsRepository moneyFlowActionsRepository) {
        this.moneyFlowActionsRepository = moneyFlowActionsRepository;
    }

    @Override
    public void process() {
        var update = getUpdate();
        var telegramUserId = update.getInlineQuery().getFrom().getId();
        var userActions = moneyFlowActionsRepository.findAllByTelegramUserId(telegramUserId);

        var totalUserIncomeAmount = userActions.stream()
                .filter(action -> action.getActionType().equals(ActionTypes.INCOME))
                .mapToDouble(action -> action.getAmount().doubleValue())
                .sum();

        String message = "Your total income amount is " + totalUserIncomeAmount;

        SendMessage sendMessage = new SendMessage().setText(message);

        executeApiMethod(sendMessage);
    }

}
