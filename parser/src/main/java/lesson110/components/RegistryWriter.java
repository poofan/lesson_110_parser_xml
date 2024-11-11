package lesson110.components;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import lesson110.output.Registry;

@Component
public class RegistryWriter
{
	// Константа, указывающая путь к выходной директории для сохранения результатов
	private static final String OUTPUT_DIRECTORY = "src/main/resources/output/";

	/**
	 * Метод для записи объекта Registry в JSON файл.
	 *
	 * @param registry объект Registry для записи
	 * @throws Exception если возникает ошибка при записи
	 */
	public void writeRegistryToJson(Registry registry) throws Exception
	{
		// Создаем ObjectMapper для работы с JSON с использованием Jackson
		ObjectMapper objectMapper = new ObjectMapper();

		// Записываем объект Registry в файл JSON
		objectMapper.writeValue(new File(OUTPUT_DIRECTORY + "artist_by_country.json"), registry);
	}

	/**
	 * Метод для записи объекта Registry в XML файл.
	 *
	 * @param registry объект Registry для записи
	 * @throws Exception если возникает ошибка при записи
	 */
	public void writeRegistryToXml(Registry registry) throws Exception
	{
		// Создаем XmlMapper для работы с XML с использованием Jackson
		XmlMapper xmlMapper = new XmlMapper();

		// Записываем объект Registry в файл XML
		xmlMapper.writeValue(new File(OUTPUT_DIRECTORY + "artist_by_country.xml"), registry);
	}

	/**
	 * Метод для сериализации объекта Registry и записи его в файл.
	 *
	 * @param registry объект Registry для сериализации и записи
	 * @throws Exception если возникает ошибка при записи
	 */
	public void serializeRegistry(Registry registry) throws Exception
	{
		// Создаем потоки для записи сериализованного объекта
		try (FileOutputStream fileOut = new FileOutputStream(OUTPUT_DIRECTORY + "artist_by_country.serialized");
				ObjectOutputStream out = new ObjectOutputStream(fileOut))
		{
			// Сериализуем объект Registry и записываем его в файл
			out.writeObject(registry);
		}
	}
}
