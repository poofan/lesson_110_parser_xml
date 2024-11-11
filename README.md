# 🎶 Artist Registry Generator

## Описание проекта

**Artist Registry Generator** — это Java-приложение, которое обрабатывает XML файл с информацией о музыкальных альбомах и создает реестр исполнителей, сгруппированных по странам. Результат работы приложения сохраняется в форматах JSON, XML и с использованием механизма сериализации Java.

## Структура проекта

- `src/main/java/lesson110/input` — классы-модели для чтения входных данных (`Catalog.java`, `Cd.java`).
- `src/main/java/lesson110/output` — классы-модели для выходного реестра (`Registry.java`, `Country.java`, `Artist.java`, `Album.java`).
- `src/main/resources/input` — входные данные (XML-файл `cd_catalog.xml`).
- `src/main/resources/output` — выходные данные в форматах JSON, XML и сериализованный объект.
- `src/test/java` — тесты для проверки корректности работы приложения.

## Функциональность

Приложение выполняет следующие задачи:

1. **Чтение XML-файла с музыкальными альбомами** с помощью библиотеки `Jackson XmlMapper`.
2. **Группировка исполнителей по странам** и создание реестра.
3. **Сохранение результатов в нескольких форматах**:
   - JSON: `artist_by_country.json`
   - XML: `artist_by_country.xml`
   - Java Serializable: `artist_by_country.serialized`
4. **Покрытие тестами**, проверяющими успешное чтение, преобразование и запись данных.

## Установка

### Требования

- **Java** 8 или выше
- **Maven** для управления зависимостями

### Зависимости

Для работы с XML и JSON используются следующие библиотеки:

```xml
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.17.0</version>
</dependency>
<dependency>
    <groupId>com.fasterxml.jackson.dataformat</groupId>
    <artifactId>jackson-dataformat-xml</artifactId>
    <version>2.17.0</version>
</dependency>
