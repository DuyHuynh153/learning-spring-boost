package com.example.firstApp.run;

import java.time.LocalDateTime;

public record Run(
        int id,
        String title,
        LocalDateTime startedOn,
        LocalDateTime completedOn,
        Integer miles,
        Location location


) {
}
