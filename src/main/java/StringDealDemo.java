import com.google.common.base.Joiner;
import com.google.common.base.Splitter;

public class StringDealDemo {
    public String joinerDemo() {
      Joiner joiner = Joiner.on(",").skipNulls();
      return joiner.join("wangy", "yu", null, "hao");
    }

    public String splitter() {
      return Splitter.on(",")
                      .trimResults()
                      .omitEmptyStrings()
                      .split("wang, yu, , hao").toString();
    }


}
