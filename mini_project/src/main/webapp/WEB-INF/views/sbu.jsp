<%-- 
    Document   : sbu
    Created on : Mar 3, 2019, 3:48:01 PM
    Author     : ntsep
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">        <link rel="stylesheet" href="resources/css/profile.css"/>
        <script src="resources/js/profile.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
        <title>Search By UserName</title>
    </head>
    <body>
                 <div class="text-center">
        <h1>Search By UserName</h1>
        <a href="logout"><small>LOGOUT</small></a><br>
        <a href="homeAdmin"><small>BACK</small></a><br>
        <div class="text-center">
                   <div class="">
                    <form method="POST" action="searchUser" modelAttribute="user">
                        <input class="form-control" type="text" name="username" placeholder="Search" aria-label="Search By Username">
                        <input type="submit" class="btn btn-primary" value="Search">
                    </form>
                 </div> 
        </div>
         <h3>${no}</h3>
             <div id="tables">
<!--            TABLES-->
        <table class="table">
            <thead>
              <tr>
                <th scope="col">User_id</th>
                <th scope="col">UserName</th>
                <th scope="col">PassWord</th>
                <th scope="col">Role</th>
              </tr>
            </thead>
            <tbody>
             <c:forEach items="${users}" var="i"> 
              <tr>
                <th scope="row">${i.user_id}</th>
                <td>${i.username}</td>
                <td>${i.password}</td>
                <td>${i.role}</td>
              </tr>
              </c:forEach>
            </tbody>
          </table>
            </div>
        </div>
    </body>
</html>
