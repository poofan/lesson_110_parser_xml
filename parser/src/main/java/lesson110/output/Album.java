package lesson110.output;

/**
 * Класс для хранения данных о альбоме.
 */
public class Album
{
	private String name;

	private int    year;

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
