package diesel.masapp.orders.domain;

import java.util.Arrays;
import java.util.Optional;

public enum ItemSize {

    SMALL,
    MEDIUM,
    LARGE,
    TWO_PACK,
    THREE_PACK,
    FOUR_PACK,
    SIX_PACK,
    EIGHT_PACK,
    TEN_PACK,
    FIVE_HUNDRED_GRAMS,
    UNASSIGNED;

    public static ItemSize fromString(final String itemSize) {
        Optional<ItemSize> optionalItemSize =
                Arrays.stream(ItemSize.values()).filter(itemSize1 -> itemSize1.name().equalsIgnoreCase(itemSize)).findFirst();
        if (optionalItemSize.isPresent()) {
            return optionalItemSize.get();
        } else {
            return null;
        }
    }
}
