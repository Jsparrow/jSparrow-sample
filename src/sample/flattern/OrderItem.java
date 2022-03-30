package sample.flattern;
import java.math.BigDecimal;

public class OrderItem {

    private Product product;
    int quantity;

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal calcTotalAmount() {
        return product.getPrice().multiply(BigDecimal.valueOf(quantity));
    }
}
