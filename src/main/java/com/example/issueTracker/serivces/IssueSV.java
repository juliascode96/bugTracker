package com.example.issueTracker.serivces;

import com.example.issueTracker.Entity.Issue;
import com.example.issueTracker.Entity.IssuePriority;
import com.example.issueTracker.Entity.IssueStatus;
import com.example.issueTracker.repository.IssueRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;

@Service
public class IssueSV implements IssueService{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IssueRepository issueRepository;

    @Override
    public List<Issue> findAll() {
        logger.info("> findAll");

        List<Issue> issues = issueRepository.findAll();

        logger.info("< findAll");
        return issues;
    }

    @Override
    public Issue create(Issue issue) {
        logger.info("> create");

       issue.setStatus(IssueStatus.OPEN);

       if(issue.getPriority() == null) {
           issue.setPriority(IssuePriority.MEDIUM);
       }

       Issue persistedIssue = issueRepository.save(issue);

        logger.info("< create");
        return persistedIssue;
    }

    @Override
    public Issue find(Long id) {
        return null;
    }

    public Optional<Issue> findId(Long id){
        return issueRepository.findById(id);
    }

    public List<Issue> findByPriority(String priority){
        return issueRepository.findByPriority(priority);
    }

    public List<Issue> findByStatus(String status){
        return issueRepository.findByStatus(status);
    }

    public List<Issue> findByType(String type){
        return issueRepository.findByType(type);
    }

    @Override
    public Issue update(Issue issue) {
        logger.info("> update");
        Issue updatedIssue = issueRepository.save(issue);
        logger.info("< update");
        return updatedIssue;
    }

    @Override
    public boolean delete(Long id) {
        try {
            issueRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
