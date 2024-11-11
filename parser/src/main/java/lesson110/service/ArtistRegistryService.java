package lesson110.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lesson110.components.CatalogReader;
import lesson110.components.RegistryWriter;
import lesson110.input.Catalog;
import lesson110.output.Registry;

@Service
public class ArtistRegistryService
{	
	@Autowired
	private CatalogReader catalogReader;
	
	@Autowired
    private RegistryCreator registryCreator;
	
	@Autowired
    private RegistryWriter registryWriter;

    /**
     * Основной метод для запуска процесса создания реестра.
     * Он выполняет следующие шаги:
     * 1. Читает XML файл и создает объект Catalog.
     * 2. Создает объект Registry, группируя данные по странам и исполнителям.
     * 3. Записывает Registry в JSON, XML и сериализованный файл.
     *
     * @throws Exception если возникает ошибка на любом из этапов
     */
    public void generateArtistRegistry() throws Exception 
    {
        // Шаг 1: Чтение данных из XML файла
        Catalog catalog = catalogReader.readCatalogFromXml();

        // Шаг 2: Создание реестра на основе данных Catalog
        Registry registry = registryCreator.createRegistry(catalog);

        // Шаг 3: Запись реестра в различные форматы
        registryWriter.writeRegistryToJson(registry);
        registryWriter.writeRegistryToXml(registry);
        registryWriter.serializeRegistry(registry);
    }

}
