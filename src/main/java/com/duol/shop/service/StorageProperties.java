package com.duol.shop.service;

import org.springframework.stereotype.Component;

/**
 * @author Duolaimon
 *         17-5-2 下午1:02
 */
@Component
public class StorageProperties {
    private String location = "/home/deity/sh/upload-dir";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
