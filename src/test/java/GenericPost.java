import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.datastore.DataStore;
import com.thoughtworks.gauge.datastore.DataStoreFactory;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class GenericPost {

    @Step("Post to the <endpoint> endpoint")
    public void PostEndPoint(String endpoint) {
        DataStore dataStore = DataStoreFactory.getScenarioDataStore();
        HttpResponse<String> httpResponse;
        String url = "https://reference-tryout-api.herokuapp.com/" + endpoint;
        System.out.println("/n" + url);
        Gauge.writeMessage(url);
        try {
            httpResponse = Unirest.post(url)
                    .header("Content-Type", "application/json")
                    .header("Accept", "*/*")
                    .body("{\"test\": 123}")
                    .asString();
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            String postTimeStamp = dateFormat.format(timestamp);
            dataStore.put("postRequestTime", postTimeStamp);

            dataStore.put("httpResponse", httpResponse);
            Integer httpResponseCode = httpResponse.getStatus();
            dataStore.put("httpResponseCode", httpResponseCode);
            String httpResponseStatusText = httpResponse.getStatusText();
            dataStore.put("httpResponseStatusText", httpResponseStatusText);
            System.out.println(httpResponse.getBody());
            Gauge.writeMessage(httpResponse.getBody());
            System.out.println(httpResponseStatusText);
            Gauge.writeMessage(httpResponseStatusText);
        }
        catch (UnirestException e) {
            e.printStackTrace();
        }
    }
}
