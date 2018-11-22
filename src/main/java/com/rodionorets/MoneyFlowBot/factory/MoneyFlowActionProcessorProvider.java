package com.rodionorets.MoneyFlowBot.factory;

import com.rodionorets.MoneyFlowBot.cache.UpdateProcessingCache;
import com.rodionorets.MoneyFlowBot.command.MoneyFlowActionProcessor;
import com.rodionorets.MoneyFlowBot.util.moneyflowbot.ProcessorNameResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.api.objects.Update;

import static com.rodionorets.MoneyFlowBot.constants.QueriesAndProcessorNames.General.UNKNOWN_ACTION_PROCESSOR_NAME;

@Service("moneyFlowActionProvider")
public class MoneyFlowActionProcessorProvider {

    private final ApplicationContext applicationContext;

    private final UpdateProcessingCache updateProcessingCache;

    private final ProcessorNameResolver processorNameResolver;

    @Autowired
    public MoneyFlowActionProcessorProvider(
            ApplicationContext applicationContext,
            @Qualifier("applicationCommandCache") UpdateProcessingCache updateProcessingCache,
            @Qualifier("processorNameResolver") ProcessorNameResolver processorNameResolver) {
        this.applicationContext = applicationContext;
        this.updateProcessingCache = updateProcessingCache;
        this.processorNameResolver = processorNameResolver;
    }

    public MoneyFlowActionProcessor getProcessor(Update update) {
        if (update.hasInlineQuery()) {
            return getProcessorForUpdateWithInlineQuery(update);
        } else if (update.hasMessage()) {
            return getProcessorForUpdateWithMessage(update);
        } else {
            return resolveProcessorFromContext(UNKNOWN_ACTION_PROCESSOR_NAME);
        }
    }

    private MoneyFlowActionProcessor getProcessorForUpdateWithInlineQuery(Update update) {
        var query = update.getInlineQuery().getQuery();
        var processorBeanName = processorNameResolver.resolveByQuery(query);
        return resolveProcessorFromContext(processorBeanName)
                .withUpdate(update);
    }

    private MoneyFlowActionProcessor getProcessorForUpdateWithMessage(Update update) {
        return null;
    }

    private MoneyFlowActionProcessor resolveProcessorFromContext(String processorBeanName) {
        return MoneyFlowActionProcessor.class
                .cast(applicationContext.getAutowireCapableBeanFactory().getBean(processorBeanName));
    }
}
