package com.rodionorets.MoneyFlowBot.repository;

import com.rodionorets.MoneyFlowBot.domain.MoneyFlowAction;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MoneyFlowActionsRepository extends MongoRepository<MoneyFlowAction, Integer> {
}
