package com.rodionorets.MoneyFlowBot.factory;

import com.rodionorets.MoneyFlowBot.cache.ApplicationCommandCache;
import com.rodionorets.MoneyFlowBot.command.MoneyFlowActionProcessor;
import com.rodionorets.MoneyFlowBot.util.moneyflowbot.ProcessorNameResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.api.objects.Update;

import static com.rodionorets.MoneyFlowBot.util.moneyflowbot.QueriesAndProcessorNames.General.UNKNOWN_ACTION_PROCESSOR_NAME;

@Service("moneyFlowActionProvider")
public class MoneyFlowActionProcessorProvider {

    private final ApplicationContext applicationContext;

    private final ApplicationCommandCache applicationCommandCache;

    private final ProcessorNameResolver processorNameResolver;

    @Autowired
    public MoneyFlowActionProcessorProvider(
            ApplicationContext applicationContext,
            @Qualifier("applicationCommandCache") ApplicationCommandCache applicationCommandCache,
            @Qualifier("processorNameResolver") ProcessorNameResolver processorNameResolver) {
        this.applicationContext = applicationContext;
        this.applicationCommandCache = applicationCommandCache;
        this.processorNameResolver = processorNameResolver;
    }

    public MoneyFlowActionProcessor getProcessor(Update update) {
        if (update.hasInlineQuery()) {
            applicationCommandCache.clear();
            return getProcessorForUpdateWithInlineQuery(update);
        } else if (update.hasMessage()) {
            return null;
        } else {
            return resolveFromContext(UNKNOWN_ACTION_PROCESSOR_NAME, MoneyFlowActionProcessor.class);
        }
    }

    private MoneyFlowActionProcessor getProcessorForUpdateWithInlineQuery(Update update) {
        var query = update.getInlineQuery().getQuery();
        var processorBeanName = processorNameResolver.resolveByQuery(query);
        return resolveFromContext(processorBeanName, MoneyFlowActionProcessor.class)
                .withUpdate(update);
    }

    private <T> T resolveFromContext(String beanName, Class<T> type) {
        return type.cast(applicationContext.getAutowireCapableBeanFactory().getBean(beanName));
    }

}
