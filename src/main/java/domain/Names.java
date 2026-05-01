package domain;

import java.util.*;
import java.util.stream.Collectors;

public class Names {
    private final List<Name> values;

    public Names(String input) {
        this.values = Arrays.stream(input.split(","))
                .map(Name::new) //각각을 Name객체로 변환
                .collect(Collectors.toList());
    }

    public int size() { return values.size(); } //이름 개수 반환
    public List<Name> getValues() { return Collections.unmodifiableList(values); } //외부에서 수정 못하게
    public Name get(int index) { return values.get(index); } //특정 위치의 이름 가져오기
}
