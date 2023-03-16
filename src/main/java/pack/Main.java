package pack;

//if you pick any 3 numbers from 1 to 2000, what is the probability that the sum is divisible by 5?

import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        int MAX_VAL = 125;
        long prevDif = 1;
        while (MAX_VAL < 2000) {
            MAX_VAL *= 2;
            long startTime = System.currentTimeMillis();

            Map<Boolean, Long> values = new TreeMap<>();
            for (int i = 1; i <= MAX_VAL; ++i) {
                for (int j = 1; j <= MAX_VAL; ++j) {
                    if (i == j) continue;
                    for (int k = 1; k <= MAX_VAL; ++k) {
                        if (k == i || k == j) continue;
                        values.merge((i + j + k) % 5 == 0, 1L, Math::addExact);
                    }
                }
            }

            long endTime = System.currentTimeMillis();
            System.out.printf("Finished with %d in %d milliseconds" + (prevDif==1?"":" (%fx)") + "%n", MAX_VAL, endTime - startTime, (double)(endTime - startTime)/prevDif);
            prevDif = endTime - startTime;

            values.forEach((k, v) -> System.out.printf(
                    (k?"\ttrue:  ":"\tfalse: ") + "%,d (%f)%n",
                    v, (k?(double)v/(values.get(false)+v):(double)v/(values.get(true)+v))));
        }
    }
}