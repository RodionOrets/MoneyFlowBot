package com.rodionorets.MoneyFlowBot.repository;

import com.rodionorets.MoneyFlowBot.domain.MoneyFlowAction;

import java.util.Collection;

public interface CustomMoneyFlowActionsRepository {

    Collection<MoneyFlowAction> findAllByTelegramUserIdAndActions(Integer telegramUserId, Collection<String> actionTypes);

}
