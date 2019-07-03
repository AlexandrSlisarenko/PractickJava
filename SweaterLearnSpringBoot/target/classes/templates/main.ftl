<#import "parts/common.ftl" as baseContainer>
<#import "parts/login.ftl" as formL>

<@baseContainer.page>
<h1>Сообщения и теги!!!!</h1>
<p><a href="/user">Users List</a></p>
<div>
<@formL.logout />
</div>
<p>Форма добавления сообщений</p>
<form method="post">
    <input type="text" name="text" placeholder="Введите текст"/>
    <input type="text" name="tag" placeholder="Введите тег"/>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <button type="submit" name="send">Добавить сообщение</button>
</form>
<p>Список сообщений</p>
<form method="post" action="filter">
    <input type="text" name="filter">
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <button type="submit">Фильтровать</button>
</form>
<#list messages as message>
<div>
    <span style="font-weight:bold;">${message.id}</span>
    <span>${message.text}</span>
    <i>${message.tag}</i>
    <span style="font-weight:bold;">${message.authorName}</span>
</div>
<#else>
<p>No messages</p>
</#list>
</@baseContainer.page>