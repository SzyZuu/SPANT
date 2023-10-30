import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Main {

    static UI ui = new UI();
    static Main m = new Main();

    private String defaultURL = "https://twitch.tv/$c$";

    public static String name = "0";

    public static void main(String[] args) throws IOException {
        ui.ui();
        System.out.println("Is online? " + m.getSource(m.name).contains("isLiveBroadcast"));
    }

    public String insertChannel(String url, String channel){
        return url.replace("$c$", channel);
    }

    public String getSource(String targetChannel) throws IOException{
        URL url = new URL(insertChannel(defaultURL, targetChannel));
        URLConnection conn = url.openConnection();

        return toString(conn.getInputStream());
    }

    private String toString(InputStream is) throws IOException{
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is, "UTF-8"))){
            String inputLine;
            StringBuilder stringBuilder = new StringBuilder();
            while ((inputLine = bufferedReader.readLine()) !=null){
                stringBuilder.append(inputLine);
            }
            return stringBuilder.toString();
        }
    }
}
