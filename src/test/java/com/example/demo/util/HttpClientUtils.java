package com.example.demo.util;

import org.apache.http.*;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.ServiceUnavailableRetryStrategy;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Map;

/**
 * @Author zhangzhiyong
 * @Description TODO
 * Date Created in 2019-08-30
 **/
@Component
public class HttpClientUtils {
    private static final Logger logger = LoggerFactory.getLogger(HttpClientUtils.class);


    private static  Integer TRY_TIMES = 3;

    private static Long retryInterval = 1000L;

    private static Integer readTimeout = 1000;

    private static Integer connectTimeout = 5000;

//    @Value("${http.retryTimes}")
//    public void setTRY_TIMES(Integer TRY_TIMES) {
//        HttpClientUtils.TRY_TIMES = TRY_TIMES;
//    }
//
//    @Value("${http.retryInterval}")
//    public void setRetryInterval(Long retryInterval) {
//        HttpClientUtils.retryInterval = retryInterval;
//    }
//
//    @Value("${http.readTimeout}")
//    public void setReadTimeout(Integer readTimeout) {
//        HttpClientUtils.readTimeout = readTimeout;
//    }
//
//    @Value("${http.connectTimeout}")
//    public void setConnectTimeout(Integer connectTimeout) {
//        HttpClientUtils.connectTimeout = connectTimeout;
//    }

    /**
     * @Author yiche
     * @Description
     * @Date 15:37 2019-08-30
     * @Param [urlAddr, connectTimeout, readTimeout]
     * @return java.lang.String
     **/
    public static String doGet(String urlAddr) {
        ServiceUnavailableRetryStrategy serviceUnavailableRetryStrategy = new HttpRetryStrategy.Builder()
                .executionCount(TRY_TIMES).retryInterval(retryInterval).build();
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(connectTimeout).setConnectionRequestTimeout(1000)
                .setSocketTimeout(readTimeout).build();
        HttpRequestRetryHandler retryHandler = getHttpRequestRetryHandler();
        CloseableHttpClient httpclient = HttpClientBuilder.create().setRetryHandler(retryHandler)
                .setServiceUnavailableRetryStrategy(serviceUnavailableRetryStrategy).setConnectionManager(new PoolingHttpClientConnectionManager())
                .setDefaultRequestConfig(requestConfig).build();
        String result = null;
        URIBuilder uriBuilder;
        try {
            uriBuilder = new URIBuilder(urlAddr);
            HttpGet httpGet = new HttpGet(uriBuilder.build());
            httpGet.setConfig(requestConfig);
            HttpResponse response = httpclient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            if(entity!=null) {
                result = EntityUtils.toString(entity,"UTF-8");
            }
        } catch (Exception e1) {
            logger.error("doGet:"+urlAddr+"; ex:", e1);
        }
        return result;
    }

    public static String doGet(String urlAddr,Map<String,String> paramsMap,int connectTimeout, int readTimeout) {
        ServiceUnavailableRetryStrategy serviceUnavailableRetryStrategy = new HttpRetryStrategy.Builder()
                .executionCount(TRY_TIMES).retryInterval(retryInterval).build();
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(connectTimeout).setConnectionRequestTimeout(1000)
                .setSocketTimeout(readTimeout).build();
        HttpRequestRetryHandler retryHandler = getHttpRequestRetryHandler();
        CloseableHttpClient httpclient = HttpClientBuilder.create().setRetryHandler(retryHandler)
                .setServiceUnavailableRetryStrategy(serviceUnavailableRetryStrategy).setConnectionManager(new PoolingHttpClientConnectionManager())
                .setDefaultRequestConfig(requestConfig).build();
        String result = null;
        URIBuilder uriBuilder;
        try {
            uriBuilder = new URIBuilder(urlAddr);
            for (Map.Entry<String, String> entry : paramsMap.entrySet()) {
                uriBuilder.addParameter(entry.getKey(), entry.getValue());
            }
            HttpGet httpGet = new HttpGet(uriBuilder.build());
            httpGet.setConfig(requestConfig);
            HttpResponse response = httpclient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            if(entity!=null) {
                result = EntityUtils.toString(entity,"UTF-8");
            }
        } catch (Exception e1) {
            logger.error("doGet:"+urlAddr+"; ex:", e1);
        }
        return result;
    }


    public static String doPost(String url,String json) {
        CloseableHttpClient httpclient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(url);
        String result = null;
        try {
            httpPost.setEntity(new StringEntity(json,"UTF-8"));
            HttpResponse response = httpclient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            if(entity!=null) {
                result = EntityUtils.toString(entity, "UTF-8");
            }
        } catch (IOException e) {
            logger.error("doPost:"+url+"; ex:", e);
        }
        return result;
    }
        /**
         * 获取Exception重试控制器
         * 设置重试次数
         * @return
         */
    private static HttpRequestRetryHandler getHttpRequestRetryHandler() {
        return new HttpRequestRetryHandler() {
            public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
                if (executionCount > TRY_TIMES) //超过重试次数，就放弃
                   return false;
                if (exception instanceof NoHttpResponseException) {//没有响应，重试`
                    return true;
                } else if (exception instanceof SSLHandshakeException) {//本地证书异常
                    return false;
                } else if (exception instanceof SocketTimeoutException) {//读取线上数据超时 重试
                    return true;
                } else if (exception instanceof ConnectTimeoutException) {//连接超时，重试
                    return true;
                }else if (exception instanceof InterruptedIOException) {//被中断
                    return false;
                } else if (exception instanceof UnknownHostException) {//找不到服务器
                    return false;
                } else if (exception instanceof SSLException) {//SSL异常
                    return false;
                } else {
                    //output("未记录的请求异常：" + exception.getClass());
                }
                HttpClientContext clientContext = HttpClientContext.adapt(context);
                HttpRequest request = clientContext.getRequest();
                // 如果请求是幂等的，则重试
                if (!(request instanceof HttpEntityEnclosingRequest)) return true;
                return false;
            }
        };
    }


}