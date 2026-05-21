package br.com.dequebra.fintech.controller;

import br.com.dequebra.fintech.model.Goal;
import br.com.dequebra.fintech.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/goals")
public class GoalController {

    @Autowired
    private GoalService goalService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Goal save(@RequestBody Goal goal) { return goalService.save(goal); }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Goal findById(@PathVariable Long id) { return goalService.findGoalById(id); }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Goal> findAll() { return goalService.findAll(); }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { goalService.delete(id); }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Goal update(@PathVariable Long id, @RequestBody Goal goal){
        return goalService.update(id,goal);
    }

}
