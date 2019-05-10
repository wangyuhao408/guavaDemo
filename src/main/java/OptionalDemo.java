import com.google.common.base.Optional;
import java.util.Set;

/**
 * Guava的Optional
 */
public class OptionalDemo {
  public Optional<Class<Integer>> ofTest(Integer integer) {
    return Optional.of(Integer.class);
  }

  public Optional<Integer> absentTest() {
    return Optional.absent();
  }

  public Optional<Class<Integer>> fromNullableTest() {
    return Optional.fromNullable(Integer.class);
  }

  public boolean isPresentTest(String text){
    return Optional.of(text).isPresent();
  }

  public String getTest(String text) {
    return Optional.of(text).get();
  }

  public String orTest(String text) {
    return Optional.of(text).or(new String("1"));
  }

  public String orNullTest(String text) {
    return Optional.of(text).orNull();
  }

  public Set<String> asSetTest(String text) {
    return Optional.of(text).asSet();
  }
}
