package com.rodionorets.MoneyFlowBot.util.moneyflowbot;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component("processorNameResolver")
public class ProcessorNameResolver
{

    private final Map<String, String> commandProcessors = Map
            .of(
                "/start", "startCommandProcessor",
                "/help", "helpCommandProcessor",
                "/income", "incomeCommandProcessor",
                "/expense", "expenseCommandProcessor",
                "/incomes", "incomesCommandProcessor",
                "/expenses", "expenseCommandProcessor",
                "/balance", "balanceCommandProcessor"
            );

    public String resolveForCommand(String command)
    {
        return commandProcessors.get(command);
    }
}
