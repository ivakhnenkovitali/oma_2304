package by.itclass.model.entities;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@RequiredArgsConstructor
public class OrderItem {
    private String orderId;
    private final int itemType;
    private final int itemId;
    private final String itemVendor;
    private final String itemModel;
    private final double itemPrice;
    @NonNull @Setter
    private int quantity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItem item)) return false;
        if (itemType != item.itemType) return false;
        if (itemId != item.itemId) return false;
        return Objects.equals(orderId, item.orderId);
    }

    @Override
    public int hashCode() {
        int result = orderId.hashCode();
        result = 31 * result + itemType;
        result = 31 * result + itemId;
        return result;
    }
}
