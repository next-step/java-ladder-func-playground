package io.suhan.ladder.model;

public record Outcome(String value) {
    public Outcome {
        if (value.isBlank()) {
            throw new IllegalArgumentException("결과는 공백일 수 없습니다.");
        }
    }
}
