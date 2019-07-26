<#include "security.ftl">
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

                <#if user??>
                    <#if addDel>
                        <a class="btn btn-info" href="/user/liked?bookId=${book.id}">LikeBook</a>
                    <#else>
                        <a class="btn btn-info" href="/user/delliked?bookId=${book.id}">DelLike</a>
                    </#if>
                    <#include "addToCard.ftl">
                </#if>
            </div>

        </div>

        <#else>
        <p>No books.....</p>
    </#list>
</div>
</div>