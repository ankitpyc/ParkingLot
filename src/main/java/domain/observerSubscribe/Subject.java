package domain.observerSubscribe;

import domain.enums.EventType;

public interface Subject {
    public void notifyObserver(Object observer, EventType eventType);

    public void addObserver(Observer observer);

    public void unsubscribe(Observer ob);

}
