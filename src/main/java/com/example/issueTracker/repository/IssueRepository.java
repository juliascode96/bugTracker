package com.example.issueTracker.repository;

import com.example.issueTracker.Entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Long> {
    public abstract List<Issue> findByPriority(String p);

    public abstract List<Issue> findByStatus(String s);

    public abstract List<Issue> findByType(String t);

}
