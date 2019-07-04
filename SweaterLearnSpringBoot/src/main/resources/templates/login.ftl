<#import "parts/common.ftl" as baseContainer>
<#import "parts/login.ftl" as form>
<@baseContainer.page>
<h1 class="mb-3">Login Page</h1>
<@form.login "/login" true />
</@baseContainer.page>