🎶 Artist Registry Generator
Описание проекта
Artist Registry Generator — это Java-приложение, которое обрабатывает XML файл с информацией о музыкальных альбомах и создает реестр исполнителей, сгруппированных по странам. Результат работы приложения сохраняется в форматах JSON, XML и с использованием механизма сериализации Java.

Структура проекта
src/main/java/lesson110/input — классы-модели для чтения входных данных (Catalog.java, Cd.java).
src/main/java/lesson110/output — классы-модели для выходного реестра (Registry.java, Country.java, Artist.java, Album.java).
src/main/resources/input — входные данные (XML-файл cd_catalog.xml).
src/main/resources/output — выходные данные в форматах JSON, XML и сериализованный объект.
src/test/java — тесты для проверки корректности работы приложения.
Функциональность
Приложение выполняет следующие задачи:

Чтение XML-файла с музыкальными альбомами с помощью библиотеки Jackson XmlMapper.
Группировка исполнителей по странам и создание реестра.
Сохранение результатов в нескольких форматах:
JSON: artist_by_country.json
XML: artist_by_country.xml
Java Serializable: artist_by_country.serialized
Покрытие тестами, проверяющими успешное чтение, преобразование и запись данных.
Установка
Требования
Java 8 или выше
Maven для управления зависимостями
Зависимости
Для работы с XML и JSON используются следующие библиотеки:

xml
Копировать код
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
Установка и запуск
Склонируйте репозиторий:

bash
Копировать код
git clone https://github.com/your-username/artist-registry-generator.git
Перейдите в директорию проекта:

bash
Копировать код
cd artist-registry-generator
Сборка и запуск приложения:

bash
Копировать код
mvn clean install
mvn exec:java -Dexec.mainClass="lesson110.ArtistRegistryService"
Использование
После запуска приложения в директории src/main/resources/output будут созданы три файла с результатами:

artist_by_country.json — JSON файл с информацией о реестре исполнителей.
artist_by_country.xml — XML файл с аналогичной структурой.
artist_by_country.serialized — сериализованный объект реестра.
Тестирование
Приложение покрыто тестами, которые можно запустить с помощью Maven:

bash
Копировать код
mvn test
Пример структуры выходного файла
Пример структуры выходного файла в формате XML:

xml
Копировать код
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
Принципы разработки
Проект разрабатывался с использованием следующих принципов:

SOLID — модульная структура с четким распределением обязанностей.
DRY — минимизация дублирования кода.
KISS — простая и понятная архитектура.
