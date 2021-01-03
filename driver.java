/**
 * Final driver for the project
 * 
 * @author Deepali Juneja
 * @version 4 June 2020
 */
public class driver {
    public static void main(String[] args) {
        ArrayList<Integer> check = new ArrayList<>();
        check.add(1);
        check.add(2);
        check.add(3);
        check.insert(5, 1);
        System.out.println(check);
        System.out.println(check.remove(1));
        System.out.println(check);
    }
}