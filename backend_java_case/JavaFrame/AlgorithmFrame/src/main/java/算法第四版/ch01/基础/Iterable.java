package 算法第四版.ch01.基础;

import java.util.Iterator;

public interface Iterable<Item> {

	Iterator<Item> iterator();
}
