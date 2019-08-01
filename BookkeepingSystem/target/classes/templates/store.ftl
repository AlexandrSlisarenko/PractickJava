<#import "parts/common.ftl" as baseContainer>
<@baseContainer.page>
<h1>Store</h1>
<h3>List books</h3>
<div class="container">
    <div class="card-columns">
        <#list books as book>
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">${book.title}</h5>
                    <p class="card-text">${book.author}</p>
                    <p class="card-text">${book.genre}</p>
                    <p class="card-text">${book.count}</p>
                    <p class="card-text">${book.price}</p>
                </div>
            </div>
        <#else>
            <p>No books.....</p>
        </#list>
    </div>
</div>
<a href="/store/neworder">New Order</a>
</@baseContainer.page>