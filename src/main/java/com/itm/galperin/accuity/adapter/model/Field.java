package com.itm.galperin.accuity.adapter.model;

import com.itm.galperin.accuity.adapter.model.adapter.AccuityBooleanAdapter;
import com.itm.galperin.accuity.adapter.model.adapter.AccuityCategoryAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name = "Field")
@XmlAccessorType (XmlAccessType.FIELD)
public class Field {

    @XmlAttribute(name = "Name")
    private String name;

    @XmlJavaTypeAdapter(AccuityBooleanAdapter.class)
    @XmlAttribute(name = "UniqueField")
    private Boolean unique;

    @XmlJavaTypeAdapter(AccuityCategoryAdapter.class)
    @XmlAttribute(name = "Category")
    private Category category;

    @XmlValue
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getUnique() {
        return unique;
    }

    public void setUnique(Boolean unique) {
        this.unique = unique;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
