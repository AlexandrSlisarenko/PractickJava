<#import "parts/common.ftl" as baseContainer>
<@baseContainer.page>
<h1>List user</h1>
<div>
    <table>
        <thead>
        <tr>
            <td>Name</td>
            <td>Role</td>
            <td></td>
        </tr>
        </thead>
        <body>
        <#list users as user>
        <tr>
            <td>${user.username}</td>
            <td><#list user.roles as role>${role}<#sep>; </#sep></#list></td>
        <td><a href="/user/${user.id}">edit</td>
        </tr>
        </#list>
        </body>
    </table>
</div>

</@baseContainer.page>