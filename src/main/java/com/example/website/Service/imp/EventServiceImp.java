package com.example.website.Service.imp;

import com.example.website.Dto.EventDto;
import com.example.website.Entity.Club;
import com.example.website.Entity.Event;
import com.example.website.Repository.ClubRepository;
import com.example.website.Repository.EventRepository;
import com.example.website.Service.EventService;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImp implements EventService {

    private EventRepository eventRepository;
    private ClubRepository clubRepository;

    public EventServiceImp(EventRepository eventRepository, ClubRepository clubRepository) {
        this.eventRepository = eventRepository;
        this.clubRepository = clubRepository;
    }

    @Override
    public void createEvent(Long clubId, EventDto eventDto) {
        Club club = clubRepository.findById(clubId).get();
        Event event = mapToEvent(eventDto);
        event.setClub(club);
        eventRepository.save(event);

    }

    private Event mapToEvent(EventDto eventDto){

        return Event.builder()
                .eventId(eventDto.getEventId())
                .eventName(eventDto.getEventName())
                .eventStartTime(eventDto.getEventStartTime())
                .eventEndtime(eventDto.getEventEndtime())
                .eventType(eventDto.getEventType())
                .eventPhotoUrl(eventDto.getEventPhotoUrl())
                .eventCreateOn(eventDto.getEventCreateOn())
                .eventUpdateOn(eventDto.getEventUpdateOn())
                .build();
    }
}
