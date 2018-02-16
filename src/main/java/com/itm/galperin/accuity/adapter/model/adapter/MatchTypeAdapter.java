package com.itm.galperin.accuity.adapter.model.adapter;

import com.itm.galperin.accuity.adapter.model.AccuityScreeningStatus;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class MatchTypeAdapter extends XmlAdapter<String, AccuityScreeningStatus> {

    @Override
    public AccuityScreeningStatus unmarshal(String status) {
        if (status == null) {
            return null;
        }

        return AccuityScreeningStatus.valueOf(status);
    }

    @Override
    public String marshal(AccuityScreeningStatus status) {
        if (status == null) {
            return null;
        }

        return status.name();
    }
}
