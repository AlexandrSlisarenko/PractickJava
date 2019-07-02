<#import "parts/common.ftl" as baseContainer>
<#import "parts/login.ftl" as form>
<@baseContainer.page>
<h1>Login Page</h1>
<@form.login "/login" />
<a href="/registration"> Add New User</a>
</@baseContainer.page>