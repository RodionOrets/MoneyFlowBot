package com.rodionorets.MoneyFlowBot.command.implementation.expenses;

import com.rodionorets.MoneyFlowBot.command.MoneyFlowActionProcessor;
import com.rodionorets.MoneyFlowBot.util.QueriesAndProcessorNames;
import org.springframework.stereotype.Service;

@Service(QueriesAndProcessorNames.Expenses.ADD_EXPENSE_ACTION_PROCESSOR_NAME)
public class AddExpenseActionProcessor extends MoneyFlowActionProcessor {

    @Override
    public void process() {

    }

}