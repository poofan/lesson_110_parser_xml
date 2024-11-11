package lesson110.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lesson110.input.Catalog;
import lesson110.input.Cd;
import lesson110.output.Album;
import lesson110.output.Artist;
import lesson110.output.Country;
import lesson110.output.Registry;

@Service
public class RegistryCreator
{
	/**
     * Метод для создания объекта Registry, который представляет реестр исполнителей,
     * сгруппированных по странам и альбомам, на основе данных из Catalog.
     *
     * @param catalog объект Catalog с данными о дисках
     * @return объект Registry, представляющий реестр исполнителей по странам
     */
    public Registry createRegistry(Catalog catalog) 
    {
        // Группируем диски по странам с использованием Stream API
        Map<String, List<Cd>> cdsByCountry = catalog.getCds().stream()
                .collect(Collectors.groupingBy(Cd::getCountry));

        // Создаем список объектов Country, представляющих каждую страну с исполнителями
        List<Country> countries = cdsByCountry.entrySet().stream()
                .map(entry -> 
                {
                    // Название страны
                    String countryName = entry.getKey();
                    
                    // Группируем диски внутри страны по исполнителям
                    List<Artist> artists = entry.getValue().stream()
                            .collect(Collectors.groupingBy(Cd::getArtist))
                            .entrySet().stream()
                            .map(artistEntry -> 
                            {
                                // Имя исполнителя
                                String artistName = artistEntry.getKey();
                                
                                // Список альбомов, которые выпустил данный исполнитель
                                List<Album> albums = artistEntry.getValue().stream()
                                        .map(cd -> new Album(cd.getTitle(), cd.getYear()))
                                        .collect(Collectors.toList());
                                
                                // Создаем объект Artist, представляющий исполнителя с его альбомами
                                return new Artist(artistName, albums);
                            })
                            .collect(Collectors.toList());
                    
                    // Создаем объект Country, представляющий страну с ее исполнителями
                    return new Country(countryName, artists);
                })
                .collect(Collectors.toList());

        // Возвращаем объект Registry, содержащий информацию о странах и исполнителях
        return new Registry(countries.size(), countries);
    }
}
