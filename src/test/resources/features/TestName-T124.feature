# language: ru
Функционал: Создание заказов в магазине

  //Предыстория:
  //Дано очистка базы данных

  @smoke
  Сценарий: Проверить создание заказа
    Когда создать заказ, статус 200:
      | id  |  1 |
      | petId | 1 |


  @smoke
  Сценарий: Проверить создание заказа
    Когда создать заказ, статус 200:
      | id  |  1 |
      | petId | 1 |
    Тогда получить заказ, статус 200