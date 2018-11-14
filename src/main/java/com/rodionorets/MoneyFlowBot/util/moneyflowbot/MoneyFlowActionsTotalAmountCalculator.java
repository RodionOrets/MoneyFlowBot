package com.rodionorets.MoneyFlowBot.util.moneyflowbot;

import com.rodionorets.MoneyFlowBot.domain.MoneyFlowAction;

import java.util.Collection;

public class MoneyFlowActionsTotalAmountCalculator {
    public static double calculateTotalAmount(Collection<MoneyFlowAction> actions) {
        return actions.stream()
                .mapToDouble(action -> action.getAmount().doubleValue())
                .sum();
    }
}
