package br.com.isaquebrb.custommetrics.service;

import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class CounterMetricService {

    @Value("${custom-metrics.counter.name}")
    private String counterMetricName;

    private final List<String> metricLabels = List.of("label1", "label2", "label3");

    private final MeterRegistry meterRegistry;

    //Run every second
    @Scheduled(fixedRateString = "1000", initialDelayString = "0")
    public void runTask() {
        meterRegistry.counter(counterMetricName, "label-name", getRandomLabel()).increment();
    }

    public void runTask(int incrementNumber) {
        for (int x = 0; x < incrementNumber; x++) {
            meterRegistry.counter(counterMetricName, "label-name", getRandomLabel()).increment();
        }
    }

    private String getRandomLabel() {
        Random randomIndex = new SecureRandom();
        return metricLabels.get(randomIndex.nextInt(metricLabels.size()));
    }
}
