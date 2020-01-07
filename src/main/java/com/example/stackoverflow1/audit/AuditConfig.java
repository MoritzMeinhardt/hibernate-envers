package com.example.stackoverflow1.audit;

import lombok.AllArgsConstructor;
import org.hibernate.envers.boot.internal.EnversService;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@AllArgsConstructor
public class AuditConfig {

    private HibernateEntityManagerFactory hibernateEntityManagerFactory;

    @PostConstruct
    public void registerEnversListeners() {
        EnversService enversService =
                hibernateEntityManagerFactory
                        .getSessionFactory()
                        .getServiceRegistry()
                        .getService(EnversService.class);

        EventListenerRegistry listenerRegistry = hibernateEntityManagerFactory.getSessionFactory().getServiceRegistry().getService(EventListenerRegistry.class);
        listenerRegistry.setListeners(EventType.POST_INSERT, new CustomAuditEventListenerPostInsert(enversService));
        listenerRegistry.setListeners(EventType.POST_DELETE, new CustomAuditEventListenerPostDelete(enversService));
    }
}
