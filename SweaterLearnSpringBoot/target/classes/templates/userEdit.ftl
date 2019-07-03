<#import "parts/common.ftl" as baseContainer>
<@baseContainer.page>
<h1>Edit user ${user.username}</h1>
<div>
    <form action="/user" method="post">
        <input type="text" name="username" value="${user.username}">
        <#list roles as role>
        <label><input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked","")}>${role}</label>
        </#list>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <input type="hidden" name="userId" value="${user.id}" />
        <button type="submit">Save</button>
    </form>
</div>

</@baseContainer.page>