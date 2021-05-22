package org.example.controller;

import lombok.Data;

@Data
public class LogMessage {
    private int httpStatus;
    private String httpMethod;
    private String responsePayload;
    private String javaMethod;
    private String clientIp;
    private String path;
    private String method;
    private String response;

    @Override
    public String toString() {
        return "{" +
                "httpStatus=" + httpStatus +
                ", httpMethod='" + httpMethod + '\'' +
                ", responsePayload='" + responsePayload + '\'' +
                ", javaMethod='" + javaMethod + '\'' +
                ", clientIp='" + clientIp + '\'' +
                ", path='" + path + '\'' +
                ", method='" + method + '\'' +
                '}';
    }
}
