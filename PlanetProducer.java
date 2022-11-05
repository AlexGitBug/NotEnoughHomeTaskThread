package ThreadNewNewNew;


import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PlanetProducer implements Runnable {
    Random random = new Random();

    int counter;

    public List<Integer> list;

    public PlanetProducer() {
    }

    public PlanetProducer(List<Integer> list) {
        this.list = list;
    }

    public int getRandom() {
        return random.nextInt(5);
    }

    public int addListRedCrystal(List<Integer> list) {
        int random1 = getRandom();
        list.add(random1);
        return random1;
    }

    public int removeFromListProducer(List<Integer> list) {
        return list.remove(0);
    }

    @Override
    public void run() {
        synchronized (list) {
            while (true) {
                    int i = addListRedCrystal(list);
                    System.out.println("произведено кристаллов " + i);
                    counter = counter + i;
                try {
                    list.wait(300L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}