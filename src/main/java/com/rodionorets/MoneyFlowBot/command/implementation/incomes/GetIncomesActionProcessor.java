package com.rodionorets.MoneyFlowBot.command.implementation.incomes;

import com.rodionorets.MoneyFlowBot.command.MoneyFlowActionProcessor;
import com.rodionorets.MoneyFlowBot.domain.ActionTypes;
import com.rodionorets.MoneyFlowBot.repository.MoneyFlowActionsRepository;
import com.rodionorets.MoneyFlowBot.util.moneyflowbot.QueriesAndProcessorNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.api.methods.send.SendMessage;

import java.util.List;

@Service(QueriesAndProcessorNames.Incomes.GET_INCOMES_ACTION_PROCESSOR_NAME)
public class GetIncomesActionProcessor extends MoneyFlowActionProcessor {

    private MoneyFlowActionsRepository moneyFlowActionsRepository;

    @Autowired
    public GetIncomesActionProcessor(MoneyFlowActionsRepository moneyFlowActionsRepository) {
        this.moneyFlowActionsRepository = moneyFlowActionsRepository;
    }

    @Override
    public void process() {
        var telegramUserId = update.getInlineQuery().getFrom().getId();

        var totalUserIncomeAmount =
                moneyFlowActionsRepository.findAllByTelegramUserIdAndActions(telegramUserId, List.of(ActionTypes.INCOME))
                        .stream()
                        .mapToDouble(action -> action.getAmount().doubleValue())
                        .sum();

        String message = "Your total income amount is " + totalUserIncomeAmount;

        SendMessage sendMessage = new SendMessage().setText(message);

        executeApiMethod(sendMessage);
    }

}
