package lesson110.input;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * Класс для хранения данных о диске.
 */
public class Cd
{
	@JacksonXmlProperty(localName = "TITLE")
	private String title;

	@JacksonXmlProperty(localName = "ARTIST")
	private String artist;

	@JacksonXmlProperty(localName = "COUNTRY")
	private String country;

	@JacksonXmlProperty(localName = "COMPANY")
	private String company;

	@JacksonXmlProperty(localName = "PRICE")
	private double price;

	@JacksonXmlProperty(localName = "YEAR")
	private int    year;

	public Cd()
	{
		
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getArtist()
	{
		return artist;
	}

	public void setArtist(String artist)
	{
		this.artist = artist;
	}

	public String getCountry()
	{
		return country;
	}

	public void setCountry(String country)
	{
		this.country = country;
	}

	public String getCompany()
	{
		return company;
	}

	public void setCompany(String company)
	{
		this.company = company;
	}

	public double getPrice()
	{
		return price;
	}

	public void setPrice(double price)
	{
		this.price = price;
	}

	public int getYear()
	{
		return year;
	}

	public void setYear(int year)
	{
		this.year = year;
	}

}
