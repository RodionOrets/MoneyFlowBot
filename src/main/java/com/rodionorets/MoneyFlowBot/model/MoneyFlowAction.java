package com.rodionorets.MoneyFlowBot.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class MoneyFlowAction
{
    private Integer userId;

    private BigDecimal amount;

    private String action;

    private String category;

    private LocalDateTime timestamp;

    public MoneyFlowAction(Integer userId, BigDecimal amount, String action, String category, LocalDateTime timestamp)
    {
        this.userId = userId;
        this.amount = amount;
        this.action = action;
        this.category = category;
        this.timestamp = timestamp;
    }

    public Integer getUserId()
    {
        return userId;
    }

    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    public BigDecimal getAmount()
    {
        return amount;
    }

    public void setAmount(BigDecimal amount)
    {
        this.amount = amount;
    }

    public String getAction()
    {
        return action;
    }

    public void setAction(String action)
    {
        this.action = action;
    }

    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public LocalDateTime getTimestamp()
    {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp)
    {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoneyFlowAction moneyFlowAction1 = (MoneyFlowAction) o;
        return Objects.equals(userId, moneyFlowAction1.userId) &&
                Objects.equals(amount, moneyFlowAction1.amount) &&
                Objects.equals(action, moneyFlowAction1.action) &&
                Objects.equals(category, moneyFlowAction1.category) &&
                Objects.equals(timestamp, moneyFlowAction1.timestamp);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(userId, amount, action, category, timestamp);
    }
}
