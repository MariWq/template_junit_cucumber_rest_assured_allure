# language: ru
Функционал: Создание животного с разными параметрами

  //Предыстория:
    //Дано очистка базы данных

  @smoke
  @regress
  Сценарий: Создать животное со всеми полями
    Когда создать животное с параметрами, статус 200:
      | id  |  2 |
      | name  |  Max |
      | category.id | 0 |
      | category.name | string |
      | photoUrls | /cats |
      | tags.id | 0 |
      | tags.name | string |
      | status    | available |

  @regress
  Сценарий: Создать животное с нулевыми значениями
    Когда создать животное с параметрами, статус 200:
      | id  | 0  |
      | name  |   |
      | category.id | 0 |
      | category.name |  |
      | photoUrls |  |
      | tags.id | 0 |
      | tags.name |  |
      | status    |  |

  @regress
  Сценарий: Проверить, что животное удалено
    Когда создать животное с параметрами, статус 200:
      | id  | 99  |
      | name  |   |
      | category.id | 0 |
      | category.name |  |
      | photoUrls |  |
      | tags.id | 0 |
      | tags.name |  |
      | status    |  |
    Тогда удалить животное, статус 200
    И получить животное, статус 404

  @smoke
  Сценарий: Загрузить изображение животного
    Когда создать животное с параметрами, статус 200:
      | id  | 99  |
      | name  |   |
      | category.id | 0 |
      | category.name |  |
      | photoUrls |  |
      | tags.id | 0 |
      | tags.name |  |
      | status    |  |
    Тогда загрузить изображение "cat.jpg", статус 200

