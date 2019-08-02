<#import "parts/common.ftl" as baseContainer>
<@baseContainer.page>
<h1>Store</h1>
<div class="container m-3">
    <h3>Delivery interval</h3>
    <form method="post" action="/store/updatetimedelevery">
        <div class="form-row align-items-center">
            <div class="col-auto">
                <label class="sr-only" for="inlineFormInputGroup">Delivery interval</label>
                <div class="input-group mb-2">
                    <div class="input-group-prepend">
                        <div class="input-group-text">Delivery interval</div>
                    </div>
                    <input type="text" name="interval" class="form-control" value="${interval}" id="inlineFormInputGroup" >
                </div>
            </div>

            <div class="col-auto">
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <button type="submit" class="btn btn-primary mb-2">Update interval</button>
            </div>
        </div>

    </form>
</div>
<div class="container m-3">
    <h3>New Book Order</h3>
    <form action="/store/addbook" method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Book Title :</label>
            <div class="col-sm-6">
                <input type="text" name="title" value=""
                       class="form-control"
                       placeholder="Book title" />

            </div>
        </div>
<div class="form-group row">
    <label class="col-sm-2 col-form-label">Author Book :</label>
    <div class="col-sm-6">
        <input type="text" name="author" value=""
               class="form-control"
               placeholder="Author Book" />

    </div>
</div>
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <label class="input-group-text" for="inputGroupSelect02">Genres</label>
            </div>
            <select class="custom-select" id="inputGroupSelect02" name="genre">
                <option value="">Choice..</option>
                <#list genres as genre>
                <option value="${genre}">${genre}</option>
            </#list>

            </select>
        </div>
<div class="form-group row">
    <label class="col-sm-2 col-form-label">Quantity Book :</label>
    <div class="col-sm-6">
        <input type="text" name="quantity" value=""
               class="form-control"
               placeholder="Quantity Book" />

</div>
</div>
<div class="form-group row">
    <label class="col-sm-2 col-form-label">Price Book :</label>
    <div class="col-sm-6">
        <input type="text" name="price" value=""
               class="form-control"
               placeholder="Price Book" />

</div>
</div>
<input type="hidden" name="_csrf" value="${_csrf.token}" />
    <div class="form-group row">
        <div class="col-sm-10">
            <button type="submit" class="btn btn-primary">Add</button>
        </div>
    </div>
</form>
</div>
<div class="container m-3">
    <h3>List books</h3>
    <div class="card-columns">
        <#list books as book>
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">${book.title}</h5>
                <p class="card-text">${book.author}</p>
                <p class="card-text">${book.genre}</p>
                <p class="card-text">${book.count}</p>
                <form method="post" action="/store/editprice">
                    <div class="form-row align-items-center">
                        <div class="col-auto">
                            <label class="sr-only" for="inlineFormInputGroup">Price</label>
                            <div class="input-group mb-2">
                                <div class="input-group-prepend">
                                    <div class="input-group-text">Price</div>
                                </div>
                                <input type="text" name="price"  value="${book.price}" >
                            </div>
                        </div>

                        <div class="col-auto">
                            <input type="hidden" name="_csrf" value="${_csrf.token}" />
                            <input type="hidden" name="id" value="${book.id}" />
                            <button type="submit" class="btn btn-primary mb-2">Update Price</button>
                        </div>
                    </div>

                </form>

            </div>
        </div>
        <#else>
        <p>No books.....</p>
    </#list>
</div>
</div>

</@baseContainer.page>