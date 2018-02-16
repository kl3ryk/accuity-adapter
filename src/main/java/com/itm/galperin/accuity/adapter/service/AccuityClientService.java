package com.itm.galperin.accuity.adapter.service;

import com.itm.galperin.accuity.adapter.model.AccuityScreeningStatus;
import com.itm.galperin.accuity.adapter.model.client.AccuityClientDto;

public interface AccuityClientService {

    AccuityScreeningStatus screenClient(AccuityClientDto accuityClientDto);
}
