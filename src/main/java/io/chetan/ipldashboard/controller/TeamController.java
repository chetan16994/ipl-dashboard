package io.chetan.ipldashboard.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.chetan.ipldashboard.model.Team;
import io.chetan.ipldashboard.repository.MatchRepository;
import io.chetan.ipldashboard.repository.TeamRepository;

@RestController
public class TeamController {

    private TeamRepository teamRepository;
    private MatchRepository matchRepository;

    public TeamController(TeamRepository teamRepository, MatchRepository matchRepository) {
        this.teamRepository = teamRepository;
        this.matchRepository=matchRepository;
    }

    @GetMapping("/team/{teamName}")
    public Team getTeam(@PathVariable String teamName){
        Team team=this.teamRepository.findByTeamName(teamName);
        team.setMatches(matchRepository.getByTeam1OrTeam2(teamName, teamName));
        return team;
    }
}
