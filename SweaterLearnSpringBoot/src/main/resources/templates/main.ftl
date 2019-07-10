<#import "parts/common.ftl" as baseContainer>
<@baseContainer.page>
<h1>Messages Users</h1>

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
<a class="btn btn-primary my-3" data-toggle="collapse" href="#collapseExample"
   role="button" aria-expanded="false" aria-controls="collapseExample"> Add message
</a>
<div class="collapse mt-3 <#if textError??>show</#if>" id="collapseExample">
<form method="post" enctype="multipart/form-data">
    <div class="form-group">
        <div class="form-group col-7">
            <input type="text" name="text" placeholder="Введите текст"
                   class="form-control ${(textError??)?string('is-invalid','')}"
                   value="<#if message??>${message.text}</#if>"
            />
            <#if textError??>
                <div class="invalid-feedback">
                ${textError}
                </div>
            </#if>
        </div>
        <div class="form-group col-7">
            <input type="text" name="tag" placeholder="Введите тег"
                   class="form-control ${(tagError??)?string('is-invalid','')}"
                   value="<#if message??>${message.tag}</#if>"
            />
            <#if tagError??>
            <div class="invalid-feedback">
                ${tagError}
            </div>
        </#if>
        </div>
        <div class="form-group col-7">
            <div class="custom-file">
                <input type="file" name="file" id="customFile"/>
                <label class="custom-file-label" for="customFile">Choose file</label>
            </div>
        </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <button type="submit" name="send" class="btn btn-primary">Добавить сообщение</button>
    </div>
</form>
</div>
<div class="card-columns">
<#list messages as message>
<div class="card">
    <#if message.file??>
        <img class="card-img-top" src="/img/${message.file}">
    </#if>
    <div class="card-body">
        <h5 class="card-title">${message.tag}</h5>
        <p class="card-text">${message.text}</p>
        <span style="font-weight:bold; text-align:right;">${message.authorName}</span>
    </div>
</div>
<#else>
<p>No messages</p>
</#list>
</div>
</@baseContainer.page>