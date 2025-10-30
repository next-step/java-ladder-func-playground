# 사다리 미션

## 기능
- 각 줄마다 가로 연결 여부는 랜덤으로 결정된다.
- 사다리의 너비(참여 인원 수) 와 높이(줄 개수) 를 사용자 입력으로 받아 생성할 수 있다.
- 겹치는 가로 라인(|-----|-----|) 은 허용되지 않는다.
- 참여자 이름(최대 5글자)과 결과를 쉼표(,)로 구분하여 입력받는다.
- 사다리의 형태를 출력한다.
- 사다리를 출력할 때 참여자 이름과 결과를 함께 표시한다.
- 특정 이름을 입력하면 개인 결과를, "all"을 입력하면 전체 결과를 출력한다.

## 프로젝트 구조

- model
    - ladder:
        * ConnectionStatus: 발판의 연결 상태(CONNECTED, DISCONNECTED)를 정의하는 enum.
        * Ladder: 여러 Line을 모아 사다리 전체의 구조와 높이를 관리하는 객체.
        * Line: 발판 겹침 금지 규칙에 따라 생성된, Point들을 가진 사다리의 가로 한 줄.
        * Point: ConnectionStatus를 감싸 Line을 구성하는 하나의 연결 지점.

    - participant:
        * Player: 이름 유효성 검사가 포함된 게임 참가자 1명
        * Players: 참가자 목록 전체를 관리하는 일급 컬렉션.

    - result:
        * Prize: 사다리 도착 지점의 상품 하나를 나타내는 객체
        * Prizes: 전체 상품 목록을 관리하는 일급 컬렉션.
        * GameResult: 누가 어떤 결과를 얻었는지 최종 매핑을 저장하는 객체.

- controller
    * LadderGameController.java: 게임의 전체적인 흐름 제어.

- view
    * InputView.java: 사용자의 입력을 받는 역할.
    * OutputView.java: 게임의 모든 결과 및 메시지를 출력하는 역할.

- main
    * LadderMain: 게임 실행을 담당.
