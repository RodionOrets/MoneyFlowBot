package com.rodionorets.MoneyFlowBot.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

import com.rodionorets.MoneyFlowBot.command.TelegramUpdateProcessor;
import com.rodionorets.MoneyFlowBot.util.ProcessorNameResolver;


@Component
public class UpdateProcessorProvider
{
    private final ApplicationContext applicationContext;

    private final ProcessorNameResolver processorNameResolver;

    @Autowired
    public UpdateProcessorProvider(
            ApplicationContext applicationContext,
            ProcessorNameResolver processorNameResolver)
    {
        this.applicationContext = applicationContext;
        this.processorNameResolver = processorNameResolver;
    }

    public TelegramUpdateProcessor getForUpdate(Update update)
    {
        String processorName;
        if (updateIsCommand(update))
        {
            var command = update.getMessage().getText().split(" ")[0];
            processorName = processorNameResolver.resolveForCommand(command);
        }
        else if (updateIsCallbackQuery(update))
        {
            processorName = processorNameResolver.resolveForCallbackData(update.getCallbackQuery().getData());
        }
        else
        {
            throw new UnsupportedOperationException();
        }

        return TelegramUpdateProcessor.class
            .cast(applicationContext.getAutowireCapableBeanFactory().getBean(processorName));
    }

    private boolean updateIsCommand(Update update)
    {
        return update.hasMessage() && update.getMessage().isCommand();
    }

    private boolean updateIsCallbackQuery(Update update)
    {
        return update.hasCallbackQuery();
    }
}
