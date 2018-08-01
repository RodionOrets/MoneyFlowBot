package com.rodionorets.MoneyFlowBot.command.implementation.balance;

import com.rodionorets.MoneyFlowBot.command.MoneyFlowActionProcessor;
import com.rodionorets.MoneyFlowBot.util.QueriesAndProcessorNames;
import org.springframework.stereotype.Service;

@Service(QueriesAndProcessorNames.Balance.GET_BALANCE_ACTION_PROCESSOR_NAME)
public class GetBalanceActionProcessor extends MoneyFlowActionProcessor {

    @Override
    public void process() {

    }

}
