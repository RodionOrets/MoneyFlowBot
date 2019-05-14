package com.rodionorets.MoneyFlowBot.command;

public interface ChainedUpdateProcessor extends TelegramUpdateProcessor
{
    void setNext(ChainedUpdateProcessor nextProcessor);
}
