<products>
    <button type="button" onClick={fetchProducts}>Get products</button>
    <button type="button" onClick={clearProducts}>Clear</button>
    <table>
        <tbody>
            <tr each={products}>
                <td>{productId}</td>
                <td>{name}</td>
                <td>{price}</td>
            </tr>
        </tbody>
    </ul>
    <script>
     this.products = []
     fetchProducts(e) {
         const self = this;
         e.preventDefault();
         opts.client.invoke("productService", "getProducts", [])
             .then(function(products) {
                 self.products = products;
                 self.update();
             }, function(response) {
                 console.log("error");
                 console.log(response);
             });
     }

     clearProducts(e) {
         this.products = [];
         this.update();
     }
    </script>
</products>
