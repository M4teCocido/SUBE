package util;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class IndexableSet <T> extends LinkedHashSet<T>{

	public T get (int index) {
		
		if (index < this.size()) {
			int i = 0;
			for (T elt : this) {
				if (i == index)
					return elt;
				i++;
			}
			return null;
			//throw new Exception("El indice del IndexableSet esta fuera de sus limites");
		} else {
			throw new IndexOutOfBoundsException("El indice del IndexableSet esta fuera de sus limites");
		}

	}

	public T get (T object) {
		
		for (T elt : this) {
			if (elt.equals(object))
				return elt;
		}
		return null;
	}
	
}
