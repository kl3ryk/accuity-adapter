package com.itm.galperin.accuity.adapter.service;

public interface MessageConverter {

    <T> String marshalMessage(T message, Class<T> clazz);

    <T> T unmarshalMessage(String response, Class<T> clazz);
}
