package com.rodionorets.MoneyFlowBot.factory;

import com.rodionorets.MoneyFlowBot.command.StandaloneUpdateProcessor;
import com.rodionorets.MoneyFlowBot.util.moneyflowbot.ProcessorNameResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class MoneyFlowCommandProcessorProvider
{

    private final ApplicationContext applicationContext;

    private final ProcessorNameResolver processorNameResolver;

    @Autowired
    public MoneyFlowCommandProcessorProvider(
            ApplicationContext applicationContext,
            ProcessorNameResolver processorNameResolver)
    {
        this.applicationContext = applicationContext;
        this.processorNameResolver = processorNameResolver;
    }

    public StandaloneUpdateProcessor getProcessor(Update update)
    {
        StandaloneUpdateProcessor processor;

        if (update.hasMessage())
        {
            processor = getProcessorForUpdateWithMessage(update.getMessage());
        }
        else if (update.hasCallbackQuery())
        {
            processor = getProcessorForUpdateWithCallbackQuery(update.getCallbackQuery());
        }
        else
        {
            throw new RuntimeException();
        }

        return processor;
    }

    private StandaloneUpdateProcessor getProcessorForUpdateWithCallbackQuery(CallbackQuery callbackQuery)
    {
        return getBeanFromContext(processorNameResolver.resolveForCallbackQuery(callbackQuery.getId()));
    }

    private StandaloneUpdateProcessor getProcessorForUpdateWithMessage(Message message)
    {
        return getBeanFromContext(processorNameResolver.resolveForCommand(message.getText()));
    }

    private StandaloneUpdateProcessor getBeanFromContext(String beanName)
    {
        return StandaloneUpdateProcessor.class
                .cast(applicationContext.getAutowireCapableBeanFactory().getBean(beanName));
    }
}
