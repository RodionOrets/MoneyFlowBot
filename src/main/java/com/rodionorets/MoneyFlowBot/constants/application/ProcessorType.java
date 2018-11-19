package com.rodionorets.MoneyFlowBot.constants.application;

public enum ProcessorType {
    DEFAULT(BeanNames.DEFAULT_UPDATE_PROCESSOR_BEAN_NAME),
    INLINE_QUERY_GET_PROCESSOR(BeanNames.INLINE_QUERY_GET_PROCESSOR_BEAN_NAME),
    INLINE_QUERY_ADD_PROCESSOR(BeanNames.INLINE_QUERY_ADD_PROCESSOR_BEAN_NAME),
    MESSAGE_PROCESSOR(BeanNames.MESSAGE_PROCESSOR_BEAN_NAME);

    private String processorTypeString;

    ProcessorType(String processorTypeString) {
        this.processorTypeString = processorTypeString;
    }

    public String getProcessorTypeString() {
        return processorTypeString;
    }
}
