package com.example.dhruv.reader;

/**
 * Created by dhruv on 3/25/15.
 */

        import android.content.Context;
        import android.widget.Toast;

        import org.apache.http.NameValuePair;
        import org.apache.http.client.ClientProtocolException;
        import org.apache.http.client.HttpClient;
        import org.apache.http.client.entity.UrlEncodedFormEntity;
        import org.apache.http.client.methods.HttpPost;
        import org.apache.http.impl.client.DefaultHttpClient;
        import org.apache.http.message.BasicNameValuePair;

        import java.io.IOException;
        import java.util.ArrayList;
        import java.util.List;

/**
 * Created by dhruv on 3/25/15.
 */
public class Sender {
    Context context;

    public Sender(Context context) {
        this.context = context;
    }

    public void send(String message) {
        // make sure the fields are not empty
        if (message.length() > 0) {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost("http://yourwebsite.com/yourPhpScript.php");
            try {
                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
                nameValuePairs.add(new BasicNameValuePair("id", "12345"));
                nameValuePairs.add(new BasicNameValuePair("message", message));
                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                httpclient.execute(httppost);
            } catch (ClientProtocolException e) {
                // TODO Auto-generated catch block
            } catch (IOException e) {
                // TODO Auto-generated catch block
            }

        } else {
            // display message if text fields are empty
            Toast.makeText(context, "Fialed to Send", Toast.LENGTH_LONG).show();
        }

    }
}
