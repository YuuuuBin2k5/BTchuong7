package murach.controllers;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

// Import các lớp model của bạn
import murach.business.Cart;
import murach.business.LineItem;
import murach.business.Product;
// KHÔNG CẦN import murach.data.ProductIO; nữa

@WebServlet(name = "CartServlet", urlPatterns = {"/cart"})
public class CartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String url = "/index.jsp";
        String action = request.getParameter("action");
        
        if (action == null) {
            action = "cart";
        }

        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
        }
        
        // --- Logic Xử lý Cart ---
        
        if (action.equals("addItem")) {
            String productCode = request.getParameter("productCode");
            // SỬ DỤNG PHƯƠNG THỨC GIẢ LẬP
            Product product = Product.getProductByCode(productCode); 
            int quantity = cart.getQuantityByCode(productCode);

            if (product != null) {
                LineItem lineItem = new LineItem(product, quantity+1);
                cart.addItem(lineItem);
            }
           
            url = "/cart.jsp"; 
            
        } else if (action.equals("update")) {
            String productCode = request.getParameter("productCode");
            String quantityString = request.getParameter("quantity");
            int quantity;

            try {
                quantity = Integer.parseInt(quantityString);
         
                Product product = Product.getProductByCode(productCode);
                
                if (product != null) {
                    LineItem lineItem = new LineItem(product, quantity);
                    if (quantity > 0) {
                        cart.addItem(lineItem); 
                    } else {
                        cart.removeItem(lineItem);
                    }
                }
            } catch (NumberFormatException e) {
                
            }
            
            url = "/cart.jsp";
            
        } else if (action.equals("remove")) {
            String productCode = request.getParameter("productCode");
            // SỬ DỤNG PHƯƠNG THỨC GIẢ LẬP
            Product product = Product.getProductByCode(productCode);
            
            if (product != null) {
                LineItem lineItem = new LineItem(product, 0); 
                cart.removeItem(lineItem);
            }
            
            url = "/cart.jsp";
        } else if (action.equals("cart")) {
            url = "/cart.jsp";
        } else if (action.equals("Continue Shopping")) {
             url = "/index.jsp";
        }
        
        session.setAttribute("cart", cart);

        getServletContext().getRequestDispatcher(url).forward(request, response);
    }
}