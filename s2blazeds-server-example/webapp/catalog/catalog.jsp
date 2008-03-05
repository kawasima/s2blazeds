<catalog>
<c:forEach var="p" items="${items}">
    <product productId="${p.productId}">
        <name>${p.name}</name>
        <description>${p.description}</description>
        <price>${p.price}</price>
        <image>${p.image}</image>
        <category>${p.category}</category>
        <qtyInStock>${p.qtyInStock}</qtyInStock>
    </product>
</c:forEach>
</catalog>