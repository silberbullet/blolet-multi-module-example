# blolet-multi-module-example
> Nettee Backend 팀의 backend-sample-hexagonal-simple-crud를 응용한 mulit-module 예시 입니다. 

## 📁 폴더 구조

```
blolet
├─common
├─core
│  ├─nettee-exception-handler-core [exception-handler-core]
│  └─nettee-jpa-core [jpa-core]
├─monolithic
└─services
    └─board
        ├─api [board-api]
        │  ├─domain [board-api:domain]
        │  ├─exception [board-api:exception]
        │  └─readmodel [board-api:readmodel]
        ├─application  [board-application]
        ├─driven
        │  └─rdb
        │      └─jpa  [board-postgresql-rdb-adapter]
        └─driving
            └─rest
                └─web-mvc [board-rest-webmvc-adapter]
```

## 🐋 모듈 관계도

### ➡️ 의존 방향

```mermaid
graph TD;
    exception-handler-core --> common;
    board-api:exception --> common;
    
    board-api:readmodel --> board-api:domain;
    
    board-api --> board-api:domain;
    board-api --> board-api:exception;
    board-api --> board-api:readmodel;
    
    board-application --> board-api;
    
    board-postgresql-rdb-adapter --> jpa-core;
    board-postgresql-rdb-adapter --> board-application;
    
    board-rest-webmvc-adapter  --> board-application;
        
    board-service --> board-api 
    board-service --> board-postgresql-rdb-adapter
    board-service --> board-rest-webmvc-adapter 

    monolithic-client --> board-service 
    monolithic-client --> exception-handler-core 
    monolithic-client --> jpa-core
```
