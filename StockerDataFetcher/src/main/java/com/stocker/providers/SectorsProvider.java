package com.stocker.providers;

import com.stocker.providers.models.Sector;
import com.stocker.utils.WebClientFactory;
import com.stocker.utils.serializer.csv.DoubleConverter;
import net.sf.jsefa.Deserializer;
import net.sf.jsefa.common.lowlevel.filter.HeaderAndFooterFilter;
import net.sf.jsefa.csv.CsvIOFactory;
import net.sf.jsefa.csv.config.CsvConfiguration;
import org.apache.cxf.jaxrs.client.WebClient;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_OCTET_STREAM;
import static javax.ws.rs.core.MediaType.valueOf;

/**
 * Created by AmourWin7 on 12/16/2016.
 */
public class SectorsProvider {

    private static SectorsProvider instance = null;

    private SectorsProvider() {
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("SectorsProvider runs in Singelton mode. Cloning not supported.");
    }

    public static synchronized SectorsProvider getInstance() {

        if (SectorsProvider.instance == null) {
            SectorsProvider.instance = new SectorsProvider();
        }

        return SectorsProvider.instance;
    }

    public List<Sector> getSectors() throws IOException {

        MediaType[] mediaTypes = new MediaType[]{valueOf(APPLICATION_OCTET_STREAM)};

        final WebClient webClient = WebClientFactory.createClient(
                "https://biz.yahoo.com/p/csv/sum_conameu.csv", mediaTypes);

        Response response = webClient.get();

        if (response.getStatus() != Response.Status.OK.getStatusCode()) {
            throw new RuntimeException("Authorization failed");
        }

        InputStream is = (InputStream) response.getEntity();
        CsvConfiguration config = new CsvConfiguration();
               config.setLineFilter(new HeaderAndFooterFilter(1, false, true));
        config.setFieldDelimiter(',');
        config.getSimpleTypeConverterProvider().registerConverterType(Double.class, DoubleConverter.class);
        Sector p =null;
        Deserializer deserializer = CsvIOFactory.createFactory(config,Sector.class).createDeserializer();

        ArrayList<Sector> list=new ArrayList<>();
        deserializer.open(new InputStreamReader(is));
        while (deserializer.hasNext()) {
            list.add(deserializer.next());
        }
        deserializer.close(true);

        return list;
    }
}