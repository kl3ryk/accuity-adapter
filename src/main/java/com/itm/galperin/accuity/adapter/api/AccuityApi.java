package com.itm.galperin.accuity.adapter.api;

import com.itm.galperin.accuity.adapter.model.AccuityScreeningStatus;
import com.itm.galperin.accuity.adapter.model.client.AccuityClientDto;
import com.itm.galperin.accuity.adapter.model.transaction.AccuityTransactionDto;

public interface AccuityApi {

    AccuityScreeningStatus screenClient(AccuityClientDto accuityClientDto);

    AccuityScreeningStatus screenTransaction(AccuityTransactionDto accuityTransactionDto);
}
