package com.example.issueTracker.controller;

import com.example.issueTracker.Entity.Issue;
import com.example.issueTracker.serivces.IssueSV;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/issue")

public class Controller {
    @Autowired
    IssueSV issueSV;

    @GetMapping
    public List<Issue> findIssues(){
        return issueSV.findAll();
    }

    @PostMapping
    public Issue saveIssue(@RequestBody Issue issue){
        return issueSV.create(issue);
    }

    @GetMapping( path = "/{id}")
    public Optional<Issue> findById(@PathVariable("id") Long id){
        return this.issueSV.findId(id);
    }

    @GetMapping("/priority")
    public List<Issue> findByPriority(@RequestParam("priority") String priority){
        return this.issueSV.findByPriority(priority);
    }

    @GetMapping("/status")
    public List<Issue> findByStatus(@RequestParam("status") String status){
        return this.issueSV.findByStatus(status);
    }

    @GetMapping("/type")
    public List<Issue> findByType(@RequestParam("type") String type){
        return this.issueSV.findByType(type);
    }
    

    @DeleteMapping( path = "/{id}")
    public String deleteIssue(@PathVariable("id") Long id){
        boolean ok = this.issueSV.delete(id);
        if(ok){
            return id + "deleted";
        } else {
            return "Can't delete " + id;
        }
    }
}
