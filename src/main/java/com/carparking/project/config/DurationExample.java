package com.carparking.project.config;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DurationExample {
        public static void main(String[] args) {
            String durationStr = "3h 30m 60s"; // Example input

            LocalDateTime now = LocalDateTime.now();
            LocalDateTime newDateTime = addCustomDuration(now, durationStr);

            System.out.println("Current Time: " + now);
            System.out.println("Updated Time: " + newDateTime);
        }

        public static LocalDateTime addCustomDuration(LocalDateTime dateTime, String durationStr) {
            Pattern pattern = Pattern.compile("(\\d+)([hms])"); // Regex to extract hours, minutes, seconds
            Matcher matcher = pattern.matcher(durationStr);

            while (matcher.find()) {
                int value = Integer.parseInt(matcher.group(1));
                String unit = matcher.group(2);

                switch (unit) {
                    case "h": dateTime = dateTime.plus(value, ChronoUnit.HOURS); break;
                    case "m": dateTime = dateTime.plus(value, ChronoUnit.MINUTES); break;
                    case "s": dateTime = dateTime.plus(value, ChronoUnit.SECONDS); break;
                }
            }
            return dateTime;
        }
    }





