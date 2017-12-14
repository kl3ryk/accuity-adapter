package com.itm.galperin.accuity.adapter.service;

import com.itm.galperin.accuity.adapter.mapper.AccuityClientMapper;
import com.itm.galperin.accuity.adapter.model.AccuityScreeningStatus;
import com.itm.galperin.accuity.adapter.model.Field;
import com.itm.galperin.accuity.adapter.model.Match;
import com.itm.galperin.accuity.adapter.model.client.AccuityClientDto;
import com.itm.galperin.accuity.adapter.model.client.ClientScreeningRequest;
import com.itm.galperin.accuity.adapter.model.client.ClientScreeningResponse;
import java.util.Arrays;
import java.util.List;
import org.accuity.ScreeningService.ImportScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AccuityClientServiceImpl implements AccuityClientService {

    @Value("${accuity.api.asm.dataset.guid}")
    private String datasetGuid;

    @Value("${accuity.api.asm.user.id}")
    private String userId;

    private final ImportScreeningService importScreeningService;
    private final MessageConverter messageConverter;

    @Autowired
    public AccuityClientServiceImpl(ImportScreeningService importScreeningService, MessageConverter messageConverter) {
        this.importScreeningService = importScreeningService;
        this.messageConverter = messageConverter;
    }

    @Override
    public AccuityScreeningStatus screenClient(AccuityClientDto accuityClientDto) {
        ClientScreeningRequest request = buildRequest(accuityClientDto);
        ClientScreeningResponse response = getResponse(request);

        if (!Boolean.TRUE.equals(response.getHit())) {
            return AccuityScreeningStatus.CLEAR;
        }

        return response.getMatches().stream()
                .map(Match::getMatchType)
                .filter(AccuityScreeningStatus.GWL::equals)
                .findFirst()
                .orElse(AccuityScreeningStatus.PEP);
    }

    private ClientScreeningRequest buildRequest(AccuityClientDto clientDto) {
        ClientScreeningRequest request = new ClientScreeningRequest();
        request.setDatasetGuid(datasetGuid);
        request.setUserId(userId);
        request.setId(clientDto.getId());
        List<Field> fields = Arrays.asList(
                AccuityClientMapper.toField(clientDto.getId().toString(), "ID"),
                AccuityClientMapper.toField(clientDto.getName(), "NAME"));
        request.setFields(fields);
        return request;
    }

    private ClientScreeningResponse getResponse(ClientScreeningRequest request) {
        String rawRequest = messageConverter.marshalMessage(request, ClientScreeningRequest.class);
        String rawResponse = importScreeningService.importScreening(rawRequest);
        return messageConverter.unmarshalMessage(rawResponse, ClientScreeningResponse.class);
    }

}
