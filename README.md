# custom-metrics

Spring boot project to create a custom metric on prometheus and create dashboards on grafana

## How to run

Enter on docker folder and run docker compose: 
```
cd ./src/main/resources/docker/
docker-compose up
```

Two applications are going to start.

| Application | URL |
|-------------|------|
|Prometheus | http://localhost:9090 |
|Grafana | http://localhost:3000 |

Prometheus monitors spring boot application.
Grafana visualizes prometheus data source.

**Start this spring application.**

## Set up grafana's data source

You can log in to Grafana by `admin/admin`.
Set up prometheus data source as follows.

|item| value                                            |
|---|--------------------------------------------------|
|Type| Prometheus                                       |
|URL| http://localhost:9090 or http://host.docker.internal:9090 |
|Scrap interval|5s|

## Create grafana's dashboard

Add a dashboard and a new visualization.

Count the sum of 'counter_metric_total' metric by a range period:

```
sum(increase(counter_metric_total[$__range]))
```




