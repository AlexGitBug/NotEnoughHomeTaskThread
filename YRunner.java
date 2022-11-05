package ThreadNewNewNew;


import java.util.ArrayList;
import java.util.List;
public class YRunner {


        public static void main(String[] args) throws InterruptedException {
            List<Integer> list = new ArrayList<>();
            Thread producer = new Thread(new PlanetProducer(list));
            Thread consumerFire = new Thread(new ConsumerFire(list));
            Thread consumerWater = new Thread(new ConsumerWater(list));

            producer.start();
            consumerFire.start();
            consumerWater.start();

            producer.join();
            consumerFire.join();
            consumerWater.join();
        }
    }

