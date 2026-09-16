package dp;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

/**
 * Usage:
IteratorPattern iterators = new IteratorPattern();
 String type = args.length > 0 ? args[0] : "list";
Iterator<String> iter = iterators.getIterator(type);

while(iter.hasNext()) {
    System.out.println("Got from the %s: %s".formatted(type, iter.next()));
}
 * IteratorPattern
 */
public class IteratorPattern {

    private final List<String> namesList = List.of("Mayank", "Alice", "Bob", "Charlie", "Swadha", "Santro", "Burfi", "Chhota Don", "Burfi");
    private final Set<String> nameSet = new HashSet<>(namesList);
    private final Set<String> treeSet = new TreeSet<>(namesList);
    private final Queue<String> queues = new ArrayDeque<>(nameSet);

    public Iterator<String> getIterator(String type) {
        switch (type) {
            case "list":
                return namesList.iterator();        
            case "set":
                return nameSet.iterator();
            case "tree":
                return treeSet.iterator();
            case "queue":
                return queues.iterator();
        }
        return null;
    }
}
