package ThreadNewNewNew;

import java.util.List;

    public class ConsumerFire implements Runnable {
        PlanetProducer producer = new PlanetProducer();
        private List<Integer> list;
        private int counter;

        public ConsumerFire(List<Integer> list) {
            this.list = list;
        }

        @Override
        public void run() {
            synchronized (list) {
                while (true) {
                    if (!list.isEmpty()) {
                        if (counter <= 20) {
                            int e = producer.removeFromListProducer(list);
                            System.out.println("Добавлено кристаллов в копилку Огонь: " + e);
                            counter = counter + e;
                            System.out.println("Всего красных кристаллов в копилке Огня: +++++++++++++++++++++++++++++++" + counter);
                        } else if (counter > 19) {
                            System.out.println("----------СТОП----------- ДОБЫТО -------------- " + counter);
                            break;
                        }
                    } else if (list.isEmpty()) {
                        System.out.println("ракета полетела путой на базу Огня");

                        try {
                            list.wait(300L);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
    }

