package com.qp.ots;

import java.util.HashMap;

/**
 * @author Listen.Li
 */
public class ReqBody {
    private String version;
    private String token;
    private String channelId;
    private HashMap payload;
    private Device device;

    public static ReqBody getIns() {
        return new ReqBody();
    }

    public void setPayload(HashMap payload) {
        this.payload = payload;
    }

    public HashMap getPayload() {
        return payload;
    }

    static class Device {
        private String deviceID;

        public String getDeviceID() {
            return deviceID;
        }

        public void setDeviceID(String deviceID) {
            this.deviceID = deviceID;
        }
    }
}
