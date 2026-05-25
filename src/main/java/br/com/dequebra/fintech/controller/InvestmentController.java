package br.com.dequebra.fintech.controller;

import br.com.dequebra.fintech.model.Investment;
import br.com.dequebra.fintech.service.InvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/investments")
public class InvestmentController {

    @Autowired
    private InvestmentService investmentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Investment save(@RequestBody Investment investment) {
        return investmentService.save(investment);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Investment findById(@PathVariable Long id) {
        return investmentService.findInvestmentById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Investment> findAll() {
        return investmentService.findAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        investmentService.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Investment update(@PathVariable Long id, @RequestBody Investment investment) {
        return investmentService.update(id, investment);
    }
}