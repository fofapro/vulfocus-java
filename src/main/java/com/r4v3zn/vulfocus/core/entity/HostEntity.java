package com.r4v3zn.vulfocus.core.entity;

/**
 * Title: HostEntity
 * Desc: Host Entity
 * Date:2021/11/25 21:55
 * Email:woo0nise@gmail.com
 * Company:www.r4v3zn.com
 *
 * @author R4v3zn
 * @version 1.0.0
 */
public class HostEntity {

    /**
     * host
     */
    private String host;

    /**
     * port
     */
    private String port;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "HostEntity{" +
                "host='" + host + '\'' +
                ", port='" + port + '\'' +
                '}';
    }
}
