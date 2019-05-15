package com.rodionorets.MoneyFlowBot.repository;

import com.rodionorets.MoneyFlowBot.model.MoneyFlowAction;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ActionRepositoryStub
{
    private Map<Integer, List<MoneyFlowAction>> userActions;

    public ActionRepositoryStub()
    {
        userActions = new HashMap<>();
    }

    public void addAction(MoneyFlowAction action)
    {
        var a = userActions.get(action.getUserId());
        if (a == null)
        {
            a = new ArrayList<>();
            a.add(action);
            userActions.put(action.getUserId(), a);
        }
        else
        {
            a.add(action);
            userActions.replace(action.getUserId(), a);
        }
    }

    public Collection<MoneyFlowAction> getActions(Integer userId)
    {
        return userActions.get(userId);
    }
}
