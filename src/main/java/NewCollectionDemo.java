import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.BiMap;
import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.MutableClassToInstanceMap;
import com.google.common.collect.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * Guava新的集合
 */
public class NewCollectionDemo {

  public void multiSetTest() {
    String strWorld = "wer|dfd|dd|dfd|dda|de|dr";
    String[] words = strWorld.split("\\|");
    List<String> wordList = new ArrayList<String>();
    for (String word : words) {
      wordList.add(word);
    }
    Multiset<String> wordsMultiset = HashMultiset.create();
    wordsMultiset.addAll(wordList);
    System.out.println(wordsMultiset.count("dfd"));
    System.out.println(wordsMultiset.elementSet().toString());
    System.out.println(wordsMultiset.entrySet().toString());
    System.out.println(wordsMultiset.size());
  }

  public void multimapTest() {
    Multimap multimap = ArrayListMultimap.create();
    multimap.put(1, "a");
    multimap.put(1, "b");
    System.out.println(multimap.get(1).toString());
  }

  public void biMapTest() {
    BiMap biMap = HashBiMap.create();
    biMap.put(1, "a");
    biMap.inverse();
    System.out.println(biMap.get("a"));
  }

  public void tableTest() {
    Table table = HashBasedTable.create();
    table.put("一年级", "一班", "wyh");
    table.put("一年级", "二班", "wsh");
    System.out.println(table.get("一年级", "一班"));
    System.out.println(table.get("一年级", "二班"));
  }

  public void classToInstanceMapTest() {
    ClassToInstanceMap classToInstanceMap = MutableClassToInstanceMap.create();
    classToInstanceMap.put(String.class, "wyh");
    System.out.println(classToInstanceMap.get(String.class));
  }
}
