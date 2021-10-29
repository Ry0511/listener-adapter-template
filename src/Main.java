import adapter.GameAdapter;

import java.util.stream.IntStream;

public class Main {

    /**
     * ListenerAdapter Example.
     *
     * For where events are fired see:
     *  > entity.Entity
     *
     * For what actions entities do see:
     *  > entity.EntityA
     *  > entity.EntityB
     *
     * For adapter template see:
     *  > adapter.AbstractEventFilter (AbstractEventAdapter is a better name)
     *
     * For Adapter implementation see:
     *  > adapter.GameAdapter
     *
     * For game upate loop see:
     *  > SampleGame
     */

    public static void main(String[] args) throws InterruptedException {
        SampleGame game = new SampleGame();
        GameAdapter adapter = new GameAdapter();

        IntStream.range(0, 8).forEach(i -> game.addEntity(adapter));

        game.startGame();
        Thread.sleep(5000);
        game.endGame();
    }
}
