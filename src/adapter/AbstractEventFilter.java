package adapter;

import base.ActionEvent;
import base.ActionListener;
import entity.events.EntityDamagedEvent;
import entity.events.EntityMovedEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;


public abstract class AbstractEventFilter implements ActionListener {

    private final Map<String, Consumer<ActionEvent>> handlers;

    /**
     * For event filtering you have a few options; this approach is designed
     * to reduce seek time, but you could just iterate through all possible
     * events if you wanted to.
     *
     * I don't know the best implementation, and I know mine definitely isn't
     * the best.
     */
    public AbstractEventFilter() {
        this.handlers = new HashMap<>();

        // Only two events known
        handlers.put(GameEvent.ENTITY_MOVED.getEventName(),
                event -> onEntityMoved((EntityMovedEvent) event));

        handlers.put(GameEvent.ENTITY_DAMAGED.getEventName(),
                event -> onEntityDamaged((EntityDamagedEvent) event));
    }

    public void action(ActionEvent e) {
        if (handlers.containsKey(e.getName())) {
            handlers.get(e.getName()).accept(e);

        } else {
            this.unknownEvent(e);
        }
    }

    // Could make these abstract if you want to force those who extend to
    // implement the method.

    protected void onEntityMoved(EntityMovedEvent event) {
    }

    protected void onEntityDamaged(EntityDamagedEvent event) {
    }

    protected void unknownEvent(ActionEvent e) {
    }
}
