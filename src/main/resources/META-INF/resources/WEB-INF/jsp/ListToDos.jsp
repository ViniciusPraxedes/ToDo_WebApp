<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>List to dos</title>
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
            <li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>
        </ul>
    </nav>
    <div class="container-fluid">
        <h1>Your to do list</h1>
        <table class="table table-bordered">
            <thead class="thead-dark">
            <tr>
                <th>Description</th>
                <th>Target Date</th>
                <th>Is Done?</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${todos}" var="todo">
                <tr>
                    <td>${todo.description}</td>
                    <td>${todo.targetDate}</td>
                    <td>${todo.done}</td>
                    <td><a href="DeleteToDo?id=${todo.id}" class="btn btn-warning">DELETE</a> </td>
                    <td><a href="UpdateToDo?id=${todo.id}" class="btn btn-success">UPDATE</a> </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <a href="AddToDo" class="btn btn-success">Add To do</a>
    </div>
    </body>
    <script src="webjars/bootstrap/5.2.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</html>