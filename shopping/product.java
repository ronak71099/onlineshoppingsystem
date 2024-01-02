package shopping;

class product {
    private String productName;
    private String productId;
    private String category;
    private int productQuantity;
    private int price;

    public product(String productName, String productId, String category, int productQuantity, int price) {
        this.productName = productName;
        this.productId = productId;
        this.category = category;
        this.productQuantity = productQuantity;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductId() {
        return productId;
    }
    // Getters and setters...

    @Override
    public String toString() {
        return "Product{name='" + productName + "', id='" + productId + "', category='" + category +
                "', quantity=" + productQuantity + '}';
    }
}


