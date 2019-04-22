package com.imooc.apigateway.callback;

import com.netflix.hystrix.exception.HystrixTimeoutException;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 对指定应用设定访问应用出问题的回调类
 */
@Component
class MyFallbackProvider implements FallbackProvider {

    @Override
    public String getRoute() {
        return "user";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, final Throwable cause) {
        System.err.println(1);
        if (cause instanceof HystrixTimeoutException) {
            return response(HttpStatus.GATEWAY_TIMEOUT);
        } else {
            return response(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private ClientHttpResponse response(final HttpStatus status) {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                System.err.println(2);
                return status;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                System.err.println(3);
                return status.value();
            }

            @Override
            public String getStatusText() throws IOException {
                System.err.println(4);
                return status.getReasonPhrase();
            }

            @Override
            public void close() {
                System.err.println(5);
            }

            @Override
            public InputStream getBody() throws IOException {
                System.err.println(6);
                return new ByteArrayInputStream("fallback：响应失败....".getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                System.err.println(7);
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }
        };
    }
}