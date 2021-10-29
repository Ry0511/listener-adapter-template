package adapter;

import base.ActionEvent;
import entity.events.EntityDamagedEvent;
import entity.events.EntityMovedEvent;

/**
 * @see adapter.AbstractEventFilter
 * @see base.ActionListener
 */
public class GameAdapter extends AbstractEventFilter {

    @Override
    protected void onEntityMoved(EntityMovedEvent event) {
        System.out.printf("[EntityMoved]  : (%s, [%s, %s])%n",
                event.getTarget().getID(),
                event.getOldX(),
                event.getOldY()
        );
    }

    @Override
    protected void onEntityDamaged(EntityDamagedEvent event) {
        System.out.printf("[EntityDamaged]: (%s, [%s, %s])%n",
                event.getTarget().getID(),
                event.getDamageTaken(),
                event.getTarget().getHealth()
        );
    }

    @Override
    protected void unknownEvent(ActionEvent e) {
        System.out.println("Event Handler Unknown: " + e.getName());
    }
}
