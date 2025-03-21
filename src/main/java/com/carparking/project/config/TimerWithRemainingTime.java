package com.carparking.project.config;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class TimerWithRemainingTime {
    public static void main(String[] args) {

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime endTime = LocalDateTime.of(2025, 3 ,20, 23, 0, 0);


        LocalDateTime end = endTime;
        long timeLeft = Duration.between(now, end).toHours();
        if (timeLeft > 0) {
            System.out.println("Time left: " + timeLeft);
        } else {
            System.out.println("Time's up!");
        }
    }


}
