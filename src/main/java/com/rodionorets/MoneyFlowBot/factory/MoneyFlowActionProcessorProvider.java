package com.rodionorets.MoneyFlowBot.factory;

import com.rodionorets.MoneyFlowBot.cache.ApplicationCommandCache;
import com.rodionorets.MoneyFlowBot.command.MoneyFlowActionProcessor;
import com.rodionorets.MoneyFlowBot.util.QueriesAndProcessorNames;
import com.rodionorets.MoneyFlowBot.util.ProcessorNameResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.api.objects.Update;

import static com.rodionorets.MoneyFlowBot.util.QueriesAndProcessorNames.General.UNKNOWN_ACTION_PROCESSOR_NAME;

@Service("moneyFlowActionProvider")
public class MoneyFlowActionProcessorProvider {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    @Qualifier("applicationCommandCache")
    private ApplicationCommandCache applicationCommandCache;

    @Autowired
    @Qualifier("processorNameResolver")
    private ProcessorNameResolver processorNameResolver;

    public MoneyFlowActionProcessor getProcessor(Update update) {
        var processor = resolveFromContext(UNKNOWN_ACTION_PROCESSOR_NAME, MoneyFlowActionProcessor.class);

        if (update.hasInlineQuery()) {
            applicationCommandCache.clear();
            processor = getProcessorForUpdateWithInlineQuery(update);
        }
        else if (update.hasMessage()) {

        }

        processor.setUpdate(update);

        return processor;
    }

    private MoneyFlowActionProcessor getProcessorForUpdateWithInlineQuery(Update update) {
        var query = update.getInlineQuery().getQuery();
        var processorBeanName = processorNameResolver.resolveByQuery(query);
        return resolveFromContext(processorBeanName, MoneyFlowActionProcessor.class);
    }

    private <T> T resolveFromContext(String beanName, Class<T> type) {
        return type.cast(applicationContext.getAutowireCapableBeanFactory().getBean(beanName));
    }

}
