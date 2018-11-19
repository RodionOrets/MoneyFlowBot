package com.rodionorets.MoneyFlowBot.service.implementation;

import com.rodionorets.MoneyFlowBot.service.UpdateProcessor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.api.objects.Update;

@Service("inlineQueryAddProcessor")
public class InlineQueryAddProcessor implements UpdateProcessor {
    @Override
    public void process(Update update) {


    }
}
