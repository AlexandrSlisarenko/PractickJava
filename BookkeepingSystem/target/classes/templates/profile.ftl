<#import "parts/common.ftl" as baseContainer>
<#import "parts/login.ftl" as form>
<@baseContainer.page>
<h1 class="mb-3">Login Page</h1>
<#if Session?? && Session.SPRING_SECURITY_LAST_EXCEPTION??>
<div class="alert alert-danger" role="alert">
    ${Session.SPRING_SECURITY_LAST_EXCEPTION.message}
</div>
</#if>
<@form.login "/login" true />
<div class="container">
    <form method="post" action="/user/profile/addMany">
        <div class="form-row align-items-center">
           <div class="col-auto">
                <label class="sr-only" for="inlineFormInputGroup">Many</label>
                <div class="input-group mb-2">
                    <div class="input-group-prepend">
                        <div class="input-group-text">Many</div>
                    </div>
                    <input type="text" class="form-control" placeholder="${many}" id="inlineFormInputGroup" >
                </div>
            </div>

            <div class="col-auto">
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <button type="submit" class="btn btn-primary mb-2">Add</button>
            </div>
        </div>


    </form>
</div>
</@baseContainer.page>