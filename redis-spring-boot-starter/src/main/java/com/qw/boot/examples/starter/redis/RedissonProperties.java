package com.qw.boot.examples.starter.redis;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author qiwu
 */
@ConfigurationProperties(prefix = "qw.redisson")
public class RedissonProperties {
    private String host = "localhost";
    private int port = 6379;
    private int timeout;//超时时间
    private boolean ssl;//是否加密传输

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public boolean isSsl() {
        return ssl;
    }

    public void setSsl(boolean ssl) {
        this.ssl = ssl;
    }
}