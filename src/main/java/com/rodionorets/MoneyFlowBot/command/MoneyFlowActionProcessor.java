package com.rodionorets.MoneyFlowBot.command;

import com.rodionorets.MoneyFlowBot.bot.MoneyFlowBot;
import com.rodionorets.MoneyFlowBot.util.telegram.ApiMethodExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.telegram.telegrambots.api.methods.BotApiMethod;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.io.Serializable;

// TODO(4): Consider processing not telegram.Update object but custom wrapper
public abstract class MoneyFlowActionProcessor {

    @Autowired
    @Qualifier("apiMethodExecutor")
    private ApiMethodExecutor apiMethodExecutor;

    private Update update;

    protected Update getUpdate() {
        return update;
    }

    public MoneyFlowActionProcessor withUpdate(Update update) {
        this.update = update;
        return this;
    }

    protected <T extends Serializable, ApiMethod extends BotApiMethod<T>> void executeApiMethod(ApiMethod method) {
        apiMethodExecutor.executeApiMethod(method);
    }

    public abstract void process();
}
