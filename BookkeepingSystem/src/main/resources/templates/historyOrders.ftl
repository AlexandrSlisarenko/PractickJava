<#import "parts/common.ftl" as baseContainer>
<@baseContainer.page>
<h1>History orders</h1>
<div class="container">
    <table class="table table-striped">
        <thead>
        <tr>
            <td scope="col">Order id</td>
            <td scope="col">Books</td>
            <td scope="col">Price</td>
            <td scope="col">Repeat order</td>
        </tr>
        </thead>
        <body>
        <#list history as order>

        <tr>
            <td scope="row">${order.idOrder}</td>
            <td scope="row">
                <#list order.nameAndQuantityBook?keys as key>
                    <p>${key}(${order.nameAndQuantityBook[key]})</p>
                </#list>
            </td>
            <td scope="row">${order.priceOrder}</td>
            <td><a href="/card/repeatorder?id=${order.idOrder}">YES</a></td>
        </tr>
        <#else>
        <p> History is clean...</p>
        </#list>
        </body>
    </table>
</div>
</@baseContainer.page>