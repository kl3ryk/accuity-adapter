package com.itm.galperin.accuity.adapter.service;

import com.itm.galperin.accuity.adapter.exception.AccuityException;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.springframework.stereotype.Service;

@Service
public class MessageConverterImpl implements MessageConverter {

    @Override
    public <T> String marshalMessage(T message, Class<T> clazz) {
        try {
            StringWriter sw = new StringWriter();
            JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(message, sw);
            return sw.toString();
        } catch (JAXBException e) {
            throw new AccuityException("Error while marshalling request", e);
        }
    }

    @Override
    public <T> T unmarshalMessage(String response, Class<T> clazz) {
        try {
            StringReader sr = new StringReader(response);
            JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return clazz.cast(unmarshaller.unmarshal(sr));
        } catch (JAXBException e) {
            throw new AccuityException("Error while unmarshalling response", e);
        }
    }
}
