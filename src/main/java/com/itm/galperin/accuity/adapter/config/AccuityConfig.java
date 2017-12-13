package com.itm.galperin.accuity.adapter.config;

import java.util.Map;
import javax.xml.ws.BindingProvider;
import org.accuity.FilterService.FilterService;
import org.accuity.FilterService.FilterServicePortType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {ConfigurationConstants.ACCUITY_ADAPTER_CORE_PACKAGE})
public class AccuityConfig {

    @Value("${accuity.api.filterService.address}")
    private String filterServiceAddress;

    @Bean
    FilterServicePortType createScreeningService() {
        FilterServicePortType service = new FilterService().getFilterServiceHttpSoap11Endpoint();
        setRequestContext((BindingProvider) service);
        return service;
    }

    private void setRequestContext(BindingProvider bindingProvider) {
        Map<String, Object> requestContext = bindingProvider.getRequestContext();
        requestContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, filterServiceAddress);
    }
}
