package com.example.stackoverflow1.audit;

import com.example.stackoverflow1.model.Soup;
import org.hibernate.envers.boot.internal.EnversService;
import org.hibernate.envers.event.spi.EnversPostDeleteEventListenerImpl;
import org.hibernate.event.spi.PostDeleteEvent;

public class CustomAuditEventListenerPostDelete extends EnversPostDeleteEventListenerImpl {


    public CustomAuditEventListenerPostDelete(EnversService enversService) {
        super(enversService);
    }

    @Override
    public void onPostDelete(PostDeleteEvent event) {
        if (event.getEntity() instanceof Soup){
            Soup soup = ((Soup) event.getEntity());
            System.out.println("DELETE: " + soup);
        }
    }

}
