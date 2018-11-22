package com.rodionorets.MoneyFlowBot.util.moneyflowbot;

import com.rodionorets.MoneyFlowBot.entity.MoneyFlowAction;

import java.math.BigDecimal;
import java.util.Collection;

public class MoneyFlowActionsTotalAmountCalculator {
    public static BigDecimal calculateTotalAmount(Collection<MoneyFlowAction> actions) {
        return actions.stream()
                .map(MoneyFlowAction::getAmount)
                .reduce(BigDecimal::add)
                .get();
    }
}
