package com.example.website.Service;

import com.example.website.Dto.EventDto;

public interface EventService {

    void createEvent(Long clubId, EventDto eventDto);
}
