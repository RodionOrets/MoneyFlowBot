package com.rodionorets.MoneyFlowBot.service;

import org.springframework.stereotype.Component;

import java.util.Map;
import static com.rodionorets.MoneyFlowBot.constants.application.QueriesAndProcessorNames.*;

@Component("processorNameResolver")
public class ProcessorNameResolver {

    private final Map<String, String> queryToProcessorNames = Map
            .of(
                    Balance.GET_BALANCE_INLINE_QUERY, Balance.GET_BALANCE_ACTION_PROCESSOR_NAME,
                    Incomes.GET_INCOMES_INLINE_QUERY, Incomes.GET_INCOMES_ACTION_PROCESSOR_NAME,
                    Incomes.ADD_INCOME_INLINE_QUERY, Incomes.ADD_INCOME_ACTION_PROCESSOR_NAME,
                    Expenses.GET_EXPENSES_INLINE_QUERY, Expenses.GET_EXPENSES_ACTION_PROCESSOR_NAME,
                    Expenses.ADD_EXPENSE_INLINE_QUERY, Expenses.ADD_EXPENSE_ACTION_PROCESSOR_NAME,
                    Debts.Incoming.GET_INCOMING_DEBTS_INLINE_QUERY, Debts.Incoming.GET_INCOMING_DEBTS_ACTION_PROCESSOR_NAME,
                    Debts.Incoming.ADD_INCOMING_DEBT_INLINE_QUERY, Debts.Incoming.ADD_INCOMING_DEBT_ACTION_PROCESSOR_NAME,
                    Debts.Outgoing.GET_OUTGOING_DEBTS_INLINE_QUERY, Debts.Outgoing.GET_OUTGOING_DEBTS_ACTION_PROCESSOR_NAME,
                    Debts.Outgoing.ADD_OUTGOING_DEBT_INLINE_QUERY, Debts.Outgoing.ADD_OUTGOING_DEBT_ACTION_PROCESSOR_NAME
            );

    public String resolveByQuery(String query) {
        return queryToProcessorNames.get(query);
    }

}
