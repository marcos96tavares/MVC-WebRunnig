package com.example.website.Service.imp;

import com.example.website.Dto.ClubDto;
import com.example.website.Entity.Club;
import com.example.website.Repository.ClubRepository;
import com.example.website.Service.ClubService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ClubServiceImp implements ClubService {

   private final ClubRepository clubRepository;

    public ClubServiceImp(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Override
    public List<ClubDto> findAllClubs() {

        List<Club> clubs = clubRepository.findAll();

        return clubs.stream().map(this::mapToClubDto).collect(Collectors.toList());
    }

    @Override
    public Club saveClub(Club club) {
        return clubRepository.save(club);
    }



    @Override
    public ClubDto findClubId(Long clubid) {
        Club club = clubRepository.findById(clubid).get();
        return mapToClubDto(club);
    }

    @Override
    public void updateClub(ClubDto club) {

        Club club1 = mapToClub(club);
        clubRepository.save(club1);

    }

    @Override
    public void delete(long clubId) {
        clubRepository.deleteById(clubId);
    }

    @Override
    public List<ClubDto> searchClubs(String query) {
        List<Club> clubs = clubRepository.searchClubs(query);
         return clubs.stream().map(this::mapToClubDto).collect(Collectors.toList());
    }

    private Club mapToClub(ClubDto club){

        Club club1 = Club.builder()
                .clubId(club.getClubId())
                .clubTitle(club.getClubTitle())
                .clubContent(club.getClubContent())
                .clubCreateOn(club.getClubCreateOn())
                .clubPhotoUrl(club.getClubPhotoUrl())
                .build();

        return club1;
    }


    /**
     * This is method will convert the club to clubDto for data protection
     * @param club
     * @return
     */
    private ClubDto mapToClubDto(Club club){

        ClubDto clubDto = ClubDto.builder()
                .clubId(club.getClubId())
                .clubTitle(club.getClubTitle())
                .clubContent(club.getClubContent())
                .clubCreateOn(club.getClubCreateOn())
                .clubPhotoUrl(club.getClubPhotoUrl())
                .build();

        return clubDto;
    }

}
