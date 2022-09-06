package dev.bingulhan.serverapi;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Logger;

/**
 * @author BingulHan
 */
public class MinecraftServerAPI {

    /**
     * Enables fetching of information by type
     * @param type
     * @return
     */
    public String getData(String ip , InfoType type) {
       return getInfo(ip)[type.id];
    }

    /**
     * Allows information to be collected and stored in a single array
     */
    private String[] getInfo(String ip){
        String s = read(ip);

        JSONObject object = new JSONObject(s);

        String result[] = new String[5];
        result[0] = object.get("online").toString();
        result[1] = object.get("port").toString();

        if (object.get("online").toString().equals("false")) {
            result[2] = "0";
        }else {
            result[2] = object.getJSONObject("players").get("online").toString();
        }

        return result;
    }

    /**
     * It provides http query processing and fetching information via api
     */
    private String read(String ip) {
        BufferedReader reader;
        String line;
        StringBuffer responseContent = new StringBuffer();

        HttpURLConnection connection;

        try {

            URL url = new URL("https://api.mcsrvstat.us/2/" + ip);
            connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            int status = connection.getResponseCode();

            if (status > 299) {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }

                reader.close();
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }

                reader.close();
            }

            return responseContent.toString();

            //  System.out.println("" + responseContent.toString());

        }catch (Exception exception) {

        }


        return "";
    }
}
