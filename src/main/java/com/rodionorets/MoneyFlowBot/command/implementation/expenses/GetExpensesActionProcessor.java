package com.rodionorets.MoneyFlowBot.command.implementation.expenses;

import com.rodionorets.MoneyFlowBot.command.MoneyFlowActionProcessor;
import com.rodionorets.MoneyFlowBot.util.QueriesAndProcessorNames;
import org.springframework.stereotype.Service;

@Service(QueriesAndProcessorNames.Expenses.GET_EXPENSES_ACTION_PROCESSOR_NAME)
public class GetExpensesActionProcessor extends MoneyFlowActionProcessor {

    @Override
    public void process() {

    }

}
