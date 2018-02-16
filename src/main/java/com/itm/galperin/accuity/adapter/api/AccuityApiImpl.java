package com.itm.galperin.accuity.adapter.api;

import com.itm.galperin.accuity.adapter.model.AccuityScreeningStatus;
import com.itm.galperin.accuity.adapter.model.client.AccuityClientDto;
import com.itm.galperin.accuity.adapter.model.transaction.AccuityTransactionDto;
import com.itm.galperin.accuity.adapter.service.AccuityClientService;
import com.itm.galperin.accuity.adapter.service.AccuityTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccuityApiImpl implements AccuityApi {

    private final AccuityTransactionService accuityTransactionService;
    private final AccuityClientService accuityClientService;

    @Autowired
    public AccuityApiImpl(AccuityTransactionService accuityTransactionService, AccuityClientService accuityClientService) {
        this.accuityTransactionService = accuityTransactionService;
        this.accuityClientService = accuityClientService;
    }

    @Override
    public AccuityScreeningStatus screenClient(AccuityClientDto accuityClientDto) {
        return accuityClientService.screenClient(accuityClientDto);
    }

    @Override
    public AccuityScreeningStatus screenTransaction(AccuityTransactionDto accuityTransactionDto) {
        return accuityTransactionService.screenTransaction(accuityTransactionDto);
    }
}
