package lesson110.output;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * Класс для хранения данных об артистах в рамках страны.
 */
public class Country implements Serializable
{
	private static final long serialVersionUID = -838006097731901030L;

	@JacksonXmlProperty(isAttribute = true, localName = "name")  // Атрибут для страны
	private String       name;

	@JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Artist")
	private List<Artist> artists = new ArrayList<>();

	public Country()
	{
		
	}

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
