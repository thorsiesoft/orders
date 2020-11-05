package diesel.masapp.orders.domain;

import java.util.Arrays;
import java.util.Optional;

public enum Product {

    CHICKEN,
    THIGHS,
    DRUMSTICKS,
    WINGS,
    FILLETS,
    QUARTERS,
    HALVES,
    FLATTY,
    MINCE,
    STRIPS,
    LIVERS,
    NECKS,
    FEET,
    STOMACH;

    public static Product fromString(final String product) {
        Optional<Product> optionalProduct =
                Arrays.stream(Product.values()).filter(product1 -> product1.name().equalsIgnoreCase(product)).findFirst();
        if (optionalProduct.isPresent()) {
            return optionalProduct.get();
        } else {
            return null;
        }
    }

}
