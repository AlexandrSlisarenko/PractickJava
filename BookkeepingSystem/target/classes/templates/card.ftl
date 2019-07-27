<#import "parts/common.ftl" as baseContainer>
<@baseContainer.page>
<h1>Basket</h1>
<#if order != -1>
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
        <#assign i = 0 >
        <#list order.nameAndQuantityBook?keys as key>
        <tr>
            <td scope="row">${key}</td>
            <td>
                <form method="post" action="/card/editcount">
                    <div class="form-row align-items-center">
                        <div class="col-auto">
                            <div class="input-group mb-2">
                                <input type="text" name="quantity" value="${order.nameAndQuantityBook[key]}" class="form-control"/>
                            </div>
                        </div>

                        <div class="col-auto">
                            <input type="hidden" name="_csrf" value="${_csrf.token}" />
                            <input type="hidden" name="idBookInorder" value="${order.booksIdInOrder[i]}" />
                            <button type="submit" class="btn btn-primary mb-2">Add</button>
                        </div>
                    </div>
                </form>
                 </td>
            <td><a href="/card/delbook?id=${order.booksIdInOrder[i]}">YES</a></td>
        </tr>
        <#assign i = i + 1>
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
    <a href="/card/сheckout?orderId=${order.idOrder}" class="btn btn-primary mb-2">Checkout order!</a>
</div>
<#else>
<p>No order...</p>
</#if>
</@baseContainer.page>