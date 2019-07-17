<#import "parts/common.ftl" as baseContainer>
<#import "parts/login.ftl" as form>
<@baseContainer.page>
<h1>Registration Page</h1>
${message?ifExists}
<@form.login "/registration" false/>
</@baseContainer.page>