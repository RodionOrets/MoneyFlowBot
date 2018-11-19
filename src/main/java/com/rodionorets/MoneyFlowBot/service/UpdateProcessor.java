package com.rodionorets.MoneyFlowBot.service;

import org.telegram.telegrambots.api.objects.Update;

public interface UpdateProcessor {
    void process(Update update);
}
