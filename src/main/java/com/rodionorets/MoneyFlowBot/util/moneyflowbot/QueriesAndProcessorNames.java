package com.rodionorets.MoneyFlowBot.util.moneyflowbot;

// TODO (1-1): Consider bean naming violation so I can go without this class and resolve processor names using inline query only
public interface QueriesAndProcessorNames {

    interface Balance {
        String GET_BALANCE_INLINE_QUERY = "/get-balance";
        String GET_BALANCE_ACTION_PROCESSOR_NAME = "getBalanceActionProcessor";
    }

    interface Incomes {
        String GET_INCOMES_INLINE_QUERY = "/get-incomes";
        String GET_INCOMES_ACTION_PROCESSOR_NAME = "getIncomesActionProcessor";
        String ADD_INCOME_INLINE_QUERY = "/add-income";
        String ADD_INCOME_ACTION_PROCESSOR_NAME = "addIncomeActionProcessor";
    }

    interface Expenses {
        String GET_EXPENSES_INLINE_QUERY = "/get-expenses";
        String GET_EXPENSES_ACTION_PROCESSOR_NAME = "getExpensesActionProcessor";
        String ADD_EXPENSE_INLINE_QUERY = "/add-expense";
        String ADD_EXPENSE_ACTION_PROCESSOR_NAME = "addExpenseActionProcessor";
    }

    interface Debts {
        interface Incoming {
            String GET_INCOMING_DEBTS_INLINE_QUERY = "/get-incoming-debts";
            String GET_INCOMING_DEBTS_ACTION_PROCESSOR_NAME = "getIncomingDebtsActionProcessor";
            String ADD_INCOMING_DEBT_INLINE_QUERY = "/add-incoming-debt";
            String ADD_INCOMING_DEBT_ACTION_PROCESSOR_NAME = "addIncomingDebtActionProcessor";
        }

        interface Outgoing {
            String GET_OUTGOING_DEBTS_INLINE_QUERY = "/get-outgoing-debts";
            String GET_OUTGOING_DEBTS_ACTION_PROCESSOR_NAME = "getOutgoingDebtsActionProcessor";
            String ADD_OUTGOING_DEBT_INLINE_QUERY = "/add-outgoing-debt";
            String ADD_OUTGOING_DEBT_ACTION_PROCESSOR_NAME = "addOutgoingDebtActionProcessor";
        }
    }

    interface General {
        String UNKNOWN_ACTION_PROCESSOR_NAME = "unknownActionProcessor";
    }

}
