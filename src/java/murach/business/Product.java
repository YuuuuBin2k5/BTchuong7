package murach.business;

import java.text.NumberFormat;
import java.io.Serializable;

public class Product implements Serializable {
    private String code;
    private String description;
    private double price;

    public Product() {
        this.code = "";
        this.description = "";
        this.price = 0.0;
    }

    public Product(String code, String description, double price) {
        this.code = code;
        this.description = description;
        this.price = price;
    }

    // Getters and Setters
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    // Phương thức tiện ích để định dạng giá tiền
    public String getFormattedPrice() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(price);
    }
    
    // --- PHƯƠNG THỨC TĨNH TRUY XUẤT DỮ LIỆU (THAY THẾ ProductIO/ProductDB) ---
    /**
     * Trả về đối tượng Product dựa trên mã code (hardcode).
     * @param productCode Mã sản phẩm cần tìm.
     * @return Đối tượng Product hoặc null nếu không tìm thấy mã.
     */
    public static Product getProductByCode(String productCode) {
        // Dữ liệu hardcode mô phỏng danh sách CD từ trang Index
        return switch (productCode) {
            case "8601" -> new Product("8601", "86 (the band) - True Life Songs and Pictures", 14.95);
            case "pf01" -> new Product("pf01", "Paddlefoot - The first CD", 12.95);
            case "pf02" -> new Product("pf02", "Paddlefoot - The second CD", 14.95);
            case "jr01" -> new Product("jr01", "Joe Rut - Genuine Wood Grained Finish", 14.95);
            default -> null; 
        };
    }
}