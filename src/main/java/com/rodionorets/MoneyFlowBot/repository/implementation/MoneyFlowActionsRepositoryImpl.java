package com.rodionorets.MoneyFlowBot.repository.implementation;

import com.rodionorets.MoneyFlowBot.entity.MoneyFlowAction;
import com.rodionorets.MoneyFlowBot.repository.CustomMoneyFlowActionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class MoneyFlowActionsRepositoryImpl implements CustomMoneyFlowActionsRepository {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public MoneyFlowActionsRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Collection<MoneyFlowAction> findAllByTelegramUserIdAndActions(Integer telegramUserId, Collection<String> actionTypes) {
        var searchQuery = new Query()
                .addCriteria(Criteria.where("telegramUserId").is(telegramUserId))
                .addCriteria(Criteria.where("actionType").in(actionTypes));

        return mongoTemplate.find(searchQuery, MoneyFlowAction.class);
    }
}
