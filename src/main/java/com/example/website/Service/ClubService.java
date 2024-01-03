package com.example.website.Service;

import com.example.website.Dto.ClubDto;
import com.example.website.Entity.Club;

import java.util.List;

public interface ClubService {

    List<ClubDto> findAllClubs();
    Club saveClub(Club club);

    ClubDto findClubId(Long cludId);

    void updateClub(ClubDto club);

    void delete(long clubId);

    List<ClubDto> searchClubs(String query);
}
