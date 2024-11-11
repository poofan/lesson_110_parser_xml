package lesson110.components;

import java.io.File;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import lesson110.input.Catalog;

@Component
public class CatalogReader
{
	// Константа, указывающая путь к входному XML файлу с данными о музыкальных альбомах
	private static final String INPUT_FILE_PATH = "src/main/resources/input/cd_catalog.xml";

	/**
	 * Метод для чтения данных из XML-файла и преобразования их в объект Catalog.
	 *
	 * @return объект Catalog, содержащий данные из XML-файла
	 * @throws Exception если происходит ошибка при чтении файла или преобразовании
	 */
	public Catalog readCatalogFromXml() throws Exception
	{
		// Создаем объект XmlMapper для работы с XML, используя библиотеку Jackson
		XmlMapper xmlMapper = new XmlMapper();

		// Читаем файл и преобразуем его в объект Catalog
		return xmlMapper.readValue(new File(INPUT_FILE_PATH), Catalog.class);
	}
}
