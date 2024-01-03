package com.example.website.Controller;

import com.example.website.Dto.ClubDto;
import com.example.website.Entity.Club;
import com.example.website.Service.ClubService;
import com.example.website.Service.imp.ClubServiceImp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClubController {

    private final ClubService clubService;

    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping("/clubs")
    public String listClubs(Model model){
        List<ClubDto> clubDtos = clubService.findAllClubs();
        model.addAttribute("clubs", clubDtos);
        return "clubs-list";
    }

    @GetMapping("/clubs/new")
    public String createClubFrom(Model model){
        Club club = new Club();
        model.addAttribute("club", club);
        return "clubs-create";
    }

    @PostMapping("/clubs/new")
    public String saveClub(@ModelAttribute("club") Club club){
        clubService.saveClub(club);
        return "redirect:/clubs";
    }


    /**
     * This will controller the view button
     * @param clubId
     * @param model
     * @return
     */
    @GetMapping("/clubs/{clubId}")
    public String clubDetail(@PathVariable("clubId") long clubId , Model model){
        ClubDto clubDto = clubService.findClubId(clubId);
        model.addAttribute("club", clubDto);
        return "clubs-detail";
    }

    /**
     * This will controller the edit
     * @param clubId
     * @param model
     * @return
     */
    @GetMapping("/clubs/{clubId}/edit")
    public String editClub(@PathVariable("clubId") Long clubId , Model model){
        ClubDto clubDto = clubService.findClubId(clubId);
        model.addAttribute("club", clubDto);
        return "club-edit";

    }


    @PostMapping("/clubs/{clubId}/edit")
    public String udpateClub(@PathVariable("clubId") Long clubId, @ModelAttribute("club") ClubDto club){
        club.setClubId(clubId);
        clubService.updateClub(club);
        return "redirect:/clubs";
    }


    @GetMapping("/clubs/{clubId}/delete")
    public String deleteClub(@PathVariable("clubId") long clubId){
        clubService.delete(clubId);
        return "redirect:/clubs";

    }

    @GetMapping("/clubs/search")
    public String searchClub(@RequestParam(value = "query") String query, Model model){

        List<ClubDto> clubs = clubService.searchClubs(query);
        model.addAttribute("club", clubs);
        return "clubs-list";

    }





}
