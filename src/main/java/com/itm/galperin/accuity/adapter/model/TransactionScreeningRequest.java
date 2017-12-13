package com.itm.galperin.accuity.adapter.model;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Request")
@XmlAccessorType(XmlAccessType.FIELD)
public class TransactionScreeningRequest {

    @XmlAttribute(name = "ClientID")
    private String clientId;

    @XmlAttribute(name = "Id")
    private Integer requestId;

    @XmlElement(name = "Field")
    private List<Field> fields;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }
}
