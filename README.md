# blolet-multi-module-example
> Nettee Backend 팀의 backend-sample-hexagonal-simple-crud를 응용한 mulit-module 예시 입니다. 

## 📁 폴더 구조

```
blolet
├─common
├─core
│  ├─nettee-exception-handler-core
│  └─nettee-jpa-core
├─monolithic
└─services
    └─board
        ├─api
        │  ├─domain
        │  ├─exception
        │  └─readmodel
        ├─application
        ├─driven
        │  └─rdb
        │      └─jpa
        └─driving
            └─rest
                └─web-mvc
```

## 🐋 모듈 관계도

### ➡️ 의존 방향

```mermaid
graph TD;
    nettee-exception-handler-core --> common;
    service/board/api/exception --> common;
    
    service/board/api/readmodel --> service/board/api/domain;
    
    service/board/api --> service/board/api/domain;
    service/board/api --> service/board/api/exception;
    service/board/api --> service/board/api/readmodel;
    
    service/board/application --> service/board/api;
    
    service/board/driven/rdb/jpa --> nettee-jpa-core;
    service/board/driven/rdb/jpa --> service/board/application;
    service/board/driving/rest/web-mvc --> service/board/application;

    monolithic --> service/board/application;
    monolithic --> service/board/driven/rdb/jpa 
    monolithic --> service/board/driving/rest/web-mvc
    monolithic --> nettee-exception-handler-core 
```