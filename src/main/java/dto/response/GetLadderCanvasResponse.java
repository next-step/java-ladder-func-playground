package dto.response;

import domain.ladder.Ladder;
import domain.ladder.LadderResult;
import domain.ladder.LadderResults;
import domain.ladder.Line;
import domain.participant.Participant;
import domain.participant.Participants;

import java.util.List;

public record GetLadderCanvasResponse(
        List<String> names,
        List<List<Boolean>> ladders,
        List<String> results
) {

    public static GetLadderCanvasResponse of(Participants participants, Ladder ladder, LadderResults ladderResults) {
        List<String> names = extractParticipantsNames(participants);
        List<List<Boolean>> ladders = extractLaddersList(ladder);
        List<String> results = extractLadderResults(ladderResults);

        return new GetLadderCanvasResponse(names, ladders, results);
    }

    private static List<String> extractParticipantsNames(Participants participants) {
        return participants.getParticipants().stream()
                .map(Participant::getName)
                .toList();
    }

    private static List<List<Boolean>> extractLaddersList(Ladder ladder) {
        return ladder.getLines().stream()
                .map(Line::getPoints)
                .toList();
    }

    private static List<String> extractLadderResults(LadderResults ladderResults) {
        return ladderResults.getAllLadderResults().stream()
                .map(LadderResult::getResult)
                .toList();
    }
}
