package com.epam.learn.cleancode;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.util.Set;

public class MiddlewareJob {

    private final String dataStoreKey = "EventDataSet";
    private final String redisClusterEndpoint = "http://redis.cluster.com";
    private final Integer redisClusterPort = 6379;
    private final String username = "username";
    private final String password = "password";
    private final String apiEndpoint = "http://api.app.com/endpoint";

    public void handleRequest() {

        //set up redis client
        final Jedis redisClient = new Jedis(
                redisClusterEndpoint,
                redisClusterPort
        );

        Set<String> data = redisClient.spop(dataStoreKey, Long.MAX_VALUE);

        System.out.printf("Got [%s] events", data.size());
        //skip if no elements to push
        if (data.isEmpty()) {
            return;
        }

        String postBody = setToString(data);

        CredentialsProvider provider = new BasicCredentialsProvider();
        provider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(username, password));

        HttpClient httpClient = HttpClientBuilder.create()
                .setDefaultCredentialsProvider(provider)
                .build();

        HttpPost request = new HttpPost(apiEndpoint);
        request.setEntity(new StringEntity(postBody, ContentType.APPLICATION_JSON));

        try {
            httpClient.execute(request);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }


    private static String setToString(Set<String> data) {
        String result = "[";
        String delimeter = "";
        for (String item : data) {
            result += delimeter + item;
            delimeter = ",";
        }
        return result + "]";
    }
}
