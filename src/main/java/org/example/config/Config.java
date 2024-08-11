package org.example.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    private static final Properties properties = new Properties();
    private static final String URL;
    private static final int WAIT_TIME;

    static {
        try (InputStream input = Config.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("config.properties 파일을 찾을 수 없습니다.");
            }
            properties.load(input);

            // 프로퍼티 값들을 캐싱
            URL = properties.getProperty("URL");
            WAIT_TIME = Integer.parseInt(properties.getProperty("WAIT_TIME"));

        } catch (IOException ex) {
            ex.printStackTrace();
            throw new RuntimeException("설정 파일을 로드하는 중 오류가 발생했습니다.", ex);
        }
    }

    public static String getUrl() {
        return URL;
    }

    public static int getWaitTime() {
        return WAIT_TIME;
    }
}