package lesson110.output;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс для хранения данных о исполнителе.
 */
public class Artist
{

	private String      name;

	private List<Album> albums = new ArrayList<>();

	public Artist(String name, List<Album> albums)
	{
		this.albums = albums;
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public List<Album> getAlbums()
	{
		return albums;
	}

}
