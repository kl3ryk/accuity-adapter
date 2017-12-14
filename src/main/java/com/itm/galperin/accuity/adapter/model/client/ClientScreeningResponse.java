package com.itm.galperin.accuity.adapter.model.client;

import com.itm.galperin.accuity.adapter.model.Match;
import com.itm.galperin.accuity.adapter.model.adapter.AccuityBooleanAdapter;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name = "Results")
@XmlAccessorType(XmlAccessType.FIELD)
public class ClientScreeningResponse {

    @XmlJavaTypeAdapter(AccuityBooleanAdapter.class)
    @XmlAttribute(name = "IsHit")
    private Boolean isHit;

    @XmlElement(name = "Match")
    private List<Match> matches;

    public Boolean getHit() {
        return isHit;
    }

    public void setHit(Boolean hit) {
        isHit = hit;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }
}
