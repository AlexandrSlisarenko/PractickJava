<#import "parts/common.ftl" as baseContainer>
<@baseContainer.page>
<h1>Hello, guest!!!</h1>
<p>Welcome to Bookkeeping System!!!</p>
<h2 style="text-align:center;" class="my-3">Books list</h2>
<#include "parts/sortBookPanel.ftl">
<#include "parts/listBook.ftl">
</@baseContainer.page>