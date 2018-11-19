package com.rodionorets.MoneyFlowBot.command.implementation.debts.incoming;

import com.rodionorets.MoneyFlowBot.command.MoneyFlowActionProcessor;
import com.rodionorets.MoneyFlowBot.constants.application.QueriesAndProcessorNames;
import org.springframework.stereotype.Service;

@Service(QueriesAndProcessorNames.Debts.Incoming.ADD_INCOMING_DEBT_ACTION_PROCESSOR_NAME)
public class AddIncomingDebtActionProcessor extends MoneyFlowActionProcessor {

    @Override
    public void process() {

    }

}
