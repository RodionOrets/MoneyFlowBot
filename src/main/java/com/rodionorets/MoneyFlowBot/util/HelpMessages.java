package com.rodionorets.MoneyFlowBot.util;

import org.telegram.telegrambots.meta.api.objects.User;

public final class HelpMessages
{
    public static final String INCOME_HELP_MESSAGE =
            "Please use it in form of: /income {amount} {category}\n" +
            "Example: /income 80000 Salary\n";

    public static final String INCOMES_HELP_MESSAGE = "";

    public static final String EXPENSE_HELP_MESSAGE =
            "Please use it in form of: /expense {amount} {category}\n" +
            "Example: /expense 8000 Education\n";

    public static final String EXPENSES_HELP_MESSAGE = "";

    public static final String GLOBAL_HELP_MESSAGE =
            "At the moment you can use following commands:\n" +
                    "/income - to save your new income.\n" +
                    HelpMessages.INCOME_HELP_MESSAGE +
                    "/expense - to save your new expense.\n" +
                    HelpMessages.EXPENSE_HELP_MESSAGE;

    public static final String START_MESSAGE = "I'm Money Flow Bot. I can record your incomes and expenses.\n" + GLOBAL_HELP_MESSAGE;

    public static String startMessageFor(User user)
    {
        return "Hi " + user.getFirstName() + "!\n" + START_MESSAGE;
    }
}
