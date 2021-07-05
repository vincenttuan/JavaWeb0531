
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.commons.io.IOUtils;


public class Haker {
    
    public static void main(String[] args) throws Exception {
        String path = "http://localhost:8080/JavaWeb0531/controller/bmi_session";
        URL url = new URL(path);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        // 塞入一個 header
        conn.setRequestProperty("Cookie", "JSESSIONID=6099456E974BB1EF6B71A85285217983");
        conn.connect();
        InputStream is = conn.getInputStream();
        System.out.println(IOUtils.toString(is, "utf-8"));
        
    }
}
