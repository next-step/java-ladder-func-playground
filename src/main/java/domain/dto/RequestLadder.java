package domain.dto;

import domain.Height;
import domain.Width;

public record RequestLadder(
        String width,
        String height
) {

    public RequestLadder {
        validateEmpty(width, height);
    }

    private void validateEmpty(final String width, final String height) {
        if (width == null || width.isBlank() || height == null || height.isBlank()) {
            throw new IllegalArgumentException("사다리의 넓이와 높이를 입력해야 합니다.");
        }
    }

    public Width toWidth() {
        try {
            return new Width(Integer.parseInt(width.strip()));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("사다리의 넓이는 숫자여야 합니다.");
        }
    }

    public Height toHeight() {
        try {
            return new Height(Integer.parseInt(height.strip()));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("사다리의 높이는 숫자여야 합니다.");
        }
    }

}
