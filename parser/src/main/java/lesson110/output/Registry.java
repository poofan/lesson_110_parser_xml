package lesson110.output;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * Класс для хранения данных по странам.
 */
@JacksonXmlRootElement(localName = "ArtistRegistry")
public class Registry implements Serializable
{
	private static final long serialVersionUID = -6642367748407398903L;
	
	@JacksonXmlProperty(isAttribute = true, localName = "countryCount")	
	int countryCount;
	
	@JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Country")
	private List<Country> countries = new ArrayList<>();

	public Registry()
	{
		
	}

	public Registry(int countryCount, List<Country> countries)
	{
		this.countryCount = countryCount;
		this.countries = countries;
	}

	public int getCountryCount()
	{
		return countryCount;
	}

	public List<Country> getCountries()
	{
		return countries;
	}

}
