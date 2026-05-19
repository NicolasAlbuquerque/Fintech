package br.com.dequebra.fintech.controller;

import br.com.dequebra.fintech.model.Expense;
import br.com.dequebra.fintech.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    //--> MÉTODO RESPONSÁVEL POR CRIAR UMA NOVA EXPENSE NO BANCO DE DADOS
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Expense save(@RequestBody Expense expense){
        return expenseService.save(expense);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Expense findById(@PathVariable Long id){
        return expenseService.findExpenseById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Expense> findAll(){
        return expenseService.findAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        expenseService.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Expense update(@PathVariable Long id, @RequestBody Expense expense){
        return expenseService.update(id, expense);
    }

}
