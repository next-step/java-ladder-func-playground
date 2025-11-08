// BridgeStepGenerator.java (새 파일)
package Model;

// "다리 한 칸을 생성하는 부품"에 대한 명세서
public interface BridgeStepGenerator {

    // 이 부품은 반드시 BridgeStep (NONE 또는 EXIST)을 반환해야 합니다.
    BridgeStep generateStep();
}
