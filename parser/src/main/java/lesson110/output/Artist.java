package lesson110.output;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * Класс для хранения данных о исполнителе.
 */
public class Artist implements Serializable
{
	private static final long serialVersionUID = -8693476782881844877L;

	@JacksonXmlProperty(localName = "Name")
	private String      name;

	@JacksonXmlElementWrapper(localName = "Albums")
    @JacksonXmlProperty(localName = "Album")
	private List<Album> albums = new ArrayList<>();

	public Artist()
	{
		
	}

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
