package ru.sbt.javaschool.lesson4;

import java.util.*;

/**
 * Created by скурихин on 13.08.2016.
 */
public class Application {

    //public static final int LIST_SIZE = 20;
    //public static final int MAX_RANDOM = 100;

    private TruckDao truckDao;
    private Map<Long, Truck> truckRegistry = new TreeMap<Long, Truck>();

    public Application(TruckDao truckDao) {
        List<Truck> list = truckDao.list();
        for (Truck truck : list) {
            Truck previousValue = truckRegistry.put(truck.getId(), truck);
            if (null != previousValue) {
                throw new IllegalStateException("Two truck with same ID");
            }
        }
    }

    public Truck getTrackById(long truckId) {
        Truck truck = truckRegistry.get(truckId);
        if (truck == null) {
            throw new IllegalArgumentException("not found truck with ID=" + truckId);
        }
        return truck;
    }

    void viewTruck() {
        System.out.println(truckRegistry);
    }

    void viewTruckRegistry(){
        for(Map.Entry<Long, Truck> truckEntry : truckRegistry.entrySet()){
            System.out.println(truckEntry.getKey()+": " + truckEntry.getValue());
        }

    }

    private static void printHelp() {
        System.out.println("Use first argument for Id");
    }

    public static void main(String[] args) {
        /*Random random = new Random(System.currentTimeMillis());
        List<Integer> list = new ArrayList<Integer>(LIST_SIZE);
        for(int i = 0;i< LIST_SIZE;i++){
            list.add(random.nextInt(MAX_RANDOM));
        }
        System.out.println(list);

        Set<Integer> sorted = new TreeSet<Integer>(list);

        System.out.println(sorted);
        System.out.println(sorted.size()==list.size());*/

        //-----------------

        /*if (args.length != 1) {
            printHelp();
            System.exit(1);
        }*/

        TruckDao truckDao = new TruckDaoMemoryImpl();
        //Application application = new Application(truckDao);
        //application.viewTruck();
        //application.viewTruckRegistry();

        /*long truckId = Long.parseLong(args[0]);
        Truck truckById = application.getTrackById(truckId);
        System.out.println(truckById.getCapacity());*/

        List<Truck> list = truckDao.list();
        //System.out.println(list);
        //list.add(new Truck(123,112));
        //System.out.println(list);
        //List<Truck> truckList = truckDao.list();
        //System.out.println(truckList);

        Iterator<Truck> iterator = list.iterator();
        while (iterator.hasNext()) {
            Truck truck = iterator.next();
            if (truck.getCapacity() < 20) {
                list.remove(0);
            }
        }

        /*for (Truck truck : new ArrayList<Truck>(list)) {
            if(truck.getCapacity()<20) {
                list.remove(truck);
            }
        }*/

        //System.out.println(list);
    }

}
