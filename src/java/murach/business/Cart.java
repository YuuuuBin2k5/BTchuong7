package murach.business;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;

public class Cart implements Serializable {
    private ArrayList<LineItem> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public ArrayList<LineItem> getItems() {
        return items;
    }
    
    // Phương thức thêm/cập nhật số lượng sản phẩm
    public void addItem(LineItem item) {
        String code = item.getProduct().getCode();
        int quantity = item.getQuantity();

        for (int i = 0; i < items.size(); i++) {
            LineItem lineItem = items.get(i);
            if (lineItem.getProduct().getCode().equals(code)) {
                // Nếu sản phẩm đã tồn tại, cập nhật số lượng
                lineItem.setQuantity(quantity);
                return;
            }
        }
        // Nếu sản phẩm chưa tồn tại, thêm mới
        items.add(item);
    }
    
    // Phương thức xóa sản phẩm khỏi giỏ hàng
    public void removeItem(LineItem item) {
        String code = item.getProduct().getCode();
        for (int i = 0; i < items.size(); i++) {
            LineItem lineItem = items.get(i);
            if (lineItem.getProduct().getCode().equals(code)) {
                items.remove(i);
                return;
            }
        }
    }
    
    public int getQuantityByCode(String productCode) {
        for (LineItem item : items) { // items là ArrayList<LineItem>
            if (item.getProduct().getCode().equals(productCode)) {
                return item.getQuantity();
            }
        }
        return 0; // Trả về 0 nếu sản phẩm không có trong giỏ hàng
    }
    
    // Phương thức tính tổng giá trị giỏ hàng
    public double getTotal() {
        double total = 0.0;
        for (LineItem item : items) {
            total += item.getTotal();
        }
        return total;
    }
    
    public String getFormattedTotal() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(this.getTotal());
    }
    
    // Phương thức lấy số lượng mặt hàng khác nhau trong giỏ
    public int getItemCount() {
        return items.size();
    }
}