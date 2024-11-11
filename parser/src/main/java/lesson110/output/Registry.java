package lesson110.output;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс для хранения данных по странам.
 */
public class Registry
{
	int size;
	private List<Country> countries = new ArrayList<>();

	public Registry(int size, List<Country> countries)
	{
		this.size = size;
		this.countries = countries;
	}

	public int getSize()
	{
		return size;
	}

	public List<Country> getCountries()
	{
		return countries;
	}

}
