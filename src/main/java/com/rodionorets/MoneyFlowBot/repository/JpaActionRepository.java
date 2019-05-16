package com.rodionorets.MoneyFlowBot.repository;

import com.rodionorets.MoneyFlowBot.model.MoneyFlowAction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaActionRepository extends MongoRepository<MoneyFlowAction, Integer>
{
    List<MoneyFlowAction> findByTelegramUserIdAndAction(Integer telegramUserId, String action);

    List<MoneyFlowAction> findByTelegramUserIdAndActionAndCategory(Integer telegramUserId, String action, String category);

    void deleteAllByTelegramUserId(Integer telegramUserId);
}
