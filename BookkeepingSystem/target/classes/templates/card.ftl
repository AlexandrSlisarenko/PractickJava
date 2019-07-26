<#import "parts/common.ftl" as baseContainer>
<@baseContainer.page>
<h1>Basket</h1>
<div class="container">
    <h3>Order Data</h3>
    <p>Id Order : ${order.idOrder}</p>
    <p>Price Order: ${order.priceOrder}</p>
    <table class="table table-striped">
        <thead>
        <tr>
            <td scope="col">Title</td>
            <td scope="col">Count</td>
            <td scope="col">Delet?</td>
        </tr>
        </thead>
        <body>
        <#list order.nameAndQuantityBook?keys as key>
        <tr>
            <td scope="row">${key}</td>
            <td> <input type="text" name="username" value="${order.nameAndQuantityBook[key]}"
                        class="form-control"
                        /> </td>
            <td>YES</td>
        </tr>
        </#list>
        </body>
    </table>
    <h3>Books</h3>
    <table class="table table-striped">
        <thead>
        <tr>
            <td scope="col">Title</td>
            <td scope="col">Author</td>
            <td scope="col">Genre</td>
            <td scope="col">Price</td>

        </tr>
        </thead>
        <#list order.booksOrder as book>
        <tr>
            <td scope="row">${book.title}</td>
            <td>${book.author}</td>
            <td>${book.genre}</td>
            <td>${book.price}</td>

        </tr>
        </#list>
        </body>
    </table>
</div>

</@baseContainer.page>