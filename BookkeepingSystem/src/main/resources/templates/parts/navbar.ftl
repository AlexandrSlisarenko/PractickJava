<#include "security.ftl">
<#import "login.ftl" as formL>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">Bookkeeping System</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/">Home</a>
            </li>
            <#if isAdmin>
                <li class="nav-item">
                    <a class="nav-link" href="/store">Store</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="/user">Users List</a>
                </li>
            </#if>
            <#if user??>
                <li class="nav-item">
                    <a class="nav-link" href="/user/profile">User profile</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/user/likedList">Liked books</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/card">Card</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/card/historyorders">History orders</a>
                </li>
             </#if>
    </ul>
    <div class="navbar-text">${name}</div>
    <#if isLogin>
    <@formL.logout />
    <#else>
    <a href="/login" class="btn btn-primary ml-3">Sign in</a>
</#if>
</div>
</nav>