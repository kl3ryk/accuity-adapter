package com.itm.galperin.accuity.adapter.mapper;

import com.itm.galperin.accuity.adapter.model.Category;
import com.itm.galperin.accuity.adapter.model.Field;

public class AccuityTransactionMapper {

    private AccuityTransactionMapper() {
    }

    public static Field toField(String value, String name, Category category,
                                boolean unique) {
        Field field = new Field();
        field.setCategory(category);
        field.setName(name);
        field.setValue(value);
        field.setUnique(unique);
        return field;
    }
}
