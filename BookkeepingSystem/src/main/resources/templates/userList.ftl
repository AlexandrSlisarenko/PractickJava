<#import "parts/common.ftl" as baseContainer>
<@baseContainer.page>
<h1>List user</h1>
<div>
    <table class="table table-striped">
        <thead>
        <tr>
            <td scope="col">Name</td>
            <td scope="col">Role</td>
            <td scope="col"></td>
        </tr>
        </thead>
        <body>
        <#list users as user>
        <tr>
            <td scope="row">${user.username}</td>
            <td><#list user.roles as role>${role}<#sep>; </#sep></#list></td>
        <td><a href="/user/${user.id}">edit</td>
        </tr>
        </#list>
        </body>
    </table>
</div>

</@baseContainer.page>