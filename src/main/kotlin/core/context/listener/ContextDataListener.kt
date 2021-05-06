package core.context.listener

interface ContextDataListener<T> {
  fun takeRequiredData(dataField: T)
}