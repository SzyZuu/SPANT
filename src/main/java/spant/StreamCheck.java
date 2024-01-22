package spant;

import org.apache.commons.lang3.SystemUtils;

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
            do{
                System.out.println("Waiting...");
                if(!isOnline(name)){
                    System.out.println("Streamer went offline, shutdown!");
                    try {
                        shutdown(0);
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }while (isOnline(name));
        }else {
            System.out.println("offline");
        }
    }

    public static boolean shutdown(int time) throws IOException {
        String shutdownCommand = null, t = time == 0 ? "now" : String.valueOf(time);

        if(SystemUtils.IS_OS_AIX)
            shutdownCommand = "shutdown -Fh " + t;
        else if(SystemUtils.IS_OS_FREE_BSD || SystemUtils.IS_OS_LINUX || SystemUtils.IS_OS_MAC|| SystemUtils.IS_OS_MAC_OSX || SystemUtils.IS_OS_NET_BSD || SystemUtils.IS_OS_OPEN_BSD || SystemUtils.IS_OS_UNIX)
            shutdownCommand = "shutdown -h " + t;
        else if(SystemUtils.IS_OS_HP_UX)
            shutdownCommand = "shutdown -hy " + t;
        else if(SystemUtils.IS_OS_IRIX)
            shutdownCommand = "shutdown -y -g " + t;
        else if(SystemUtils.IS_OS_SOLARIS || SystemUtils.IS_OS_SUN_OS)
            shutdownCommand = "shutdown -y -i5 -g" + t;
        else if(SystemUtils.IS_OS_WINDOWS)
            shutdownCommand = "shutdown.exe /s /t " + t;
        else
            return false;

        Runtime.getRuntime().exec(shutdownCommand);
        return true;
    }
}
