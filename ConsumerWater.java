package ThreadNewNewNew;

import java.util.List;

    public class ConsumerWater implements Runnable{
        PlanetProducer producer = new PlanetProducer();
        private List<Integer> list;
        private List<Integer> list2;
        private int counter;

        public ConsumerWater(List<Integer> list) {
            this.list = list;
        }

        @Override
        public void run() {
            synchronized (list) {
                while (true) {
                    if (!list.isEmpty()) {
                        if (counter <= 20) {
                        int e = producer.removeFromListProducer(list);
                        System.out.println("Добавлено кристаллов в копилку Вода: " + e);
                        counter = counter + e;
                        System.out.println("Всего красных кристаллов в копилке ВОДА: +++++++++++++++++++++++++++++++" + counter);
                        } else if (counter > 19) {
                            System.out.println("----------СТОП----------- ДОБЫТО -------------- " + counter);
                            break;
                        }
                    } else if (list.isEmpty()) {
                        System.out.println("ракета полетела пустой на базу Воды");
                    }
                    try {
                        list.wait(300L);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
