package com.rodionorets.MoneyFlowBot.util;

import org.telegram.telegrambots.meta.api.objects.User;

public final class HelpMessages
{
    public static final String INCOME_HELP_MESSAGE =
        "Please use it in form of: /income {amount} {category}\n" +
            "Example: /income 80000 Salary\n";

    private static final String INCOMES_HELP_MESSAGE =
        "You could use it in next ways:\n" +
            "/incomes - list of all your incomes\n" +
            "/incomes {category} - filter by category.\n";

    public static final String EXPENSE_HELP_MESSAGE =
        "Please use it in form of: /expense {amount} {category}\n" +
            "Example: /expense 8000 Education\n";

    private static final String EXPENSES_HELP_MESSAGE =
        "You could use it in next ways:\n" +
            "/incomes - list of all your incomes\n" +
            "/incomes {category} - filter by category.\n";

    public static final String GLOBAL_HELP_MESSAGE =
        "At the moment you can use following commands:\n" +
            "/income - to save your new income.\n" +
            INCOME_HELP_MESSAGE +
            "/expense - to save your new expense.\n" +
            EXPENSE_HELP_MESSAGE +
            "/incomes - returns list of logged incomes. No filters available now.\n" +
            INCOMES_HELP_MESSAGE +
            "/expenses - returns list of logger expenses. No filters available now.\n" +
            EXPENSES_HELP_MESSAGE +
            "Other commands are:\n" +
            "/reset - use it to erase all your data,\n" +
            "/help - to get this help message.\n";

    public static final String START_MESSAGE = "I'm Money Flow Bot. I can record your incomes and expenses.\n" + GLOBAL_HELP_MESSAGE;

    public static String startMessageFor(User user)
    {
        return "Hi " + user.getFirstName() + "!\n" + START_MESSAGE;
    }
}
