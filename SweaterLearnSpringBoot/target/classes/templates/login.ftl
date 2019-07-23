<#import "parts/common.ftl" as baseContainer>
<#import "parts/login.ftl" as form>
<@baseContainer.page>
<h1 class="mb-3">Login Page</h1>
<#if Session?? && Session.SPRING_SECURITY_LAST_EXCEPTION??>
<div class="alert alert-danger" role="alert">
    ${Session.SPRING_SECURITY_LAST_EXCEPTION.message}
</div>
</#if>
<#if message??>
<div class="alert alert-${messageType}" role="alert">
    ${message}
</div>
</#if>
<@form.login "/login" true />
</@baseContainer.page>