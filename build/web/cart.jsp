<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%-- 1. Lấy đối tượng Cart từ session. Tên attribute là "cart". --%>
<c:set var="cart" value="${sessionScope.cart}" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%-- Liên kết với file CSS để định dạng --%>
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
        <title>Your Cart</title>
    </head>
    <body>
        <h1>Your cart</h1>
        
        <c:choose>
            <c:when test="${cart.itemCount == 0}">
                <p>Your cart is empty.</p>
            </c:when>
            <c:otherwise>
                <table>
                    <tr>
                        <th>Quantity</th>
                        <th>Description</th>
                        <th>Price</th>
                        <th>Amount</th>
                        <th>&nbsp;</th>
                    </tr>
                    
                    <%-- 2. Lặp qua danh sách LineItem (items) trong Cart --%>
                    <c:forEach var="item" items="${cart.items}">
                        <tr>
                            <%-- 3. CỘT CẬP NHẬT (UPDATE) - Sử dụng form POST --%>
                            <td>
                                <form action="cart" method="post">
                                    <input type="hidden" name="action" value="update">
                                    <input type="hidden" name="productCode" value="${item.product.code}">
                                    
                                    <input type="text" name="quantity" value="${item.quantity}" style="width: 50px;">
                                    <input type="submit" value="Update">
                                </form>
                            </td>
                            
                            <%-- Hiển thị thông tin sản phẩm và giá --%>
                            <td>${item.product.description}</td>
                            <td>${item.product.formattedPrice}</td>
                            <td>${item.formattedTotal}</td>

                            <%-- 4. CỘT XÓA (REMOVE) - Sử dụng liên kết GET/Viết lại URL --%>
                            <td>
                                <%-- Theo Bài tập 7-3: Thay nút Remove bằng liên kết GET. 
                                     Tham số (action & productCode) sẽ hiển thị trong URL. --%>
                                <a href="cart?action=remove&productCode=${item.product.code}">Remove Item</a>
                            </td>
                        </tr>
                    </c:forEach>
                    
                    <%-- Dòng tổng cộng --%>
                    <tr>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td><b>Total:</b></td>
                        <td><b>${cart.formattedTotal}</b></td>
                        <td>&nbsp;</td>
                    </tr>
                </table>
            </c:otherwise>
        </c:choose>
        
        <%-- Vùng thông báo hướng dẫn --%>
        <p>To change the quantity, enter the new quantity and click on the Update button.</p>

        <%-- 5. Các nút chức năng dưới cùng --%>
        <form action="cart" method="post">
            <input type="submit" name="action" value="Continue Shopping">
            <input type="submit" name="action" value="Checkout">
        </form>
        
    </body>
</html>