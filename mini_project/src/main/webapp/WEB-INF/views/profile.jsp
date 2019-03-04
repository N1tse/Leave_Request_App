<%-- 
    Document   : profile
    Created on : Mar 3, 2019, 5:15:34 PM
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
        <title>${u.username} Profile</title>
    </head>
    <body>
        <div class="text-center">
            <h1>${u.username} Profile</h1>
            <a href="logout"><small>LOGOUT</small></a><br>
            <a href="homeAdmin"><small>BACK</small></a><br>
            <h3>${wrong}</h3>
            <h3>${nothing}</h3>
        </div>
        <div class="row text-center">
            <div class="col-md-6">
            <div class="text-center">
                <div class="card" style="width: 18rem;">
                <img src="resources/images/user.png" class="card-img-top" alt="...">
                <div class="card-body">
                  <h5 class="card-title">${u.username}</h5>
                  <p class="card-text">User ID: <b>${u.user_id}</b></p>
                  <p class="card-text">Role: <b>${u.role}</b></p>
                  <p class="card-text">Count Of Leave Requests: <b>${u.count}</b></p>
                  <p><a href="requestsById${u.user_id}"><input type="submit" class="btn btn-primary" value="See Requests"></a></p>
                </div>
              </div>
            </div>
                </div>
                <div class="col-md-6">
                    <table class="table">
                        <thead>
                          <tr>
                            <th scope="col">Request_id</th>
                            <th scope="col">User_id</th>
                            <th scope="col">UserName</th>
                            <th scope="col">Description</th>
                            <th scope="col">Committed Date</th>
                          </tr>
                        </thead>
                     <tbody>
                         <c:forEach items="${list}" var="a"> 
                          <tr>
                            <th scope="row">${a.req_id}</th>
                            <td>${a.userid}</td>
                            <td>${a.username}</td>
                            <td>${a.descr}</td>
                            <td>${a.committed_date}</td>
                          </tr>
                          </c:forEach>
                        </tbody>
                    </table>
                </div>
        </div>
    </body>
</html>
