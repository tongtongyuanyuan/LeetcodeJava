import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TinyUrl2 {
    /*
     * @param long_url: a long url
     * @param key: a short key
     * @return: a short url starts with http://tiny.url/
     */
    public String createCustom(String long_url, String key) {
        String short_url = "http://tiny.url/" + key;
        if (long2Short.containsKey(long_url)) {
            return long2Short.get(long_url).equals(short_url) ? short_url : "error";
        }
        if (short2Long.containsKey(short_url)) {
            return "error";
        }

        short2Long.put(short_url, long_url);
        long2Short.put(long_url, short_url);
        return short_url;
    }

    /*
     * @param long_url: a long url
     * @return: a short url starts with http://tiny.url/
     */
    public String longToShort(String long_url) {
        if (long2Short.containsKey(long_url)) {
            return long2Short.get(long_url);
        }

        String short_url = "http://tiny.url/" + getRandomString();
        while (short2Long.containsKey(short_url)) {
            short_url = "http://tiny.url/" + getRandomString();
        }
        short2Long.put(short_url, long_url);
        long2Short.put(long_url, short_url);
        return short_url;
    }

    /*
     * @param short_url: a short url starts with http://tiny.url/
     * @return: a long url
     */
    public String shortToLong(String short_url) {
        if (short2Long.containsKey(short_url)) {
            return short2Long.get(short_url);
        }
        return null;
    }

    private Map <String, String> long2Short = new HashMap <>();
    private Map<String, String> short2Long = new HashMap<>();

    private String getRandomString() {
        Random rand = new Random();
        String result = "";
        String dict = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < 6; ++i) {
            int cur = rand.nextInt(62);
            result += dict.charAt(cur);
        }
        return result;
    }
}