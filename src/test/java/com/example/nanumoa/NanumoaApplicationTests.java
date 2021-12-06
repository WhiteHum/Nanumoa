package com.example.nanumoa;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;

@SpringBootTest
@PropertySource("classpath:config.properties")
class NanumoaApplicationTests {

    @Test
    void contextLoads() {
    }

}
