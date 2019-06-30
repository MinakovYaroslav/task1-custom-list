public class Main {

    public static void main(String[] args) {

        IncrementalArrayList list = new IncrementalArrayList();

        //Add elements
        list.add(1);
        System.out.println(list.toString());

        list.add(4);
        System.out.println(list.toString());

        //Try to add null value
        list.add(null);
        System.out.println(list.toString());

        list.add(10);
        System.out.println(list.toString());

        //Print list average
        System.out.println("List average: " + list.avg());

        //Print list min element
        System.out.println("List min: " + list.min());

        //Print list max element
        System.out.println("List max: " + list.max());

        //Print element by index
        System.out.println("List element with index " + 2 + " = " + list.get(2));

        //Remove elements
        list.remove(2);
        System.out.println(list.toString());

        list.remove(1);
        System.out.println(list.toString());

        list.remove(0);
        System.out.println(list.toString());
    }
}
