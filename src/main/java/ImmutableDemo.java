import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 不可变集合
 */
public class ImmutableDemo {
  public static final ImmutableList<String> COLOR_NAMES = ImmutableList.of(
      "red",
      "blue",
      "yellow",
      "green",
      "purple",
      "orange"
  );

  public ImmutableList<Integer> copyTest() {
    List<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 2, 7, 3, 2, 3, 4, 6 ,9));
    return ImmutableList.copyOf(list);
  }
}
