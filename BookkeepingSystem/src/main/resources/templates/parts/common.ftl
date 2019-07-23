<#macro page>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Bookkeeping System</title>
    <link rel="stylesheet" href="/static/style.css">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/static/bootstrap/4.1.3/css/bootstrap.min.css">
</head>
<body>
<#include "navbar.ftl" />
<div class="container mt-5">
    <#nested>
</div>
<script src="/static/jquery/jquery-3.3.1.slim.min.js"></script>
<script src="/static/jquery/popper.min.js"></script>
<script src="/static/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<script src="/static/custom.js"></script>

</body>
</html>
</#macro>