import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.Monitor;
import com.google.common.util.concurrent.Monitor.Guard;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;


/**
 * 并发
 */
public class ConcurrentDemo {

  private static final Integer MAX_SIZE = 10;
  private List<String> list = new ArrayList<String>();

  /**
   *
   * @param item
   * @throws InterruptedException
   */
  public void monitorTest(String item) throws InterruptedException {
    Monitor monitor = new Monitor();
    Guard listSizeMonitor = new Guard(monitor) {
      @Override
      public boolean isSatisfied() {
        return list.size() < MAX_SIZE;
      }
    };
    monitor.enterWhen(listSizeMonitor);
    try {
      list.add(item);
    } finally {
      monitor.leave();
    }
  }

  public void ListenableFutureTest() {
    ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));
    ListenableFuture listenableFuture = service.submit(new Callable() {
      public Object call() throws Exception {
        return "";
      }
    });
    Futures.addCallback(listenableFuture, new FutureCallback() {
      public void onSuccess(Object o) {

      }

      public void onFailure(Throwable throwable) {

      }
    });
  }
}
