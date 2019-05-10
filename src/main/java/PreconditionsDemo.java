import com.google.common.base.Preconditions;

/**
 * Guava前置条件检查
 */
public class PreconditionsDemo {

  OptionalDemo optionalDemo = new OptionalDemo();

  public void checkArgumentTest() {
    Preconditions.checkArgument(optionalDemo.isPresentTest(null));
  }

  public String checkNotNullTest() {
    return Preconditions.checkNotNull(new String("1"));
  }

  public void checkStateTest() {
    Preconditions.checkState(optionalDemo.isPresentTest(null));
  }

  public void checkElementIndexTest() {
    Preconditions.checkElementIndex(1, Integer.parseInt(new String("1")));
  }
}
