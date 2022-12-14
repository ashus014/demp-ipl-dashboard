package com.singashi.ipldashboard.repository;

import com.singashi.ipldashboard.model.Match;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchRepository extends CrudRepository<Match, Long> {

    List<Match> getByTeam1OrTeam2OrderByDateDesc(String teamName1, String teamName2, Pageable pageSize);

    default List<Match> findLatestMatchesByTeam(String teamName, int count) {
        // using pageable to set the size of no. of records we want
        return getByTeam1OrTeam2OrderByDateDesc(teamName,teamName, PageRequest.of(0, count));
    }
}
