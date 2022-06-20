package com.playground.net;

import java.net.URI;

public class NetTest {
    public static void main(String[] args) {
        String library = String.format("%s%s", "http://www.baidu.com/////", "library");
        URI uri = URI.create(library);

        System.out.println(uri.getHost());
    }
}

