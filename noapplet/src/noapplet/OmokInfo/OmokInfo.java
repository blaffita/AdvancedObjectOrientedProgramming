package noapplet.OmokInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class OmokInfo {
    private URL url;

    public OmokInfo() {
        try {
            url = new URL("http://omok.atwebpages.com/info/");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int response = connection.getResponseCode();

            if (HttpURLConnection.HTTP_OK == response) {
                InputStream inputStream = connection.getInputStream();
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                        }
                    }
                }
                else {
                    System.out.println("Failed to retrieve. HTTP response code: " + response);
                }
            }
            catch (IOException e) {
                e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        OmokInfo a = new OmokInfo();
    }
}