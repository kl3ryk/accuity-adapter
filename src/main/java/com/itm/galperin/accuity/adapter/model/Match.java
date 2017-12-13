package com.itm.galperin.accuity.adapter.model;

import com.itm.galperin.accuity.adapter.model.adapter.MatchTypeAdapter;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name = "Match")
@XmlAccessorType (XmlAccessType.FIELD)
public class Match {

    @XmlJavaTypeAdapter(MatchTypeAdapter.class)
    @XmlAttribute(name = "MatchType")
    private AccuityScreeningStatus matchType;

    @XmlAttribute(name = "MatchedOn")
    private String matchedOn;

    public AccuityScreeningStatus getMatchType() {
        return matchType;
    }

    public void setMatchType(AccuityScreeningStatus matchType) {
        this.matchType = matchType;
    }

    public String getMatchedOn() {
        return matchedOn;
    }

    public void setMatchedOn(String matchedOn) {
        this.matchedOn = matchedOn;
    }
}
