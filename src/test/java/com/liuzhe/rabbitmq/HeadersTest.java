package com.liuzhe.rabbitmq;

import com.liuzhe.rabbitmq.direct.DirectSender;
import com.liuzhe.rabbitmq.headers.HeadersSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Alan on 2018/8/24.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HeadersTest {

    @Autowired
    HeadersSender sender;

    @Test
    public void testSend() {
        sender.send();
    }
}
