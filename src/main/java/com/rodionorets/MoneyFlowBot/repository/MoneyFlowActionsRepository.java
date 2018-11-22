package com.rodionorets.MoneyFlowBot.repository;

import com.rodionorets.MoneyFlowBot.entity.MoneyFlowAction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository("moneyFlowActionRepository")
public interface MoneyFlowActionsRepository extends MongoRepository<MoneyFlowAction, Integer>, CustomMoneyFlowActionsRepository {

    Collection<MoneyFlowAction> findAllByTelegramUserId(Integer telegramUsedId);

}
