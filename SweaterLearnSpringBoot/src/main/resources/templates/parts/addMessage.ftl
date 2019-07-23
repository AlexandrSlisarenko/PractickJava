<a class="btn btn-primary my-3" data-toggle="collapse" href="#collapseExample"
   role="button" aria-expanded="false" aria-controls="collapseExample">Message Editor
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
        <input type="hidden" name="id" value="<#if message??>${message.author.id}</#if>">
        <button type="submit" name="send" class="btn btn-primary">Добавить сообщение</button>
    </div>
    </form>
</div>

