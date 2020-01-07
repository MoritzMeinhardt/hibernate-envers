package com.example.stackoverflow1.audit;

import com.example.stackoverflow1.model.Soup;
import org.hibernate.envers.boot.internal.EnversService;
import org.hibernate.envers.event.spi.EnversPostInsertEventListenerImpl;
import org.hibernate.event.spi.PostInsertEvent;

public class CustomAuditEventListenerPostInsert extends EnversPostInsertEventListenerImpl {
    

    public CustomAuditEventListenerPostInsert(EnversService enversService) {
        super(enversService);
    }

    @Override
    public void onPostInsert(PostInsertEvent event) {
        if (event.getEntity() instanceof Soup){
            Soup soup = (Soup) event.getEntity();
            System.out.println("CREATE " + soup);
        }
        super.onPostInsert(event);
    }

}
