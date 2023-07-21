# template_junit_cucumber_rest_assured_allure

## Tools
1. Cucumber 7.2.3
2. Rest-assured 5.3.0
3. junit 4.13.2
4. lombok 1.18.2
5. allure 2.17.3

## Запуск
mvn clean test -Denv=unstable -Dcucumber.filter.tags="@smoke"
- tags="@smoke" указан для примера, для теста параметр необязательный

## Описание
Фреймворк, в котором
- в модулях описаны объекты для использования в запросах
- сами запросы описаны библиотекой Rest-assured
- шаги описаны в stepDefinitions
- настроены параллельные запуски файлов по feautures
