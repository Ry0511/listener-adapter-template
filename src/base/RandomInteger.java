package base;

import java.util.Random;

/**
 * Liam would have this interface lul
 */
public interface RandomInteger {

    default int rng(int bound) {
        final Random r = new Random();
        return r.nextInt(bound);
    }
}
