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
```
## Установка и запуск
Склонируйте репозиторий:

```bash
git clone https://github.com/poofan/lesson_110_parser_xml.git
```

## Перейдите в директорию проекта:

```bash
cd [ваш путь к проекту, куда вы сделали git clone]
```
## Сборка и запуск приложения:

```bash
mvn clean install
mvn exec:java -Dexec.mainClass="lesson110.ArtistRegistryService"
```
## Использование
После запуска приложения в директории src/main/resources/output будут созданы три файла с результатами:

1. **artist_by_country.json — JSON файл с информацией о реестре исполнителей.
2. **artist_by_country.xml — XML файл с аналогичной структурой.
3. **artist_by_country.serialized — сериализованный объект реестра.
   
## Тестирование
Приложение покрыто тестами, которые можно запустить с помощью Maven:

```bash
mvn test
```
## Пример структуры выходного файла
Пример структуры выходного файла в формате XML:

```xml
<ArtistRegistry countryCount="3">
   <Country name="USA">
      <Artist>
         <Name>Example</Name>
         <Albums>
            <Album name="ExampleName" year="Year"/>
            <Album name="ExampleName2" year="Year2"/>
         </Albums>
      </Artist>
      <Artist>...</Artist>
   </Country>
   <Country>...</Country>
</ArtistRegistry>
```
## Принципы разработки
При разработке Artist Registry Generator соблюдались следующие принципы:

1. **SOLID — приложение построено по принципу разделения обязанностей. Классы выполняют только одну задачу: чтение данных, обработка и запись результатов.
2. **DRY (Don't Repeat Yourself) — код написан таким образом, чтобы минимизировать дублирование, особенно при обработке данных и записи в разные форматы.
3. **KISS (Keep It Simple, Stupid) — логика программы построена просто и прозрачно, что облегчает поддержку и тестирование.
4. **Clean Code — уделено внимание читаемости кода, а также его комментированию там, где это необходимо.
## Расширяемость и масштабируемость
Модульная архитектура: каждое основное действие (чтение, обработка, запись) реализовано в отдельных методах, что позволяет при необходимости заменять или расширять отдельные части логики.
Гибкость форматов вывода: приложение легко расширить для поддержки дополнительных форматов файлов (например, CSV или YAML) при необходимости.
