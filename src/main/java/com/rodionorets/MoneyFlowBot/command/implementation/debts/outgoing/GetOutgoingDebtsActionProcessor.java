package com.rodionorets.MoneyFlowBot.command.implementation.debts.outgoing;

import com.rodionorets.MoneyFlowBot.command.MoneyFlowActionProcessor;
import com.rodionorets.MoneyFlowBot.util.QueriesAndProcessorNames;
import org.springframework.stereotype.Service;

@Service(QueriesAndProcessorNames.Debts.Outgoing.GET_OUTGOING_DEBTS_ACTION_PROCESSOR_NAME)
public class GetOutgoingDebtsActionProcessor extends MoneyFlowActionProcessor {

    @Override
    public void process() {

    }

}
