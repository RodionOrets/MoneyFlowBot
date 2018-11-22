package com.rodionorets.MoneyFlowBot.command.implementation;

import com.rodionorets.MoneyFlowBot.command.MoneyFlowActionProcessor;
import com.rodionorets.MoneyFlowBot.constants.QueriesAndProcessorNames;
import org.springframework.stereotype.Service;

@Service(QueriesAndProcessorNames.Incomes.ADD_INCOME_ACTION_PROCESSOR_NAME)
public class AddIncomeActionProcessor extends MoneyFlowActionProcessor {

    @Override
    public void process() {

    }

}
