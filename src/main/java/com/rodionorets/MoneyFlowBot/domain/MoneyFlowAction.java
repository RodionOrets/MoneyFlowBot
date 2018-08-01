package com.rodionorets.MoneyFlowBot.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(collection = "moneyFlowAction")
public class MoneyFlowAction {

    @Id
    private Integer id;

    private Integer telegramUserId;

    private BigDecimal amount;

    private String actionType;
}
