package markerInterface;

public class App {

    public static void main(String[] args) {
        DiscountUtils discountUtils = new DiscountUtils();
        boolean returnVal = discountUtils.isDiscountEligible(new Student());
        boolean empVal = discountUtils.isDiscountEligible(new Employee());
        System.out.println(returnVal);
        System.out.println(empVal);
    }
}
