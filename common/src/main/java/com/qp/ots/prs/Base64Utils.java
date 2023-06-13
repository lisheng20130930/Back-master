package com.qp.ots.prs;

import java.util.Base64;

public class Base64Utils {
    public static String encode(String s) throws Exception {
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] textByte = s.getBytes("UTF-8");
        return encoder.encodeToString(textByte);
    }

    public static String decode(String s) throws Exception {
        Base64.Decoder decoder = Base64.getDecoder();
        return new String(decoder.decode(s), "UTF-8");
    }
}
