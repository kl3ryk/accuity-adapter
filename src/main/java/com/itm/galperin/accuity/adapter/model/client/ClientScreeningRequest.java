package com.itm.galperin.accuity.adapter.model.client;

import com.itm.galperin.accuity.adapter.model.Field;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Request")
@XmlAccessorType(XmlAccessType.FIELD)
public class ClientScreeningRequest {

    @XmlAttribute(name = "DatasetGUID")
    private String datasetGuid;

    @XmlAttribute(name = "UserID")
    private String userId;

    @XmlAttribute(name = "Id")
    private Integer id;

    @XmlElement(name = "Field")
    private List<Field> fields;

    public String getDatasetGuid() {
        return datasetGuid;
    }

    public void setDatasetGuid(String datasetGuid) {
        this.datasetGuid = datasetGuid;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }
}
