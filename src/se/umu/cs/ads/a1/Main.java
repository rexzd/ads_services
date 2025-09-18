package se.umu.cs.ads.a1;

import se.umu.cs.ads.a1.backend.InMemoryMessengerBackEnd;
import se.umu.cs.ads.a1.clients.LogicTest;
import se.umu.cs.ads.a1.clients.PerformanceTest;
import se.umu.cs.ads.a1.interfaces.Messenger;
import se.umu.cs.ads.a1.types.Topic;
import se.umu.cs.ads.a1.types.Username;
import se.umu.cs.ads.a1.util.Util;

public class Main
{
  //----------------------------------------------------------
  //----------------------------------------------------------
  public static void main (String[] args)
  {
    try
    {
      // defaults to example messenger implementation
      final String[] arguments = Util.filterFlags(args);
      final String fqn = arguments.length > 0 ? arguments[0] : InMemoryMessengerBackEnd.class.getCanonicalName();

      // dynamic class loading for messenger instantiation
      Messenger messenger = Util.loadMessenger(fqn);

      // test data
      Username username = new Username("testusername");

      // example utility function
      if (Util.containsFlag(args,"-topics"))
      {
        Topic[] topics = messenger.listTopics(username);
        System.out.println(topics.length + " topics");
        for (Topic t : topics)
          System.out.println("  " + t);
      }

      // example logic test
      if (Util.containsFlag(args,"-logic"))
      {
        LogicTest.test(messenger);
      }

      // example performance test
      if (Util.containsFlag(args,"-perf"))
      {
        PerformanceTest test = new PerformanceTest(messenger);
        test.testMessageRetrieval(username, 100, 128);

        int[] messageCounts = {100, 1000, 10000, 100000};
        int[] payloadSizes = {64, 128, 256, 512, 1024};

        for (int nr : messageCounts) {
            for (int size : payloadSizes) {
                test.testMessageRetrieval(username, nr, size);
            }
        }
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
}
