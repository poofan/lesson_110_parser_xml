package lesson110.output;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс для хранения данных об артистах в рамках страны.
 */
public class Country
{

	private String       name;

	private List<Artist> artists = new ArrayList<>();

	public Country(String name, List<Artist> atrists)
	{
		this.artists = atrists;
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public List<Artist> getArtists()
	{
		return artists;
	}

}
