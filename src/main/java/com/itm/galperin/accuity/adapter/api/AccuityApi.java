package com.itm.galperin.accuity.adapter.api;

import com.itm.galperin.accuity.adapter.model.AccuityScreeningStatus;
import com.itm.galperin.accuity.adapter.model.AccuityTransactionDto;

public interface AccuityApi {

    AccuityScreeningStatus screenTransaction(AccuityTransactionDto accuityTransactionDto);
}
