package com.rodionorets.MoneyFlowBot.util.moneyflowbot;

// TODO (1-1): Consider bean naming violation so I can go without this class and resolve processor names using inline query only
public final class QueriesAndProcessorNames {

    private QueriesAndProcessorNames() {}

    public static final class Balance {
        private Balance() {}

        public static final String GET_BALANCE_INLINE_QUERY = "/get-balance";
        public static final String GET_BALANCE_ACTION_PROCESSOR_NAME = "getBalanceActionProcessor";
    }

    public static final class Incomes {
        private Incomes() {}

        public static final String GET_INCOMES_INLINE_QUERY = "/get-incomes";
        public static final String GET_INCOMES_ACTION_PROCESSOR_NAME = "getIncomesActionProcessor";
        public static final String ADD_INCOME_INLINE_QUERY = "/add-income";
        public static final String ADD_INCOME_ACTION_PROCESSOR_NAME = "addIncomeActionProcessor";
    }

    public static final class Expenses {
        private Expenses() {}

        public static final String GET_EXPENSES_INLINE_QUERY = "/get-expenses";
        public static final String GET_EXPENSES_ACTION_PROCESSOR_NAME = "getExpensesActionProcessor";
        public static final String ADD_EXPENSE_INLINE_QUERY = "/add-expense";
        public static final String ADD_EXPENSE_ACTION_PROCESSOR_NAME = "addExpenseActionProcessor";
    }

    public static final class Debts {
        private Debts() {}

        public static final class Incoming {
            private Incoming() {}

            public static final String GET_INCOMING_DEBTS_INLINE_QUERY = "/get-incoming-debts";
            public static final String GET_INCOMING_DEBTS_ACTION_PROCESSOR_NAME = "getIncomingDebtsActionProcessor";
            public static final String ADD_INCOMING_DEBT_INLINE_QUERY = "/add-incoming-debt";
            public static final String ADD_INCOMING_DEBT_ACTION_PROCESSOR_NAME = "addIncomingDebtActionProcessor";
        }

        public static final class Outgoing {
            private Outgoing() {}

            public static final String GET_OUTGOING_DEBTS_INLINE_QUERY = "/get-outgoing-debts";
            public static final String GET_OUTGOING_DEBTS_ACTION_PROCESSOR_NAME = "getOutgoingDebtsActionProcessor";
            public static final String ADD_OUTGOING_DEBT_INLINE_QUERY = "/add-outgoing-debt";
            public static final String ADD_OUTGOING_DEBT_ACTION_PROCESSOR_NAME = "addOutgoingDebtActionProcessor";
        }
    }

    public static final class General {
        private General() {}

        public static final String UNKNOWN_ACTION_PROCESSOR_NAME = "unknownActionProcessor";
    }

}
