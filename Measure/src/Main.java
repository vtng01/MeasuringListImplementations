import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    private static int total = 2;
    // 0 for arraylist and 1 for linkedlist
    private static int opt = 1;

    public static void main(String[] args) {
//        System.out.println(new Main().generateRangeOfNumbers(10));
        addTest( (opt == 0) ? new ArrayList<>():new LinkedList<>());
    }

    public static void addTest(List<Integer> nums) {
        Random random = new Random();
        long[] times = new long[total];
        List<Integer> array = new Main().generateRangeOfNumbers(10000);
        for (int i = 0; i < total; i++) {
            long startTime = System.currentTimeMillis();
            nums.addAll(array);
            long endTime = System.currentTimeMillis();
            times[i] = endTime - startTime;
//            System.out.println(nums.size());
        }
        System.out.println(Arrays.toString(times));

    }

    public List<Integer> generateRangeOfNumbers(int size) {

        List<Integer> ans = (opt == 0) ? new ArrayList<>():new LinkedList<>();
        for (int i = 0; i < size; i++) {
            ans.add(ThreadLocalRandom.current().nextInt(0, 1_000));
        }
        return ans;
    }
}
