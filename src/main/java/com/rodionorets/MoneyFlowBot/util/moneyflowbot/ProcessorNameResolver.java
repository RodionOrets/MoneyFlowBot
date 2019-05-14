package com.rodionorets.MoneyFlowBot.util.moneyflowbot;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component("processorNameResolver")
public class ProcessorNameResolver
{

    private final Map<String, String> commandProcessors = Map
            .of(
                    "/start", "startCommandProcessor"
            );

    private final Map<String, String> callbackQueryProcessors = Map.of();

    public String resolveForCommand(String command)
    {
        return commandProcessors.get(command);
    }

    public String resolveForCallbackQuery(String callbackQuery)
    {
        return callbackQueryProcessors.get(callbackQuery);
    }

}
