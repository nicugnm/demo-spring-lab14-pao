package net.pao.laboratorpao.threads;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@Async
public class ThreadExample {


    @Scheduled(fixedRate = 1000) // miliseconds)
    public void exampleMethod() {
        System.out.println("hello !!!");
    }
}
