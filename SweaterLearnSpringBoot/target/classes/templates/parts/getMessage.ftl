<div class="card-columns">
    <#list messages as msg>
    <div class="card">
        <#if msg.file??>
        <img class="card-img-top" src="/img/${msg.file}">
        </#if>
        <div class="card-body">
            <h5 class="card-title">#${msg.tag}</h5>
            <p class="card-text">${msg.text}</p>
            <a href="/user-messages/${msg.author.id}"><span style="font-weight:bold; text-align:right;">${msg.authorName}</span></a>
            <#if msg.author.id == currentUserId>
                <a class="btn btn-primary" href="/user-messages/${msg.author.id}?messageId=${msg.id}">Edit</a>
            </#if>
        </div>
    </div>
<#else>
<p>No messages</p>
</#list>
</div>