package com.example.website.Dto;

import com.example.website.Entity.Club;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@Builder
public class EventDto {



    private Long eventId;
    private String eventName;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime eventStartTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime eventEndtime;
    private String eventType;
    private String eventPhotoUrl;
    private LocalDateTime eventCreateOn;
    private LocalDateTime eventUpdateOn;

}


