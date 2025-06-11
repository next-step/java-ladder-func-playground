package result;



import java.util.List;

public class Prizes {
    private final List<Prize> prizes;

    public Prizes(List<Prize> prizes) {
        this.prizes = List.copyOf(prizes);
    }

    public static Prizes from(List<String> results) {
        List<Prize> prizes = results.stream()
                .map(Prize::from)
                .toList();
        return new Prizes(prizes);
    }

    public int size() {
        return prizes.size();
    }
}
