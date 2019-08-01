<#import "parts/common.ftl" as baseContainer>
<@baseContainer.page>
<div class="container">
<h1>Liked books!!!</h1>
<div class="m3">
<h3>Like Genre!</h3>
    <table class="table table-striped">
        <thead>
        <tr>
            <td scope="col">The name of the genre</td>
            <td scope="col">Number of books</td>
        </tr>
        </thead>
        <body>
        <#list listGenre?keys as key>
        <tr>
            <td scope="row">${key}</td>
            <td scope="row">${listGenre[key]}</td>
        </tr>
        </#list>
        </body>
    </table>
</div>
<div class="m3">
    <h3>Like Books!</h3>
<#include "parts/listBook.ftl">
</div>
</div>
</@baseContainer.page>