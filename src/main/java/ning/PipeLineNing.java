package ning;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClientConfig;
import com.ning.http.client.ListenableFuture;
import com.ning.http.client.Response;

/**
 * Does not work yet.
 * 
 * @author harish.sharma
 *
 */
public class PipeLineNing {
    public static void main(String[] args) throws InterruptedException, ExecutionException, IOException {
        AsyncHttpClientConfig cfg = new AsyncHttpClientConfig.Builder().setMaxConnectionsPerHost(1)
                .setMaxConnections(1).setAllowPoolingConnections(true).build();
        AsyncHttpClient client = new AsyncHttpClient(cfg);
        System.out.println(client.getConfig().getMaxConnections());
        ListenableFuture<Response> res1 = client.prepareGet("http://localhost:4000/greetwait?dur=1&id=1").execute();
        ListenableFuture<Response> res2 = client.prepareGet("http://localhost:4000/greetwait?dur=2&id=2").execute();
        ListenableFuture<Response> res3 = client.prepareGet("http://localhost:4000/greetwait?dur=3&id=3").execute();
        System.out.println(res1.get().getResponseBody());
        System.out.println(res2.get().getResponseBody());
        System.out.println(res3.get().getResponseBody());

        client.close();
    }
}
