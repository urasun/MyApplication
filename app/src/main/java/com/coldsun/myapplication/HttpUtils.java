package com.coldsun.myapplication;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.security.KeyStore;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import javax.net.ssl.HttpsURLConnection;

//import org.apache.http.*;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.File;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;


public class HttpUtils {


//    public static HttpResponse doGet(String host, String path, String method,
//                                     Map<String, String> headers,
//                                     Map<String, String> querys)
//            throws Exception {
//        HttpClient httpClient = wrapClient(host);
//
//        HttpGet request = new HttpGet(buildUrl(host, path, querys));
//        for (Map.Entry<String, String> e : headers.entrySet()) {
//            request.addHeader(e.getKey(), e.getValue());
//        }
//
//        return httpClient.execute(request);
//    }

//    public static HttpResponse doPost(String host, String path, String method,
//                                      Map<String, String> headers,
//                                      Map<String, String> querys,
//                                      Map<String, String> bodys)
//            throws Exception {
//        HttpClient httpClient = wrapClient(host);
//
//        HttpPost request = new HttpPost(buildUrl(host, path, querys));
//        for (Map.Entry<String, String> e : headers.entrySet()) {
//            request.addHeader(e.getKey(), e.getValue());
//        }
//
//        if (bodys != null) {
//            List<NameValuePair> nameValuePairList = new ArrayList<NameValuePair>();
//
//            for (String key : bodys.keySet()) {
//                nameValuePairList.add(new BasicNameValuePair(key, bodys.get(key)));
//            }
//            UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(nameValuePairList, "utf-8");
//            formEntity.setContentType("application/x-www-form-urlencoded; charset=UTF-8");
//            request.setEntity(formEntity);
//        }
//
//        return httpClient.execute(request);
//    }


//    public static HttpResponse doPost(String host, String path, String method,
//                                      Map<String, String> headers,
//                                      Map<String, String> querys,
//                                      String body)
//            throws Exception {
//        HttpClient httpClient = wrapClient(host);
//
//        HttpPost request = new HttpPost(buildUrl(host, path, querys));
//        for (Map.Entry<String, String> e : headers.entrySet()) {
//            request.addHeader(e.getKey(), e.getValue());
//        }
//
//        if (StringUtils.isNotBlank(body)) {
//            request.setEntity(new StringEntity(body, "utf-8"));
//        }
//
//        return httpClient.execute(request);
//    }

//    public static HttpResponse doPost(String host, String path, String method,
//                                      Map<String, String> headers,
//                                      Map<String, String> querys,
//                                      byte[] body)
//            throws Exception {
//        HttpClient httpClient = wrapClient(host);
//
//        HttpPost request = new HttpPost(buildUrl(host, path, querys));
//        for (Map.Entry<String, String> e : headers.entrySet()) {
//            request.addHeader(e.getKey(), e.getValue());
//        }
//
//        if (body != null) {
//            request.setEntity(new ByteArrayEntity(body));
//        }
//
//        return httpClient.execute(request);
//    }


//    public static HttpResponse doPut(String host, String path, String method,
//                                     Map<String, String> headers,
//                                     Map<String, String> querys,
//                                     String body)
//            throws Exception {
//        HttpClient httpClient = wrapClient(host);
//
//        HttpPut request = new HttpPut(buildUrl(host, path, querys));
//        for (Map.Entry<String, String> e : headers.entrySet()) {
//            request.addHeader(e.getKey(), e.getValue());
//        }
//
//        if (StringUtils.isNotBlank(body)) {
//            request.setEntity(new StringEntity(body, "utf-8"));
//        }
//
//        return httpClient.execute(request);
//    }


//    public static HttpResponse doPut(String host, String path, String method,
//                                     Map<String, String> headers,
//                                     Map<String, String> querys,
//                                     byte[] body)
//            throws Exception {
//        HttpClient httpClient = wrapClient(host);
//
//        HttpPut request = new HttpPut(buildUrl(host, path, querys));
//        for (Map.Entry<String, String> e : headers.entrySet()) {
//            request.addHeader(e.getKey(), e.getValue());
//        }
//
//        if (body != null) {
//            request.setEntity(new ByteArrayEntity(body));
//        }
//
//        return httpClient.execute(request);
//    }


//    public static HttpResponse doDelete(String host, String path, String method,
//                                        Map<String, String> headers,
//                                        Map<String, String> querys)
//            throws Exception {
//        HttpClient httpClient = wrapClient(host);
//
//        HttpDelete request = new HttpDelete(buildUrl(host, path, querys));
//        for (Map.Entry<String, String> e : headers.entrySet()) {
//            request.addHeader(e.getKey(), e.getValue());
//        }
//
//        return httpClient.execute(request);
//    }

    private static String buildUrl(String host, String path, Map<String, String> querys) throws UnsupportedEncodingException {
        StringBuilder sbUrl = new StringBuilder();
        sbUrl.append(host);
        if (!StringUtils.isBlank(path)) {
            sbUrl.append(path);
        }
        if (null != querys) {
            StringBuilder sbQuery = new StringBuilder();
            for (Map.Entry<String, String> query : querys.entrySet()) {
                if (0 < sbQuery.length()) {
                    sbQuery.append("&");
                }
                if (StringUtils.isBlank(query.getKey()) && !StringUtils.isBlank(query.getValue())) {
                    sbQuery.append(query.getValue());
                }
                if (!StringUtils.isBlank(query.getKey())) {
                    sbQuery.append(query.getKey());
                    if (!StringUtils.isBlank(query.getValue())) {
                        sbQuery.append("=");
                        sbQuery.append(URLEncoder.encode(query.getValue(), "utf-8"));
                    }
                }
            }
            if (0 < sbQuery.length()) {
                sbUrl.append("?").append(sbQuery);
            }
        }

        return sbUrl.toString();
    }

//    private static HttpClient wrapClient(String host) {
//        HttpClient httpClient = new DefaultHttpClient();
//        if (host.startsWith("https://")) {
//            sslClient(httpClient);
//        }
//
//        return httpClient;
//
//
//    }

//    private static void sslClient(HttpClient httpClient) {
//        try {
//            SSLContext ctx = SSLContext.getInstance("TLS");
//            X509TrustManager tm = new X509TrustManager() {
//                public X509Certificate[] getAcceptedIssuers() {
//                    return null;
//                }
//                public void checkClientTrusted(X509Certificate[] xcs, String str) {
//
//                }
//                public void checkServerTrusted(X509Certificate[] xcs, String str) {
//
//                }
//            };
//            ctx.init(null, new TrustManager[] { tm }, null);
// //           SSLConnectionSocketFactory ssf = new SSLConnectionSocketFactory(ctx);
//            SSLSocketFactory ssf = new SSLSocketFactory(ctx);
//
//            ssf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
//            ClientConnectionManager ccm = httpClient.getConnectionManager();
//            SchemeRegistry registry = ccm.getSchemeRegistry();
//            registry.register(new Scheme("https",  ssf, 443));
//
//
//        } catch (KeyManagementException ex) {
//            throw new RuntimeException(ex);
//        } catch (Exception ex) {
//            throw new RuntimeException(ex);
//        }
//
//    }

    public static String retrieveResponseFromServer(String host, String path, String method,
                                                    Map<String, String> headers,
                                                    Map<String, String> querys)
            throws Exception {


        HttpURLConnection connection = null;
        try {
            HostnameVerifier hv = new HostnameVerifier() {
                public boolean verify(String urlHostName, SSLSession session) {
                    System.out.println("Warning: URL Host: " + urlHostName + " vs. " + session.getPeerHost());
                    return true;
                }
            };
            String urlString = buildUrl(host, path, querys);
            trustAllHttpsCertificates();
            HttpsURLConnection.setDefaultHostnameVerifier(hv);

            URL validationUrl = new URL(urlString);
            connection = (HttpURLConnection) validationUrl.openConnection();
            connection.setRequestProperty("Authorization", "APPCODE 2b6dc224e43c40c6a01ee7028ff617ca");

            for (Map.Entry<String, String> e : headers.entrySet()) {
                connection.setRequestProperty(e.getKey(), e.getValue());
            }


            final BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line;
            final StringBuffer stringBuffer = new StringBuffer(255);

            synchronized (stringBuffer) {
                while ((line = in.readLine()) != null) {
                    stringBuffer.append(line);
                    stringBuffer.append("\n");
                }
                System.out.println(stringBuffer.toString());
                return stringBuffer.toString();
            }

        } catch (final IOException e) {
            e.printStackTrace();
            return null;
        } catch (final Exception e1) {

            e1.printStackTrace();
            return null;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }


    }


    private static void trustAllHttpsCertificates() throws Exception {
        javax.net.ssl.TrustManager[] trustAllCerts = new javax.net.ssl.TrustManager[1];
        javax.net.ssl.TrustManager tm = new miTM();
        trustAllCerts[0] = tm;
        javax.net.ssl.SSLContext sc = javax.net.ssl.SSLContext
                .getInstance("SSL");
        sc.init(null, trustAllCerts, null);
        javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(sc
                .getSocketFactory());
    }

    static class miTM implements javax.net.ssl.TrustManager,
            javax.net.ssl.X509TrustManager {
        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public boolean isServerTrusted(
                java.security.cert.X509Certificate[] certs) {
            return true;
        }

        public boolean isClientTrusted(
                java.security.cert.X509Certificate[] certs) {
            return true;
        }

        public void checkServerTrusted(
                java.security.cert.X509Certificate[] certs, String authType)
                throws java.security.cert.CertificateException {
            return;
        }

        public void checkClientTrusted(
                java.security.cert.X509Certificate[] certs, String authType)
                throws java.security.cert.CertificateException {
            return;
        }
    }
}
