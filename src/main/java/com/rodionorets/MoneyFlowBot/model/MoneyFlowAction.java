package com.rodionorets.MoneyFlowBot.model;

import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class MoneyFlowAction
{
    @Id
    private Integer id;

    private Integer telegramUserId;

    private BigDecimal amount;

    private String action;

    private String category;

    private LocalDateTime timestamp;

    public MoneyFlowAction(Integer telegramUserId, BigDecimal amount, String action, String category, LocalDateTime timestamp)
    {
        this.telegramUserId = telegramUserId;
        this.amount = amount;
        this.action = action;
        this.category = category;
        this.timestamp = timestamp;
    }

    public Integer getTelegramUserId()
    {
        return telegramUserId;
    }

    public void setUserId(Integer telegramUserId)
    {
        this.telegramUserId = telegramUserId;
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
        return Objects.equals(telegramUserId, moneyFlowAction1.telegramUserId) &&
                Objects.equals(amount, moneyFlowAction1.amount) &&
                Objects.equals(action, moneyFlowAction1.action) &&
                Objects.equals(category, moneyFlowAction1.category) &&
                Objects.equals(timestamp, moneyFlowAction1.timestamp);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(telegramUserId, amount, action, category, timestamp);
    }
}
