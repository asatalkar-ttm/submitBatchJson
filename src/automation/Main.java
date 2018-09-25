package automation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.Date;

class Main{

    private GsonBuilder gsonBuilder;

    public Main() throws IllegalArgumentException {
        this.gsonBuilder = new GsonBuilder().setPrettyPrinting().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    }

    public String submitBatch(int profileId, String[] dsns) throws IOException {

        SubmitBatchPayload payload = new SubmitBatchPayload("aditya@peoplenetonline.com", new Date(), dsns, profileId, "SmokeTestBatch");
        Gson gson = this.gsonBuilder.setPrettyPrinting().create();

        System.out.println(gson.toJson(payload));
        return gson.toJson(payload);
    }

    public static void main(String[] args) throws IOException {
        int profileId = 16300000;
        String[] dsn = {"1234567"};
        Main main = new Main();
        main.submitBatch(profileId,dsn);
    }
}