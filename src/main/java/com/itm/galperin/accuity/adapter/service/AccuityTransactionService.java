package com.itm.galperin.accuity.adapter.service;

import com.itm.galperin.accuity.adapter.model.AccuityScreeningStatus;
import com.itm.galperin.accuity.adapter.model.AccuityTransactionDto;

public interface AccuityTransactionService {

    AccuityScreeningStatus screenTransaction(AccuityTransactionDto accuityTransactionDto);
}
