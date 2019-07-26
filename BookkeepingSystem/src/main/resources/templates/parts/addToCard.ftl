<form action="/addBookToCard"  method="post" class="form-inline">
    <div class="form-group mb-2">
        <input type="text" readonly class="form-control-plaintext" id="staticEmail2" value="Количество:">
    </div>
    <div class="form-group mx-sm-3 mb-2">
        <input name="quantity" type="text" class="form-control" id="inputPassword2" value="1">
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <input type="hidden" name="bookId" value="${book.id}" />
    <button type="submit" class="btn btn-primary mb-2">AddToCard</button>
</form>