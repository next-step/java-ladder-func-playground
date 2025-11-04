# java-ladder-func-playground

사다리 미션

## 개요
사다리 미션은 간단한 콘솔 애플리케이션으로, 사용자로부터 참여할 사람의 이름과 실행 결과, 최대 사다리 높이를 입력 받습니다.\
그리고 생성된 사다리에 대해 사용자는 참가자의 이름을 입력하여 해당 참가자에 대한 실행 결과를 확인할 수 있고, `all`을 입력하여 전체 결과를 확인할 수 있습니다.

## 프로젝트 구조
```
controller/
- LadderController.java : 전반적인 게임 Flow(입력, 실행, 출력)를 담당하는 클래스
model/
- ladder/
  - Connection.java : 사다리 가로 줄의 지점 간 연결을 정의하는 클래스
  - Ladder.java : 전체 사다리를 정의하는 클래스
  - LadderFactory.java : 사다리 생성을 담당하는 클래스
  - Line.java : 사다리의 가로 줄을 정의하는 클래스
- Game.java : 게임 실행을 담당하는 클래스
- GameConfiguration.java : 게임 설정을 정의하는 클래스
- GameConfigurationBuilder.java : 게임 설정 Builder 클래스
- GameResult.java : 게임 결과를 정의하는 클래스
- Participant.java : 각 참가자를 정의하는 클래스
view/
- InputView.java : 사용자 입력 처리 기능 수행
- OutputView.java : 사용자에게 정보 출력 기능 수행
Main.java : Main entrypoint
```
