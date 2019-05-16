package com.rodionorets.MoneyFlowBot.util;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class ProcessorNameResolver
{
    private final Map<String, String> commandProcessors = Stream
            .of(new String[][]{
                    {"/start", "startCommandProcessor"},
                    {"/help", "helpCommandProcessor"},
                    {"/income", "incomeCommandProcessor"},
                    {"/expense", "expenseCommandProcessor"},
                    {"/incomes", "incomesCommandProcessor"},
                    {"/expenses", "expensesCommandProcessor"},
                    {"/balance", "balanceCommandProcessor"},
                    {"/reset", "resetCommandProcessor"}})
            .collect(Collectors.toMap(d -> d[0], d -> d[1]));

    private final Map<String, String> callbackDataProcessors = new HashMap<>();

    public String resolveForCommand(String command)
    {
        return commandProcessors.get(command);
    }

    public String resolveForCallbackData(String callbackData)
    {
        return callbackDataProcessors.get(callbackData);
    }
}
