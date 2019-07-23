<#import "parts/common.ftl" as baseContainer>
<#include "parts/security.ftl">
<@baseContainer.page>
<h1>Messages Users</h1>
<div class="form-row">
    <form method="post" action="filter">
        <div class="form-row">
            <div class="col-5">
                <input type="text" name="filter" class="form-control" value="${filter?ifExists}">
            </div>
                <input type="hidden" name="_csrf" value="${_csrf.token}">
            <div class="col-3">
                <button type="submit" class="btn btn-primary">Filtr to tag</button>
            </div>
        </div>
    </form>
</div>
<#include "parts/addMessage.ftl">
<#include "parts/getMessage.ftl">

</@baseContainer.page>