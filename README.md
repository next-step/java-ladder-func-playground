#  사다리 게임 

---

## 💡 실행 흐름 개요

1. `LadderApplication`에서 게임이 시작됩니다.
2. `InputHandler`를 통해 사용자로부터 다음을 입력받습니다:
    - 참가자 이름 (`PlayerNames`)
    - 상품 결과 (`PrizeNames`)
    - 사다리 높이
3. 사다리 구조 (`Ladder`)가 생성됩니다.
4. `GameInformation` 객체가 참가자와 상품 정보를 묶습니다.
5. `ResultCalculator`가 각 참가자가 사다리를 따라 도달할 결과 인덱스를 계산하여 `PlayerResults`에 저장합니다.
6. `LadderGameController`가 사용자 입력에 따라 결과를 출력합니다.
7. `OutputHandler`가 결과를 출력합니다.

---

## 주요 클래스 역할

`Ladder`                          사다리 전체 구성 (여러 층으로 구성)      

`LadderRow`                       사다리의 한 층  

`Connection`                      두 세로줄 사이의 가로 연결

`BooleanValueGenerator` / `LadderConnectionGenerator` 연결 여부를 랜덤으로 생성

`PlayerName` / `PrizeName`        입력값에 대한 유효성 검증 포함 도메인 객체          

`PlayerNames` / `PrizeNames`      이름과 상품 리스트를 관리    

`GameInformation`                 입력된 참가자와 상품 정보의 원본 데이터를 보관(사다리 출력 시 재사용)    

`ResultCalculator`                사다리를 타고 도달한 위치를 계산하고 매핑 

`PlayerResults`                   매핑된 결과를 저장 및 조회하는 객체

`LadderGame`                      결과 검색 및 게임 로직 관리   

`LadderGameController`           사용자 요청을 받아 출력 제어  

`InputHandler` / `OutputHandler`  콘솔 입출력 처리                                    

---
## 🎯 사다리 생성 전략

### 사다리의 한 층의 생성 과정:

1. **랜덤하게 연결 여부(`true` or `false`) 시퀀스를 생성**
2. **연속된 `true`를 제거하여 옆줄이 겹치지 않도록 처리**
3. **모든 연결이 false인 경우, 새로 시도함 (최소 1개 연결 보장)**

### 규칙
- **옆줄은 랜덤하게 생성하되, 연속해서 연결되지 않도록 한다.**
- **각 세로줄에는 최소한 하나 이상의 연결이 있어야 한다.**

---

### ✅ `LadderRow` 클래스
- 한 층의 사다리를 나타냄
- 내부에 `List<Connection>`을 가짐
- 각 `Connection`은 **오른쪽으로 연결되는지 여부**

### ✅ `BooleanValueGenerator` 인터페이스
- `boolean generate()` 메서드를 통해 **랜덤 연결 여부를 생성**하는 전략

### ✅ `LadderConnectionGenerator` 클래스
- `BooleanValueGenerator`의 구현체
- `Random.nextBoolean()`을 사용하여 무작위 연결 결정

---






