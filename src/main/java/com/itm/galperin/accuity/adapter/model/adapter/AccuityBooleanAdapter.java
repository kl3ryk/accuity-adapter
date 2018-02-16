package com.itm.galperin.accuity.adapter.model.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class AccuityBooleanAdapter extends XmlAdapter<String, Boolean> {

    private static final String TRUE_STRING_VALUE = "Y";
    private static final String FALSE_STRING_VALUE = "N";

    @Override
    public Boolean unmarshal(String value) {
        if (value == null) {
            return null;
        }

        return TRUE_STRING_VALUE.equals(value);
    }

    @Override
    public String marshal(Boolean value) {
        if (value == null) {
            return null;
        }

        return value ? TRUE_STRING_VALUE : FALSE_STRING_VALUE;
    }
}
