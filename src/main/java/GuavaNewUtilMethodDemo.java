import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Lists;
import java.util.List;

/**
 * Guava新的集合方法
 */
public class GuavaNewUtilMethodDemo {

  User u1 = new User(20, "lili");
  User u2 = new User(19, "haha");
  User u3 = new User(20, "niu");
  User u4 = new User(23, "keke");
  List<User> userList = Lists.newArrayList(u1, u2, u3, u4);

  /**
   * steam Filter
   */
  public void fluentIterableFilterTest() {
    FluentIterable<User> users = FluentIterable.from(userList).filter(new Predicate<User>() {
      public boolean apply(User user) {
        return user.getAge() == 20;
      }
    });
    for (int i = 0; i < users.size(); i++) {
      System.out.println(users.get(i).getName());
    }
  }

  /**
   * stream map
   */
  public void fluentIterableTransformTest() {
    FluentIterable<User> users = FluentIterable.from(userList).transform(new Function<User, User>() {
      public User apply(User user) {
        return new User(user.getAge(), user.getName());
      }
    });
  }


}
