<#macro login path isRegisterForm>
<form action="${path}" method="post">
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">User Name :</label>
        <div class="col-sm-6">
            <input type="text" name="username" value="<#if user??>${user.username}</#if>"
                   class="form-control ${(usernameError??)?string('is-invalid', '')}"
                   placeholder="User name" />
            <#if usernameError??>
            <div class="invalid-feedback">
                ${usernameError}
            </div>
        </#if>
    </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Password</label>
        <div class="col-sm-5">
            <input type="password" name="password"
                   class="form-control ${(passwordError??)?string('is-invalid','')}"
                   placeholder="Enter yore password"/>
            <#if passwordError??>
            <div class="invalid-feedback">
                ${passwordError}
            </div>
        </#if>
    </div>
    </div>
    <#if !isRegisterForm>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Password</label>
        <div class="col-sm-5">
            <input type="password2" name="password2"
                   class="form-control ${(password2Error??)?string('is-invalid','')}"
                   placeholder="Retype yore password"/>
            <#if password2Error??>
            <div class="invalid-feedback">
                ${password2Error}
            </div>
        </#if>
    </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Email</label>
        <div class="col-sm-5">
            <input type="email" name="email"
                   class="form-control ${(emailError??)?string('is-invalid','')}"
                   value="<#if user??>${user.email}</#if>"
                   placeholder="some@some.com"
            />
            <#if emailError??>
            <div class="invalid-feedback">
                ${emailError}
            </div>
        </#if>
    </div>
    </div>
</#if>
<input type="hidden" name="_csrf" value="${_csrf.token}" />
<div class="form-group row">
    <div class="col-sm-10">
        <button type="submit" class="btn btn-primary">Sign in</button>
        <#if isRegisterForm> <a href="/registration" class="btn btn-primary"> Add New User</a></#if>
</div>
</div>
</form>
</#macro>

<#macro logout>
<form action="/logout" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <button type="submit" class="btn btn-primary ml-3">Sign Out</button>
</form>
</#macro>