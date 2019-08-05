package diesel.masapp.orders.domain;

import java.util.Arrays;
import java.util.Optional;

public enum ItemClassification {

    WHOLE,
    PIECES,
    PROCESSED,
    OFFAL;


    public static ItemClassification fromString(final String itemClassification) {
        Optional<ItemClassification> optionalItemClassification =
                Arrays.stream(ItemClassification.values()).filter(itemSize1 -> itemSize1.name().equalsIgnoreCase(itemClassification)).findFirst();
        if (optionalItemClassification.isPresent()) {
            return optionalItemClassification.get();
        } else {
            return null;
        }
    }

}
