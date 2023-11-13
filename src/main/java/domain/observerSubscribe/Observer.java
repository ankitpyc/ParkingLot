package domain.observerSubscribe;

import domain.enums.EventType;

public interface Observer {
   public void onChange(Object object , EventType eventType);
}
