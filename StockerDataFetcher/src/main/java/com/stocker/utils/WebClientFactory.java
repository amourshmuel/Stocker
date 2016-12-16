package com.stocker.utils;

import org.apache.cxf.jaxrs.client.WebClient;
import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;
import org.codehaus.jackson.map.DeserializationConfig;
import javax.ws.rs.core.MediaType;

import java.util.Collections;

/**
 * Created by AmourWin7 on 12/16/2016.
 */
public class WebClientFactory {

    /**
     * Creates WebClient
     *
     * @param url
     *            the url
     * @param mediaTypes
     *            the accepted maida types
     * @return the created WebClient
     */
    public static WebClient createClient(String url, MediaType[] mediaTypes) {

        JacksonJaxbJsonProvider jacksonJaxbJsonProvider = new JacksonJaxbJsonProvider();
        jacksonJaxbJsonProvider.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES,
                false);

        return WebClient.create(url,
                Collections.singletonList(jacksonJaxbJsonProvider)).accept(
                mediaTypes);

    }

}
