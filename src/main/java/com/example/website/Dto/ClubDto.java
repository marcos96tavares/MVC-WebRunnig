package com.example.website.Dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Builder
@Getter
@Setter
public class ClubDto {

    private Long clubId;
    private String clubTitle;
    private String clubPhotoUrl;
    private String clubContent;
    private LocalDateTime clubCreateOn;
    private LocalDateTime clubUpdateOn;

}
