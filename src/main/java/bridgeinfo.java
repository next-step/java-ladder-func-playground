import java.util.Random;

public class bridgeinfo {
    int[][] bridge;
    Random random = new Random();

    public bridgeinfo(int width, int height) {
        bridge = new int[width-1][height];
        for (int[] ints : bridge) {
            bridgeRandom(ints);
        }
    }

    private void bridgeRandom(int[] ints) {
        for (int anInt : ints) {
            anInt = random.nextInt() % 2;
        }
    }

    private void makingNoSideBridge(int[] ints)
    {
        for (int i = 0; i < ints.length-1; i++) {
            extracted(ints, i);
        }
    }

    private void extracted(int[] ints, int i) {
        if(ints[i]==1&& ints[1]==1)
        {
            ints[random.nextInt(2)]=0;
        }
    }
}
