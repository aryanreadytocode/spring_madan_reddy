package markerInterface;

public class DiscountUtils {

    public boolean isDiscountEligible(Object object) {
        if (object instanceof IDiscount)
            return true;
        return false;
    }
}
