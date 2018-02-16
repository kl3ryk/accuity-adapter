package com.itm.galperin.accuity.adapter.model.adapter;

import com.itm.galperin.accuity.adapter.model.Category;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class AccuityCategoryAdapter extends XmlAdapter<String, Category> {

    @Override
    public Category unmarshal(String category) {
        if (category == null) {
            return null;
        }

        return Category.valueOf(category);
    }

    @Override
    public String marshal(Category category) {
        if (category == null) {
            return null;
        }

        return category.name();
    }
}
