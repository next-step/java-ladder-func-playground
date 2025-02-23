package service;

import domain.BooleanGenerator;
import domain.ladder.Ladder;
import domain.ladder.LadderResult;
import domain.ladder.LadderResults;
import domain.participant.Participant;
import domain.participant.Participants;
import dto.response.GetLadderAllResultResponse;
import dto.response.GetLadderCanvasResponse;
import dto.response.GetLadderResultResponse;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderService {

    private final BooleanGenerator booleanGenerator;
    private Participants participants;
    private LadderResults ladderResults;
    private Ladder ladder;

    public LadderService(BooleanGenerator booleanGenerator) {
        this.booleanGenerator = booleanGenerator;
    }

    public void createParticipants(List<String> names) {
        this.participants = new Participants(names);
    }

    public void createLadderResults(List<String> results) {
        validateResultSizeEqualsParticipantCount(results);
        this.ladderResults = new LadderResults(results);
    }

    private void validateResultSizeEqualsParticipantCount(List<String> results) {
        if (results.size() != participants.getParticipantCount()) {
            throw new IllegalArgumentException("로또 결과를 참여자 수랑 동일하게 입력해주세요.");
        }
    }

    public void createLadder(int height) {
        this.ladder = new Ladder(height, participants.getParticipantCount(), booleanGenerator);
    }

    public GetLadderCanvasResponse getLadderCanvas() {
        return GetLadderCanvasResponse.of(participants, ladder, ladderResults);
    }

    public GetLadderResultResponse getLadderResult(String name) {
        Participant participant = participants.getParticipant(name);
        LadderResult ladderResult = getLadderResultForParticipant(participant);

        return GetLadderResultResponse.from(ladderResult);
    }

    public GetLadderAllResultResponse getAllLadderResult() {
        Map<String, LadderResult> results = participants.getParticipants().stream()
                .collect(Collectors.toMap(
                        Participant::getName,
                        this::getLadderResultForParticipant,
                        (existing, replacement) -> existing,
                        LinkedHashMap::new
                ));

        return GetLadderAllResultResponse.from(results);
    }

    private LadderResult getLadderResultForParticipant(Participant participant) {
        return ladderResults.getLadderResult(ladder.getLadderEndPoint(participant.getStartPoint()));
    }
}
