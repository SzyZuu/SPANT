package spant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

public class StreamCheck {
    private final String defaultURL = "https://twitch.tv/$c$";

    //System.out.println("Is online? " + getSource(name).contains("isLiveBroadcast"))

    public String insertChannel(String url, String channel){
        return url.replace("$c$", channel);
    }

    public String getSource(String targetChannel) throws IOException {
        URL url = new URL(insertChannel(defaultURL, targetChannel));
        URLConnection conn = url.openConnection();

        return toString(conn.getInputStream());
    }

    private String toString(InputStream is) throws IOException{
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))){
            String inputLine;
            StringBuilder stringBuilder = new StringBuilder();
            while ((inputLine = bufferedReader.readLine()) !=null){
                stringBuilder.append(inputLine);
            }
            return stringBuilder.toString();
        }
    }

    public boolean isOnline(String name) {
        try {
            return getSource(name).contains("isLiveBroadcast");
        } catch (IOException e){
            e.printStackTrace();
        }
        return false;
    }

    public void checkStatus(String name) {
        if(isOnline(name)){

        }else{

        }
    }
}
