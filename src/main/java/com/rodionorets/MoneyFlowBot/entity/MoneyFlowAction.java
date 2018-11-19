package com.rodionorets.MoneyFlowBot.entity;

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

    public MoneyFlowAction(Builder builder) {
        this.telegramUserId = builder.telegramUserId;
        this.amount = builder.amount;
        this.actionType = builder.actionType;
    }

    public Integer getId() {
        return id;
    }

    public Integer getTelegramUserId() {
        return telegramUserId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getActionType() {
        return actionType;
    }

    public static class Builder {
        private Integer telegramUserId;

        private BigDecimal amount;

        private String actionType;

        public MoneyFlowAction build() {
            return new MoneyFlowAction(this);
        }

        public Builder withTelegramUserId(Integer telegramUserId) {
            this.telegramUserId = telegramUserId;
            return this;
        }

        public Builder withAmount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        public Builder withActionType(String actionType) {
            this.actionType = actionType;
            return this;
        }
    }
}
