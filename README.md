# LV3 통합실습 및 결과

### Microservice Implementation
##### Saga (Pub / Sub)
##### CQRS
##### Compensation / Correlation

### Microservice Orchestration
##### Deploy to EKS Cluster
##### Gateway Service Router 설치
##### Autoscale (HPA)


# 

## Model
www.msaez.io/#/storming/34c3b6a18ceea14dd5c74cfd27085c48

## Before Running Services
### Make sure there is a Kafka server running
```
cd kafka
docker-compose up
```
- Check the Kafka messages:
```
cd kafka
docker-compose exec -it kafka /bin/bash
cd /bin
./kafka-console-consumer --bootstrap-server localhost:9092 --topic
```

## Run the backend micro-services
See the README.md files inside the each microservices directory:

- app
- store
- rider
- customer


## Run API Gateway (Spring Gateway)
```
cd gateway
mvn spring-boot:run
```

## Test by API
- app
```
 http :8088/orders id="id" food="food" cutomerid="cutomerid" address="address" price="price" status="status" 
 http :8088/payments id="id" orderid="orderid" price="price" 
```
- store
```
 http :8088/storeOrders id="id" food="food" address="address" status="status" orderid="orderid" 
```
- rider
```
 http :8088/deliveries id="id" address="address" orderid="orderid" 
```
- customer
```
 http :8088/notificationLogs id="id" customerid="customerid" message="message" 
```


## Run the frontend
```
cd frontend
npm i
npm run serve
```

## Test by UI
Open a browser to localhost:8088

## Required Utilities

- httpie (alternative for curl / POSTMAN) and network utils
```
sudo apt-get update
sudo apt-get install net-tools
sudo apt install iputils-ping
pip install httpie
```

- kubernetes utilities (kubectl)
```
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl
```

- aws cli (aws)
```
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install
```

- eksctl 
```
curl --silent --location "https://github.com/weaveworks/eksctl/releases/latest/download/eksctl_$(uname -s)_amd64.tar.gz" | tar xz -C /tmp
sudo mv /tmp/eksctl /usr/local/bin
```

