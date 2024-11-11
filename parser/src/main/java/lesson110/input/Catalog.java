package lesson110.input;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс для хранения данных каталога.
 */
public class Catalog
{
	private List<Cd> cds = new ArrayList<>();

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
