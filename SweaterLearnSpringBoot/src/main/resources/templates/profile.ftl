<#import "parts/common.ftl" as baseContainer>
<#import "parts/login.ftl" as form>
<@baseContainer.page>
<h1 class="mb-3">Edit user ${username}</h1>
${message?ifExists}
<form method="post">
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Password</label>
        <div class="col-sm-5"><input type="password" name="password" class="form-control" placeholder="Enter yure password"/></div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Email</label>
        <div class="col-sm-5"><input type="email" name="email" class="form-control" placeholder="some@some.com" value="${email!''}"/></div>
    </div>
<input type="hidden" name="_csrf" value="${_csrf.token}" />
    <button type="submit" class="btn btn-primary">Edit</button>


</form>
</@baseContainer.page>