package com.itm.galperin.accuity.adapter.service;

import com.itm.galperin.accuity.adapter.mapper.AccuityTransactionMapper;
import com.itm.galperin.accuity.adapter.model.AccuityScreeningStatus;
import com.itm.galperin.accuity.adapter.model.AccuityTransactionDto;
import com.itm.galperin.accuity.adapter.model.Category;
import com.itm.galperin.accuity.adapter.model.Field;
import com.itm.galperin.accuity.adapter.model.TransactionScreeningRequest;
import com.itm.galperin.accuity.adapter.model.TransactionScreeningResponse;
import java.util.Arrays;
import java.util.List;
import org.accuity.FilterService.FilterServicePortType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AccuityTransactionServiceImpl implements AccuityTransactionService {

    @Value("${accuity.api.client.profile.id}")
    private String clientProfileId;

    private final FilterServicePortType filterServicePortType;
    private final MessageConverter messageConverter;

    @Autowired
    public AccuityTransactionServiceImpl(FilterServicePortType filterServicePortType, MessageConverter messageConverter) {
        this.filterServicePortType = filterServicePortType;
        this.messageConverter = messageConverter;
    }

    @Override
    public AccuityScreeningStatus screenTransaction(AccuityTransactionDto accuityTransactionDto) {
        TransactionScreeningRequest request = buildRequest(accuityTransactionDto);
        TransactionScreeningResponse response = getResponse(request);

        if (!Boolean.TRUE.equals(response.getHit())) {
            return AccuityScreeningStatus.CLEAR;
        }

        boolean sanctioned = response.getMatches().stream()
                .anyMatch(m -> AccuityScreeningStatus.GWL.equals(m.getMatchType()));
        return sanctioned ? AccuityScreeningStatus.GWL : AccuityScreeningStatus.PEP;
    }

    private TransactionScreeningRequest buildRequest(AccuityTransactionDto transactionDto) {
        TransactionScreeningRequest request = new TransactionScreeningRequest();
        request.setClientId(clientProfileId);
        request.setRequestId(transactionDto.getId());
        List<Field> fields = Arrays.asList(
                AccuityTransactionMapper.toField(transactionDto.getId().toString(), "ID", Category.ID, true),
                AccuityTransactionMapper.toField(transactionDto.getSenderName(), "NAME", Category.NAME, false));
        request.setFields(fields);
        return request;
    }

    private TransactionScreeningResponse getResponse(TransactionScreeningRequest request) {
        String rawRequest = messageConverter.marshalMessage(request, TransactionScreeningRequest.class);
        String rawResponse = filterServicePortType.filterDoc(rawRequest);
        return messageConverter.unmarshalMessage(rawResponse, TransactionScreeningResponse.class);
    }
}
