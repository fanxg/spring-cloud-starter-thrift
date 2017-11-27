package com.icekredit.rpc.thrift.examples.service.http.service.impl;

import com.icekredit.rpc.thrift.examples.service.http.service.TestService;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Random;

@Service
public class TestServiceImpl implements TestService {

    private final byte[] KEY = {
            0x01, 0x23, 0x45, 0x67,
            (byte) 0x89, (byte) 0xab,
            (byte) 0xcd, (byte) 0xef,
            (byte) 0xfe, (byte) 0xdc,
            (byte) 0xba, (byte) 0x98,
            0x76, 0x54, 0x32, 0x10
    };

    @Override
    public String test(int length) {
        byte[] bytes = new byte[length * 1024];
        Random random = new Random();

        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = KEY[random.nextInt(KEY.length)];
        }

        try {
            return new String(bytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
