package com.xml.parser;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.databind.ObjectMapper;

import lesson110.ParserApplication;
import lesson110.output.Registry;
import lesson110.service.ArtistRegistryService;

@SpringBootTest(classes = ParserApplication.class)  // указываем класс запуска приложения
class ParserApplicationTests {

	@Test
    public void testGenerateArtistRegistry() throws Exception {
        ArtistRegistryService service = new ArtistRegistryService();
        
        // Генерируем реестр
        service.generateArtistRegistry();
        
        // Проверяем, что выходные файлы созданы
        assertTrue(new File("src/main/resources/output/artist_by_country.json").exists());
        assertTrue(new File("src/main/resources/output/artist_by_country.xml").exists());
        assertTrue(new File("src/main/resources/output/artist_by_country.serialized").exists());
        
        // Проверка корректности данных (пример: читаем JSON и сверяем поля)
        ObjectMapper objectMapper = new ObjectMapper();
        Registry registry = objectMapper.readValue(new File("src/main/resources/output/artist_by_country.json"), Registry.class);
        
        assertNotNull(registry);
        assertTrue(registry.getCountryCount() > 0);
    }

}
