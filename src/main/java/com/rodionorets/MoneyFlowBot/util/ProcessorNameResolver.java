package com.rodionorets.MoneyFlowBot.util;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;

@Component
public class ProcessorNameResolver
{
    private final Map<String, String> commandProcessors = Collections.unmodifiableMap(Map
        .of(
            "/start", "startCommandProcessor",
            "/help", "helpCommandProcessor",
            "/income", "incomeCommandProcessor",
            "/expense", "expenseCommandProcessor",
            "/incomes", "incomesCommandProcessor",
            "/expenses", "expensesCommandProcessor",
            "/balance", "balanceCommandProcessor",
            "/reset", "resetCommandProcessor"
        ));

    private final Map<String, String> callbackDataProcessors = Collections.unmodifiableMap(Map
        .of(

        ));

    public String resolveForCommand(String command)
    {
        return commandProcessors.get(command);
    }

    public String resolveForCallbackData(String callbackData)
    {
        return callbackDataProcessors.get(callbackData);
    }
}
