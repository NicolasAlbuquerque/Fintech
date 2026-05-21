package br.com.dequebra.fintech.controller;

import br.com.dequebra.fintech.model.Income;
import br.com.dequebra.fintech.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/incomes")
public class IncomeController {

    @Autowired
    private IncomeService incomeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Income save(@RequestBody Income income) {
        return incomeService.save(income);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Income findById(@PathVariable Long id) {
        return incomeService.findIncomeById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Income> findAll() {
        return incomeService.findAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        incomeService.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Income update(@PathVariable Long id, @RequestBody Income income) {
        return incomeService.update(id, income);
    }
}