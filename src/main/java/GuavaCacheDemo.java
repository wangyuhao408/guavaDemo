import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;
import com.google.common.cache.Weigher;
import java.util.concurrent.TimeUnit;

/**
 * 缓存
 */
public class GuavaCacheDemo {

  /**
   * 基础调用
   */
  public void baseUserTest() {
    CacheLoader<String, String> loader = new CacheLoader<String, String>() {
      @Override
      public String load(String key) throws Exception {
        return key.toUpperCase();
      }
    };
    LoadingCache<String, String> cache;
    cache = CacheBuilder.newBuilder().build(loader);
    System.out.println(cache.getUnchecked("hello"));
  }

  /**
   * 设置cache长度，超过就删除
   */
  public void maxSizeDeleteTest() {
    CacheLoader<String, String> loader = new CacheLoader<String, String>() {
      @Override
      public String load(String key) throws Exception {
        return key.toUpperCase();
      }
    };
    LoadingCache<String, String> cache;
    cache = CacheBuilder.newBuilder().maximumSize(2).build(loader);
    cache.getUnchecked("one");
    cache.getUnchecked("two");
    cache.getUnchecked("third");
    System.out.println(cache.size());
  }

  /**
   * 根据value长度来删除
   */
  public void customDeleteByLength() {
    CacheLoader<String, String> loader = new CacheLoader<String, String>() {
      @Override
      public String load(String key) throws Exception {
        return key.toUpperCase();
      }
    };
    Weigher<String, String> weigherByLength = new Weigher<String, String>() {
      public int weigh(String key, String value) {
        return value.length();
      }
    };
    LoadingCache<String, String> cache = CacheBuilder
        .newBuilder()
        .maximumSize(2)
        .weigher(weigherByLength)
        .build(loader);
    cache.getUnchecked("first");
    cache.getUnchecked("second");
    cache.getUnchecked("third");
    cache.getUnchecked("last");
    System.out.println(cache.size());
  }

  /**
   * 根据value闲置时间来删除
   */
  public void customDeleteByTime() {
    CacheLoader<String, String> loader;
    loader = new CacheLoader<String, String>() {
      @Override
      public String load(String key) {
        return key.toUpperCase();
      }
    };
    LoadingCache<String, String> cache;
    cache = CacheBuilder.newBuilder()
        .expireAfterAccess(2, TimeUnit.MILLISECONDS)
        .build(loader);
    cache.getUnchecked("hello");
    System.out.println(cache.size());
    cache.getUnchecked("hello");
    try {
      Thread.sleep(300);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    cache.getUnchecked("test");
    System.out.println(cache.size());
  }

  /**
   * 删除通知
   */
  public void noticeOnDelete() {
    CacheLoader<String, String> loader = new CacheLoader<String, String>() {
      @Override
      public String load(final String key) {
        return key.toUpperCase();
      }
    };
    RemovalListener<String, String> listener = new RemovalListener<String, String>() {
      public void onRemoval(RemovalNotification<String, String> removalNotification) {
        if (removalNotification.wasEvicted()) {
          System.out.println("该缓存被删除了" + removalNotification.getKey());
        }
      }
    };
    LoadingCache<String, String> cache = CacheBuilder
        .newBuilder()
        .maximumSize(3)
        .removalListener(listener)
        .build(loader);
    cache.getUnchecked("first");
    cache.getUnchecked("second");
    cache.getUnchecked("third");
    cache.getUnchecked("last");
    System.out.println(cache.size());
  }
}
