package it.fabio.esercitazione.interfaces;

import java.nio.file.Path;
import java.util.List;

public interface Readable <T> {

	
	List<T> createListFromFile(Path path);
}
