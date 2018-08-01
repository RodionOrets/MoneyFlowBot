package com.rodionorets.MoneyFlowBot.command.implementation.incomes;

import com.rodionorets.MoneyFlowBot.command.MoneyFlowActionProcessor;
import com.rodionorets.MoneyFlowBot.util.QueriesAndProcessorNames;
import org.springframework.stereotype.Service;

@Service(QueriesAndProcessorNames.Incomes.GET_INCOMES_ACTION_PROCESSOR_NAME)
public class GetIncomesActionProcessor extends MoneyFlowActionProcessor {

    @Override
    public void process() {

    }

}
