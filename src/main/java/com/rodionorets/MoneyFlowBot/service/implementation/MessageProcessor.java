package com.rodionorets.MoneyFlowBot.service.implementation;

import com.rodionorets.MoneyFlowBot.cache.ApplicationCache;
import com.rodionorets.MoneyFlowBot.service.UpdateProcessor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.api.objects.Update;

@Service("messageProcessor")
public class MessageProcessor implements UpdateProcessor {

    private ApplicationCache applicationCache;

    @Override
    public void process(Update update) {

    }
}
