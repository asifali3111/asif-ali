import com.mashape.unirest.http.HttpResponse;
import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.datastore.DataStore;
import com.thoughtworks.gauge.datastore.DataStoreFactory;
import org.junit.Assert;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Assertions {

    @Step("The response code should be <response_code>")
    public void responseCodeShouldEqual(Integer response_code) {
        DataStore dataStore = DataStoreFactory.getScenarioDataStore();
        Integer httpResponseCode = (Integer) dataStore.get("httpResponseCode");

        Assert.assertEquals(response_code, httpResponseCode);
    }

    @Step("Assert against last updated time")
    public void AssertLastUpdatedTime() {
        DataStore dataStore = DataStoreFactory.getScenarioDataStore();
        String postRequestTime = (String) dataStore.get("postRequestTime");
        Gauge.writeMessage("POST Request Time = " + postRequestTime);
        System.out.println("\nPOST Request Time = " + postRequestTime);
        String lastUpdatedTime = (String) dataStore.get("lastUpdatedTime");
        Gauge.writeMessage("/Last Request Time = " + lastUpdatedTime);
        System.out.println("/Last Request Time = " + lastUpdatedTime);
        Assert.assertEquals(postRequestTime, lastUpdatedTime);

/*
    The Code Below was something I was trying if sometimes the timings of the POST and /Last request were out by 1s.
*/
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
//        Date parsedPostRequestTime = dateFormat.parse(postRequestTime);
//        Date parsedLastRequestTime = dateFormat.parse(lastUpdatedTime);
//        long t1 = parsedPostRequestTime.getTime();
//        long t2 = parsedLastRequestTime.getTime();
//        System.out.println("t1 = " + t1);
//        System.out.println("t2 = " + t2);
//        long t3 = t2 - t1;
//        Assert.assertTrue(t3 <= 1);
    }

}
