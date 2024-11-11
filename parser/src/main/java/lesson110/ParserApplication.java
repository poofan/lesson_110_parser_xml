package lesson110;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lesson110.service.ArtistRegistryService;

@SpringBootApplication
public class ParserApplication implements CommandLineRunner 
{
	@Autowired
	private ArtistRegistryService artistRegistryService;
	
	public static void main(String[] args) {
		SpringApplication.run(ParserApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception
	{
		// Запускаем парсер при старте приложения
        artistRegistryService.generateArtistRegistry();
	}

}
