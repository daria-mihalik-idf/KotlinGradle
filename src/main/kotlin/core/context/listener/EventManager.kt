package core.context.listener

class EventManager {
  private var listeners: MutableMap<EventType, Listener> = mutableMapOf()

  fun subscribe(event: EventType, listener: Listener) {
    listeners = mutableMapOf(event to listener)
  }

  fun unsubscribe(event: EventType) {
    listeners.remove(event)
  }

  fun notifyUpdate(event: EventType, value:Any) {
    listeners[event]!!.onUpdate(value)
  }
}