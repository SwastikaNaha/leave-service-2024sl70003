package com.bits;

import com.sun.net.httpserver.HttpServer;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class LeaveServiceApp {
    public static void main(String[] args) throws Exception {
        String env = System.getenv("APP_ENV");
        if (env == null || env.isEmpty()) env = "local";

        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        final String response = "Employee Leave Service running in environment: " + env;
        server.createContext("/", exchange -> {
            exchange.sendResponseHeaders(200, response.getBytes().length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response.getBytes());
            }
        });
        server.setExecutor(null);
        server.start();
        System.out.println(response + " on port 8080");
    }
}
