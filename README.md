# sample-ui-java-automation
## Summary
- 해당 프로젝트는 페이지 객체 모델 (POM) 디자인 패턴을 사용하여 웹 애플리케이션 테스트를 자동화하기 위한 Selenium 기반의 프로젝트입니다. 이 프로젝트는 Java 17, Selenium WebDriver, 그리고 TestNG 프레임워크를 사용하여 구성되었습니다.
- Skill
  - 언어 : Java (openjdk@17.0)
  - 의존성 관리 : Maven
  - 자동화 프레임워크 : Selenium
  - 테스트 프레임워크 : TestNG
  - 디자인 패턴 : POM, PageFactory
    - 페이지팩토리는 Selenium WebDriver 에서 제공하는 라이브러리 입니다.
  - 결과 리포트 : Allure (allure-maven)
---
## Repository Structure
- src/main/java/org.example.pages 에 테스트 스크립트 객체를 추가하여 커버리지를 관리합니다.
- src/test/java/org.example 에 테스트 케이스를 추가하여 커버리지를 관리합니다.
```
project-root
│
├── 📁 src
│   ├── 📁 main
│   │   ├── 📁 java
│   │   │   └── 📁 org
│   │   │       └── 📁 example
│   │   │           ├── 📁 base
│   │   │           │   └── BasePage.java
│   │   │           ├── 📁 config
│   │   │           │   └── Config.java
│   │   │           └── 📁 pages
│   │   │               ├── CommonPage.java
│   │   │               ├── MainPage.java
│   │   │               ├── WeatherPage.java
│   │   │               └── 테스트 스크립트 추가 ...
│   │   └── 📁 resources
│   │       └── config.properties
│   ├── 📁 test
│   │   ├── 📁 java
│   │   │   └── 📁 org
│   │   │       └── 📁 example
│   │   │           ├── MainPageTest.java
│   │   │           ├── WeatherPageTest.java
│   │   │           └── 테스트 추가 ...
│   │   └── 📁 resources
│   │       └── allure.properties
├── 📁 target
├── mvn-test-run.sh
├── pom.xml
└── README.md
```
---
## Pre-Condition
- 프로젝트 클론하기 전, 다음 사전 조건 확인 (Mac OS 기준)
  - Java 17 설치 확인 `jave --version`
    - 존재하지 않는다면, `brew install openjdk@17` 명령어로 설치
    - 설치 이후, `vi ~/.zshrc` 명령어로 zshrc 파일에 아래 환경 변수 설정
        ```bash
        sudo ln -sfn /opt/homebrew/opt/openjdk@17/libexec/openjdk.jdk /Library/Java/JavaVirtualMachines/openjdk-17.jdk
        export JAVA_HOME=$(/usr/libexec/java_home -v 17)
        export PATH=$JAVA_HOME/bin:$PATH
        ```
    - 환경 변수를 추가한 뒤 `source ~/.zshrc` 명령어로 파일 적용
  - Maven 설치 확인 `mvn --version`
    - 존재하지 않는다면, `brew install maven` 명령어로 설치
  - Allure 설치 확인 `allure --version`
    - 존재하지 않는다면, `brew install allure` 명령어로 설치
  - Chrome 브라우저 설치 확인
---
## Project Progress
- Step 1 : Repository 를 클론한 뒤, 프로젝트 루트로 이동
  ```bash
  git clone https://github.com/hoonq9284/sample-ui-java-automation.git
  ```
  ```bash
  cd sample-ui-java-automation
  ```

- Step 2 : 의존성 설치
  ```bash
  mvn clean install
  ```
---
## Test Run Process
- 기본적으로 아래 명령어를 입력하여 테스트를 실행
  ```bash
  mvn clean test
  ```
  ```bash
  allure serve target/allure-results
  ```
- 해당 프로젝트에서는 `mvn-test-run.sh` 쉘 스크립트 파일 자체를 실행하여, 해당 명령어를 한 번에 수행하도록 구성
  ```bash
  ./mvn-test-run.sh
  ```