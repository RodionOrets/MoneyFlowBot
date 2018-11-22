package com.rodionorets.MoneyFlowBot.command.implementation;

import com.rodionorets.MoneyFlowBot.command.MoneyFlowActionProcessor;
import com.rodionorets.MoneyFlowBot.constants.QueriesAndProcessorNames;
import org.springframework.stereotype.Service;

@Service(QueriesAndProcessorNames.Debts.Outgoing.ADD_OUTGOING_DEBT_ACTION_PROCESSOR_NAME)
public class AddOutgoingDebtActionProcessor extends MoneyFlowActionProcessor {

    @Override
    public void process() {

    }

}
