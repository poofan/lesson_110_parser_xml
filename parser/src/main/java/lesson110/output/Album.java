package lesson110.output;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * Класс для хранения данных о альбоме.
 */
public class Album implements Serializable
{
	private static final long serialVersionUID = 4488272832008490901L;

	@JacksonXmlProperty(isAttribute = true, localName = "name")  // Атрибут для страны
	private String name;
	
	@JacksonXmlProperty(isAttribute = true, localName = "year")  // Атрибут для страны
	private int    year;

	public Album()
	{
		
	}

	public Album(String name, int year)
	{
		this.name = name;
		this.year = year;
	}

	public String getName()
	{
		return name;
	}

	public int getYear()
	{
		return year;
	}

}
