package com.rodionorets.MoneyFlowBot.factory;

import com.rodionorets.MoneyFlowBot.cache.ApplicationCache;
import com.rodionorets.MoneyFlowBot.constants.application.BeanNames;
import com.rodionorets.MoneyFlowBot.constants.application.ProcessorType;
import com.rodionorets.MoneyFlowBot.service.UpdateProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.inlinequery.InlineQuery;

@Service("moneyFlowActionProvider")
public class MoneyFlowActionProcessorProvider {

    private final ApplicationContext applicationContext;

    @Autowired
    public MoneyFlowActionProcessorProvider(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public UpdateProcessor getProcessor(Update update) {
        ProcessorType processorType = ProcessorType.DEFAULT;

        if (update.hasInlineQuery()) {
            processorType = getInlineQueryProcessor(update.getInlineQuery());
        } else if (update.hasMessage()) {
            processorType = ProcessorType.MESSAGE_PROCESSOR;
        }

        return resolveProcessorFromContext(processorType.getProcessorTypeString());
    }

    private ProcessorType getInlineQueryProcessor(InlineQuery inlineQuery) {
        return inlineQuery.getQuery().startsWith("/get")
                ? ProcessorType.INLINE_QUERY_GET_PROCESSOR
                : ProcessorType.INLINE_QUERY_ADD_PROCESSOR;
    }

    private UpdateProcessor resolveProcessorFromContext(String processorBeanName) {
        return UpdateProcessor.class
                .cast(applicationContext.getAutowireCapableBeanFactory().getBean(processorBeanName));
    }
}
