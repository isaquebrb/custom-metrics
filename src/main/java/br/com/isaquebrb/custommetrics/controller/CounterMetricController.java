package br.com.isaquebrb.custommetrics.controller;

import br.com.isaquebrb.custommetrics.service.CounterMetricService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/metric/counter")
@RequiredArgsConstructor
public class CounterMetricController {

    private final CounterMetricService service;

    @GetMapping("/add/{incrementNumber}")
    public ResponseEntity<Void> addMetric(@PathVariable int incrementNumber){
        service.runTask(incrementNumber);
        return ResponseEntity.noContent().build();
    }
}
