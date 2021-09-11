# SpringBoot 

## pom

```xml
<properties>
  <prometheus.version>1.7.3</prometheus.version>
</properties>
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
<dependency>
  <groupId>io.micrometer</groupId>
  <artifactId>micrometer-registry-prometheus</artifactId>
</dependency>
```

## yml

```yaml
server:
  port: 8000
spring:
  application:
    name: prometheus-grafana
management:
  metrics:
    export:
      prometheus:
        enabled: true
        step: 1m
        descriptions: true
  endpoint:
    metrics:
      enabled: true
    prometheus:
      enabled: true
  endpoints:
    web:
      exposure:
        include: info, health, beans, env, metrics, mappings, scheduledtasks, sessions, threaddump, docs, logfile, jolokia, prometheus
      base-path: /actuator

```

# Prometheus

## 安装

[下载地址](https://prometheus.io/download/)

```shell
解压
tar -zxvf prometheus-2.29.2.linux-amd64.tar.gz
改名
mv prometheus-2.29.2.linux-amd64 prometheus-2.29.2
修改配置文件
cd prometheus-2.29.2
vi prometheus.yml
启动
./prometheus --config.file=prometheus.yml
```

## Prometheus.yml

```yaml
global:
  scrape_interval: 15s # Set the scrape interval to every 15 seconds. Default is every 1 minute.
  evaluation_interval: 15s # Evaluate rules every 15 seconds. The default is every 1 minute.
  # scrape_timeout is set to the global default (10s).
# Alertmanager configuration
alerting:
  alertmanagers:
    - static_configs:
        - targets:
          # - alertmanager:9093
# Load rules once and periodically evaluate them according to the global 'evaluation_interval'.
rule_files:
  # - "first_rules.yml"
  # - "second_rules.yml"
# A scrape configuration containing exactly one endpoint to scrape:
# Here it's Prometheus itself.
scrape_configs:
  # The job name is added as a label `job=<job_name>` to any timeseries scraped from this config.
  - job_name: "prometheus"
    # metrics_path defaults to '/metrics'
    # scheme defaults to 'http'.
    metrics_path: "/actuator/prometheus"
    static_configs:
      - targets: ["192.168.0.101:8000"]
```

## 错误

```shell
Error fetching server time: Detected 4802.68700003624 seconds time difference between your browser and the server. Prometheus relies on accurate time and time drift might cause unexpected query results.
```

## 解决方案

```shell
#查看当前系统时间
date
#设置当前系统事件
例如：将系统日期设定成2009年11月3日的命令
命令 ： "date -s 11/03/2009"
将系统时间设定成下午5点55分55秒的命令
命令 ： "date -s 17:55:55"
```



## 访问地址

[web地址](http://192.168.0.120:9090/)

# Grafana

## 安装

```shell docker pull grafana/grafana
docker pull grafana/grafana
```

## 启动

```shell
docker run -d -p 3000:3000 grafana/grafana
```

## 错误

```shell
docker: Error response from daemon: driver failed programming external connectivity on endpoint flamboyant_cori (dea6a7cfc0c88961bd31a1cb4ce0251bbf453ff228c44154220f2b256043f554):  (iptables failed: iptables --wait -t nat -A DOCKER -p tcp -d 0/0 --dport 3000 -j DNAT --to-destination 172.17.0.2:3000 ! -i docker0: iptables: No chain/target/match by that name.
 (exit status 1)).
```

## 解决方案

```shell
systemctl restart docker
```

## 访问地址

[访问地址](http://192.168.0.120:3000/login)

默认用户名： admin

默认密码： admin