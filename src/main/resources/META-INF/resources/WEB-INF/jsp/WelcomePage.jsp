<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Welcome page</title>
        <link href="webjars/bootstrap/5.2.3/css/bootstrap.min.css" rel="stylesheet" >
    </head>
    <body>
    <nav class="navbar navbar-expand-md navbar-dark bg-dark mb-3 p-1">
        <a class="navbar-brand m-1">ToBeDone</a>
        <div class="collapse navbar-collapse">
            <ul class="navbar-nav">
                <li class="nav-item"><a class="nav-link" href="/">Home</a></li>
                <li class="nav-item"><a class="nav-link" href="ListToDos">ToDos</a></li>
            </ul>
        </div>
        <ul class="navbar-nav">
            <li class="nav-item"><a class="nav-link" href="Logout">Logout</a></li>
        </ul>
    </nav>
        <div class="container-fluid">
            <h1>Welcome ${name} </h1>
            <p><a href="ListToDos">Manage Your To Dos</a></p>
        </div>
        <script src="webjars/bootstrap/5.2.3/js/bootstrap.min.js"></script>
        <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
    </body>
</html>