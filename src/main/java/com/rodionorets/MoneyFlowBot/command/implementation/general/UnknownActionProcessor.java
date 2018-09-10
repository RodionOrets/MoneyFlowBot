package com.rodionorets.MoneyFlowBot.command.implementation.general;

import com.rodionorets.MoneyFlowBot.command.MoneyFlowActionProcessor;
import com.rodionorets.MoneyFlowBot.util.moneyflowbot.QueriesAndProcessorNames;
import org.springframework.stereotype.Service;

@Service(QueriesAndProcessorNames.General.UNKNOWN_ACTION_PROCESSOR_NAME)
public class UnknownActionProcessor extends MoneyFlowActionProcessor {

    @Override
    public void process() {

    }
}
