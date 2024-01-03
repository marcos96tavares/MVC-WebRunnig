package com.example.website.Repository;

import com.example.website.Entity.Club;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ClubRepository extends JpaRepository<Club, Long> {


    Optional<Club> findByClubTitle(String url);

    @Query("SELECT c from Club c WHERE c.clubTitle like concat('%', :query, '%')")
    List<Club> searchClubs( String query);
}
