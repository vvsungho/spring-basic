package study.core.springbasic.order.domain;

public class Order {
    private Long id;
    private Long memberId;
    private String productName;
    private Long price;
    private Long discountPrice;

    public Order(Long id, Long memberId, String productName, Long price, Long discountPrice) {
        this.id = id;
        this.memberId = memberId;
        this.productName = productName;
        this.price = price;
        this.discountPrice = discountPrice;
    }

    public Order(Long id, Long memberId, String productName, Long price) {
        this.id = id;
        this.memberId = memberId;
        this.productName = productName;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public String getProductName() {
        return productName;
    }

    public Long getPrice() {
        return price;
    }

    public Long getDiscountPrice() {
        return discountPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", memberId=" + memberId +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", discountPrice=" + discountPrice +
                '}';
    }
}
