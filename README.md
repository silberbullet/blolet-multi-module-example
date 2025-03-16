# blolet-multi-module-example
> Nettee Backend 팀의 backend-sample-hexagonal-simple-crud를 응용한 mulit-module 예시 입니다. 

## 📁 폴더 구조

```
blolet
├─common
├─core
│  ├─nettee-exception-handler-core [exceptionHandlerCore]
│  └─nettee-jpa-core [jpaCore]
├─monolithic
└─services
    └─board
        ├─api [boardApi]
        │  ├─domain [boardApi:domain]
        │  ├─exception [boardApi:exception]
        │  └─readmodel [boardApi:readmodel]
        ├─application  [boardApplication]
        ├─driven
        │  └─rdb
        │      └─jpa  [boardDrivenRdbJpa]
        └─driving
            └─rest
                └─web-mvc [boardDrivingWebMvc]
```

## 🐋 모듈 관계도

### ➡️ 의존 방향

```mermaid
graph TD;
    exceptionHandlerCore --> common;
    boardApi:exception --> common;
    
    boardApi:readmodel --> boardApi:domain;
    
    boardApi --> boardApi:domain;
    boardApi --> boardApi:exception;
    boardApi --> boardApi:readmodel;
    
    boardApplication --> boardApi;
    
    boardDrivenRdbJpa --> jpaCore;
    boardDrivenRdbJpa --> boardApplication;

    boardDrivingWebMvc --> boardApplication;

    monolithic --> boardApplication;
    monolithic --> boardDrivenRdbJpa
    monolithic --> boardDrivingWebMvc 
    monolithic --> exceptionHandlerCore
```
