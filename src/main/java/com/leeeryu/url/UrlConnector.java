package com.leeeryu.url;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Set;

public class UrlConnector {

    public static String get(String requestUrl, Map<String, Object> params) {
        final StringBuilder requestParameter = new StringBuilder(requestUrl + "?");
        if (params != null && !params.isEmpty()) {
            final Set<Map.Entry<String, Object>> entries = params.entrySet();
            for (Map.Entry<String, Object> next : entries) {
                requestParameter.append("&").append(next.getKey()).append("=").append(next.getValue());
            }
        }

        final HttpURLConnection connection = getConnection(requestParameter.toString());

        try {
            System.out.println("url: " + connection.getURL().toString());
            System.out.println("content type: " + connection.getContentType());
            System.out.println("content length: " + connection.getContentLength());
            System.out.println("content encoding: " + connection.getContentEncoding());
            System.out.println("header fields: " + connection.getHeaderFields());
            System.out.println("date: " + connection.getDate());
            System.out.println("expiration: " + connection.getExpiration());
            System.out.println("last modified: " + connection.getLastModified());

            if (connection.getResponseCode() != 200) {
                return readBody(connection.getErrorStream());
            } else {
                return readBody(connection.getInputStream());
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("API 요청과 응답 실패");
        } finally {
           connection.disconnect();
        }
    }

    public static String post(String apiUrl, Map<String, Object> headers, Map<String, String> parameters) {
        final HttpURLConnection connection = getConnection(apiUrl);

        try {
            connection.setRequestMethod("POST");

            final Set<Map.Entry<String, Object>> entries = headers.entrySet();
            for (Map.Entry<String, Object> next : entries) {
                connection.setRequestProperty(next.getKey(), next.getValue().toString());
            }

            final StringBuilder postParameters = new StringBuilder();
            final Set<Map.Entry<String, String>> parameterEntries = parameters.entrySet();
            for (Map.Entry<String, String> parameter : parameterEntries) {
                postParameters.append("&").append(parameter.getKey()).append("=").append(parameter.getValue());
            }

            connection.setDoOutput(true);
            try (final DataOutputStream dos = new DataOutputStream(connection.getOutputStream())) {
                dos.write(postParameters.toString().getBytes());
                dos.flush();
            }

            final int responseCode = connection.getResponseCode();

            if (responseCode != 200) {
                return readBody(connection.getErrorStream());
            } else {
                return readBody(connection.getInputStream());
            }
        } catch (IOException e) {
            System.out.println("POST 요청에 실패했습니다.");
            throw new RuntimeException(e);
        } finally {
            connection.disconnect();
        }
    }

    public static String readBody(InputStream is) {
        final StringBuilder responseBody = new StringBuilder();
        try (final BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = br.readLine()) != null) {
                responseBody.append(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("API 응답을 읽는데 실패했습니다.");
        }

        return responseBody.toString();
    }

    public static HttpURLConnection getConnection(String apiUrl) {
        try {
            final URL url = new URL(apiUrl);
            final HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setConnectTimeout(2000);

            return urlConnection;
        } catch (MalformedURLException e) {
            System.out.println("URL이 잘못되었습니다.");
            throw new RuntimeException(e);
        } catch (Exception e) {
            System.out.println("연결에 실패했습니다.");
            throw new RuntimeException(e);
        }
    }
}
