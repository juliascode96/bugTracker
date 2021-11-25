package com.example.issueTracker.serivces;

import com.example.issueTracker.Entity.Issue;

import java.util.List;

public interface IssueService {
    List<Issue> findAll();

    Issue create(Issue issue);

    Issue find(Long id);

    Issue update(Issue issue);

    boolean delete(Long id);
}
