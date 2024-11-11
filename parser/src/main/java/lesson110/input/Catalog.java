package lesson110.input;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * Класс для хранения данных каталога.
 */
@JacksonXmlRootElement(localName = "CATALOG")
public class Catalog
{
	@JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "CD")
	private List<Cd> cds = new ArrayList<>();

	public Catalog()
	{
		
	}

	public List<Cd> getCds()
	{
		return cds;
	}

	public void setCds(List<Cd> cds)
	{
		// для устранения ошибки NPE
		if (cds == null)
		{
			cds = new ArrayList<>();
		}
		
		this.cds = cds;
	}
	
}
