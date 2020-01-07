package com.example.stackoverflow1.audit;

import com.example.stackoverflow1.model.Ingredient;
import com.example.stackoverflow1.model.Soup;
import org.hibernate.collection.internal.PersistentBag;
import org.hibernate.envers.boot.internal.EnversService;
import org.hibernate.envers.event.spi.EnversPostUpdateEventListenerImpl;
import org.hibernate.event.spi.PostUpdateEvent;

public class CustomAuditEventListenerPostUpdate extends EnversPostUpdateEventListenerImpl {

    public CustomAuditEventListenerPostUpdate(EnversService enversService) {
        super(enversService);
    }

    @Override
    public void onPostUpdate(PostUpdateEvent event) {
        if (event.getEntity() instanceof Soup){
            Soup soup = ((Soup) event.getEntity());

            if(soup.isMajorVersion()) {
                soup.setMajorVersion(false);
                super.onPostUpdate(event);
            } else if(isEventAlreadyAuditLoggedByCreateEvent(event.getOldState())) {
                System.out.println("UPDATE: " + soup);
            }
        }
    }

    private boolean isEventAlreadyAuditLoggedByCreateEvent (Object[] oldState) {
        // do not push a second entry to the auditlog when the project is updated with the field values
        for(Object state: oldState) {
            if(state instanceof PersistentBag){
                PersistentBag persistentBag = (PersistentBag) state;
                if(!persistentBag.empty() && persistentBag.get(0) instanceof Ingredient){
                    return true;
                }
            }
        }
        return false;
    }
}
