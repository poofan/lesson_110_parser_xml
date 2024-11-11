package lesson110.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import lesson110.input.Catalog;
import lesson110.input.Cd;
import lesson110.output.Album;
import lesson110.output.Artist;
import lesson110.output.Country;
import lesson110.output.Registry;

public class ArtistRegistryService
{
	// Константа, указывающая путь к входному XML файлу с данными о музыкальных альбомах
	private static final String INPUT_FILE_PATH = "src/main/resources/input/cd_catalog.xml";
	// Константа, указывающая путь к выходной директории для сохранения результатов
	private static final String OUTPUT_DIRECTORY = "src/main/resources/output/";

	// Метод для запуска обработки данных
	public void generateArtistRegistry() throws Exception
	{
	    // 1. Считываем данные из XML файла, создавая объект Catalog, содержащий данные альбомов
	    Catalog catalog = readCatalogFromXml();

	    // 2. Создаем реестр исполнителей, сгруппированных по странам, на основе данных из catalog
	    Registry registry = createRegistry(catalog);

	    // 3. Записываем реестр в формате JSON, XML и сериализованного объекта
	    writeRegistryToJson(registry);
	    writeRegistryToXml(registry);
	    serializeRegistry(registry);
	}

	// Метод для считывания XML файла и преобразования его в объект Catalog
	private Catalog readCatalogFromXml() throws Exception
	{
	    // Создаем XmlMapper для работы с XML с использованием библиотеки Jackson
	    XmlMapper xmlMapper = new XmlMapper();
	    // Считываем XML файл и преобразуем его в объект Catalog, возвращаем результат
	    return xmlMapper.readValue(new File(INPUT_FILE_PATH), Catalog.class);
	}

	// Метод для создания реестра исполнителей, сгруппированных по странам, на основе данных из каталога
	private Registry createRegistry(Catalog catalog) {
	    // Группируем CD объекты по стране с использованием Stream API и Collectors.groupingBy
	    Map<String, List<Cd>> cdsByCountry = catalog.getCds().stream()
	            .collect(Collectors.groupingBy(Cd::getCountry));

	    // Создаем список объектов Country для каждой страны
	    List<Country> countries = cdsByCountry.entrySet().stream()
	            .map(entry -> {
	                // Получаем название страны из ключа entry
	                String countryName = entry.getKey();
	                // Группируем исполнителей по имени, а затем получаем их альбомы
	                List<Artist> artists = entry.getValue().stream()
	                        .collect(Collectors.groupingBy(Cd::getArtist))
	                        .entrySet().stream()
	                        .map(artistEntry -> {
	                            // Имя исполнителя
	                            String artistName = artistEntry.getKey();
	                            // Создаем список альбомов для каждого исполнителя
	                            List<Album> albums = artistEntry.getValue().stream()
	                                    .map(cd -> new Album(cd.getTitle(), cd.getYear()))
	                                    .collect(Collectors.toList());
	                            // Создаем объект Artist с именем и списком альбомов
	                            return new Artist(artistName, albums);
	                        })
	                        .collect(Collectors.toList());
	                // Создаем объект Country с названием страны и списком исполнителей
	                return new Country(countryName, artists);
	            })
	            .collect(Collectors.toList());

	    // Возвращаем объект Registry с числом стран и списком объектов Country
	    return new Registry(countries.size(), countries);
	}

	// Метод для записи реестра в JSON файл
	private void writeRegistryToJson(Registry registry) throws Exception
	{
	    // Создаем ObjectMapper для работы с JSON с использованием библиотеки Jackson
	    ObjectMapper objectMapper = new ObjectMapper();
	    // Записываем объект registry в JSON файл в указанной директории
	    objectMapper.writeValue(new File(OUTPUT_DIRECTORY + "artist_by_country.json"), registry);
	}

	// Метод для записи реестра в XML файл
	private void writeRegistryToXml(Registry registry) throws Exception
	{
	    // Создаем XmlMapper для работы с XML с использованием библиотеки Jackson
	    XmlMapper xmlMapper = new XmlMapper();
	    // Записываем объект registry в XML файл в указанной директории
	    xmlMapper.writeValue(new File(OUTPUT_DIRECTORY + "artist_by_country.xml"), registry);
	}

	/**
	 * Метод для сериализации объекта Registry и записи его в файл*.
	 * 
	 * @param registry
	 * @throws Exception
	 */
	private void serializeRegistry(Registry registry) throws Exception
	{
	    // Открываем поток для записи файла сериализации
	    try (FileOutputStream fileOut = new FileOutputStream(OUTPUT_DIRECTORY + "artist_by_country.serialized");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut))
	    {
	        // Сериализуем объект registry и записываем его в файл
	        out.writeObject(registry);
	    }
	}

}
