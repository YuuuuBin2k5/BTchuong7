<%-- 
    Document : index
    Created on : 20 Nov 2025, 13:44:05
    Author   : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
        <title>CD List</title>
    </head>
    <body>
        <h1>CD list</h1>
        
        <table>
            <tr>
                <th>Description</th>
                <th>Price</th>
                <th>&nbsp;</th>
            </tr>
            
            <%-- Sản phẩm 1: 86 (the band) - True Life Songs and Pictures --%>
            <tr>
                <td>86 (the band) - True Life Songs and Pictures</td>
                <td>$14.95</td>
                <td>
                    <%-- Form gửi yêu cầu POST đến CartServlet (url: /cart) --%>
                    <form action="cart" method="post">
                        <input type="hidden" name="action" value="addItem">
                        <input type="hidden" name="productCode" value="8601">
                        <input type="submit" value="Add To Cart">
                    </form>
                </td>
            </tr>
            
            <%-- Sản phẩm 2: Paddlefoot - The first CD --%>
            <tr>
                <td>Paddlefoot - The first CD</td>
                <td>$12.95</td>
                <td>
                    <form action="cart" method="post">
                        <input type="hidden" name="action" value="addItem">
                        <input type="hidden" name="productCode" value="pf01">
                        <input type="submit" value="Add To Cart">
                    </form>
                </td>
            </tr>
            
            <%-- Sản phẩm 3: Paddlefoot - The second CD --%>
            <tr>
                <td>Paddlefoot - The second CD</td>
                <td>$14.95</td>
                <td>
                    <form action="cart" method="post">
                        <input type="hidden" name="action" value="addItem">
                        <input type="hidden" name="productCode" value="pf02">
                        <input type="submit" value="Add To Cart">
                    </form>
                </td>
            </tr>
            
            <%-- Sản phẩm 4: Joe Rut - Genuine Wood Grained Finish --%>
            <tr>
                <td>Joe Rut - Genuine Wood Grained Finish</td>
                <td>$14.95</td>
                <td>
                    <form action="cart" method="post">
                        <input type="hidden" name="action" value="addItem">
                        <input type="hidden" name="productCode" value="jr01">
                        <input type="submit" value="Add To Cart">
                    </form>
                </td>
            </tr>
        </table>
    </body>
</html>