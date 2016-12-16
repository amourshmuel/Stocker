package com.stocker.providers;

import com.stocker.providers.models.Sector;
import com.stocker.utils.WebClientFactory;
import net.sf.jsefa.Deserializer;
import net.sf.jsefa.csv.CsvIOFactory;
import org.apache.cxf.jaxrs.client.WebClient;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.*;
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

        InputStream in = (InputStream) response.getEntity();
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(in));
        StringBuilder result = new StringBuilder();
        String line;
        while((line = buffReader.readLine()) != null) {
            result.append(line);
            result.append("\n");
        }

        Deserializer deserializer = CsvIOFactory.createFactory(Sector.class).createDeserializer();
        StringReader reader = new StringReader(result.toString());
        deserializer.open(reader);
        while (deserializer.hasNext()) {
            Sector p = deserializer.next();
            // do something useful with it
        }
        deserializer.close(true);

        return null;
    }
}