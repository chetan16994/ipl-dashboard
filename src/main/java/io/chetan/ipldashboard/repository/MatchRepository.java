package io.chetan.ipldashboard.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import io.chetan.ipldashboard.model.Match;

public interface MatchRepository extends CrudRepository<Match, Long> {
    List<Match> getByTeam1OrTeam2(String teamName1, String teamName2);
}
