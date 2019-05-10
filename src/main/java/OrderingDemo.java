import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Guava的排序
 */
public class OrderingDemo {
  List<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 2, 7, 3, 2, 3, 4, 6 ,9));
  Ordering<String> byLengthOrdering  = new Ordering<String>() {
    public int compare(String left, String right) {
      return Ints.compare(left.length(), right.length());
    }
  };

  public boolean isOrderedTest() {
    return Ordering.natural().isOrdered(list);
  }

  public List<Integer> greatestOfTest() {
    return Ordering.natural().greatestOf(list, 4);
  }

  public List<Integer> sortedCopyTest() {
    return Ordering.natural().sortedCopy(list);
  }

  public Integer minTest() {
    return Ordering.natural().min(3, 2);
  }

  public Integer muiltMinTest() {
    return Ordering.natural().min(1, 3, 5, 7);
  }

  public Integer listMinTest() {
    return Ordering.natural().min(list);
  }
}
