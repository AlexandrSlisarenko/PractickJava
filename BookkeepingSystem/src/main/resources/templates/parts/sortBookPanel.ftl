<div class="container">
    <form action="${path}" method="post">
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <label class="input-group-text" for="input1">Part of the name</label>
            </div>
            <input type="text" class="form-control"  id="input1" aria-describedby="basic-addon1"/>
        </div>
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <label class="input-group-text" for="inputGroupSelect01">Authors</label>
            </div>
            <select class="custom-select" id="inputGroupSelect01">
                <#list authors as author>
                    <option value="${author.name}">${author.name}</option>
                </#list>
            </select>
        </div>
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <label class="input-group-text" for="inputGroupSelect02">Genres</label>
            </div>
            <select class="custom-select" id="inputGroupSelect02">
                <#list genres as genre>
                    <option value="${genre}">${genre}</option>
                </#list>

            </select>
        </div>
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <label class="input-group-text">Price Min and Max</label>
            </div>
            <input type="text" aria-label="First name" class="form-control">
            <input type="text" aria-label="Last name" class="form-control">
        </div>
        <div class="form-group row">
            <div class="col-sm-10">
                <button type="submit" class="btn btn-primary">Filtr</button>
            </div>
        </div>
    </form>
</div>