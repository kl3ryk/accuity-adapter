package com.itm.galperin.accuity.adapter.api;

import com.itm.galperin.accuity.adapter.model.AccuityScreeningStatus;
import com.itm.galperin.accuity.adapter.model.AccuityTransactionDto;
import com.itm.galperin.accuity.adapter.service.AccuityTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccuityApiImpl implements AccuityApi {

    private final AccuityTransactionService accuityTransactionService;

    @Autowired
    public AccuityApiImpl(AccuityTransactionService accuityTransactionService) {
        this.accuityTransactionService = accuityTransactionService;
    }

    @Override
    public AccuityScreeningStatus screenTransaction(AccuityTransactionDto accuityTransactionDto) {
        return accuityTransactionService.screenTransaction(accuityTransactionDto);
    }

}
