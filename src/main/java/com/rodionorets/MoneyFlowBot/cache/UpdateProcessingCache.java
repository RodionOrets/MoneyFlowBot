package com.rodionorets.MoneyFlowBot.cache;

import org.springframework.stereotype.Service;

// TODO (3): Implement here command caching to be able to use not only inline queries but messages
@Service("applicationCommandCache")
public class UpdateProcessingCache {

    /* TODO(5): Implement UpdateProcessingCache in order to track what is the current or last action processed
    *  TODO(5): Consider saving transactions state for "AddXXXActionProcessor" so user can "say" things to bot by chunks
    *  TODO(5): So here we have: 1. Last Action (Expense, Income, etc.); 2. Last Action info (amount, description, etc.)
     */

    public void clear() {

    }

    public boolean isClear() {

    }

}
