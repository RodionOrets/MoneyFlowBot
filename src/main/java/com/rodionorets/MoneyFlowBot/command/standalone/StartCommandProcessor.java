package com.rodionorets.MoneyFlowBot.command.standalone;

import com.rodionorets.MoneyFlowBot.command.StandaloneUpdateProcessor;
import com.rodionorets.MoneyFlowBot.util.telegram.ApiMethodExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class StartCommandProcessor implements StandaloneUpdateProcessor
{
    private ApiMethodExecutor apiMethodExecutor;

    @Autowired
    public StartCommandProcessor(ApiMethodExecutor apiMethodExecutor)
    {
        this.apiMethodExecutor = apiMethodExecutor;
    }

    @Override
    public void process(Update update)
    {

    }
}
