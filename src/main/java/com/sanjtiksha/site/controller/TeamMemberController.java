package com.sanjtiksha.site.controller;

import com.sanjtiksha.site.entity.TeamMember;
import com.sanjtiksha.site.repository.TeamMemberRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/team")
public class TeamMemberController {

    private final TeamMemberRepository teamMemberRepository;

    public TeamMemberController(TeamMemberRepository teamMemberRepository) {
        this.teamMemberRepository = teamMemberRepository;
    }

    // GET /api/team → list all team members
    @GetMapping
    public List<TeamMember> getAllTeamMembers() {
        return teamMemberRepository.findAll();
    }

    // POST /api/team → add new team member
    @PostMapping
    public TeamMember createTeamMember(@RequestBody TeamMember member) {
        return teamMemberRepository.save(member);
    }
}
