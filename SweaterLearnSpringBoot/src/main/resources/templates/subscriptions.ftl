<#import "parts/common.ftl" as baseContainer>
<#include "parts/security.ftl">
<@baseContainer.page>
<h3>${userChannel.username}</h3>
<ul class="list-grup">
    <#list users as user>
        <li class="list-group-item">
            <a href="/user-messages/${user.id}">${user.username}</a>
        </li>
    </#list>
</ul>
</@baseContainer.page>