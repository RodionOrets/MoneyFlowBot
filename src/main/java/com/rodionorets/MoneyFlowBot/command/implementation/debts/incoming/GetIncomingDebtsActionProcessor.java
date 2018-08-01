package com.rodionorets.MoneyFlowBot.command.implementation.debts.incoming;

import com.rodionorets.MoneyFlowBot.command.MoneyFlowActionProcessor;
import com.rodionorets.MoneyFlowBot.util.QueriesAndProcessorNames;
import org.springframework.stereotype.Service;

@Service(QueriesAndProcessorNames.Debts.Incoming.GET_INCOMING_DEBTS_ACTION_PROCESSOR_NAME)
public class GetIncomingDebtsActionProcessor extends MoneyFlowActionProcessor {

    @Override
    public void process() {

    }

}
