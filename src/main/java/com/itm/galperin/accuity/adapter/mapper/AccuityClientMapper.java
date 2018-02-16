package com.itm.galperin.accuity.adapter.mapper;

import com.itm.galperin.accuity.adapter.model.Field;

public class AccuityClientMapper {

    private AccuityClientMapper() {
    }

    public static Field toField(String value, String name) {
        Field field = new Field();
        field.setName(name);
        field.setValue(value);
        return field;
    }
}
