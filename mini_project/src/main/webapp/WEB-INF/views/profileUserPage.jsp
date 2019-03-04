<%-- 
    Document   : profileUserPage
    Created on : Mar 2, 2019, 3:54:45 PM
    Author     : ntsep
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="resources/css/profile.css"/>
        <script src="resources/js/profile.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
        <title>User Profile Page</title>
    </head>
        <div class="text-center">
            <h1>Welcome ${u.username}</h1>
            <a href="logout"><small>LOGOUT</small></a>
        </div>

        <div class="row">
            <div class="col-md-6">
              <div class="card">
                <div class="card-body">
                  <h5 class="card-title">UserName: ${u.username}</h5>
                  <p class="card-text">PassWord: ${u.password}</p>
                  <p class="card-text">User_Id: ${u.user_id}</p>
                  <p class="card-text">Number of Leave Requests: ${count}</p>
                  <h5 class="card-title">Last Request</h5>
                  <p class="card-text">Date Committed: ${r.committed_date}</p>
                  <p class="card-text">Check out: ${r.check_out}</p>
                  <p class="card-text">Check in: ${r.check_in}</p>
                  <p class="card-text">Description: ${r.descr}</p>
                  <p class="card-text">${done}</p>
                  <p class="card-text">${error}</p>
                </div>
              </div>
            </div>

                      <div class="col-md-6 text-center">
                          <h3>Leave Request</h3>
                          <form method="POST" action="requestForm${u.user_id}" modelAttribute="request"> 
                                <div id="dropDown1" style="background: white;">
                                    <div style="font-size: 30px; padding-top: 7px; color: gray;"><i class="far fa-calendar-alt"></i></div>
                                    <div style="padding-top: 17px;text-align:left; font-size:20px; font-weight: bold;color: gray;">
                                        <label for="datetime">Check Out: </label>
                                    </div>
                                    <div><a style="display: flex;flex-direction: column;text-align: left;"><i class="fas fa-angle-down" style="width: 65%;"></i><input name="check_out" type="text" id="checkin"></a></div>
                                </div>
 
                             <div id="dropDown2" style="background:white;"> 
                                <div style="font-size: 30px; padding-top: 7px; color: gray;"><i class="far fa-calendar-minus"></i></div>
                                <div style="padding-top: 17px;text-align:left; font-size:20px; font-weight: bold;color: gray;">
                                 <label for="datetime1">Check In: </label>
                                 </div>
                                 <div><a style="display: flex;flex-direction: column;text-align: left;"><i class="fas fa-angle-down" style="width: 65%;"></i><input name="check_in" type="text" id="checkout"></a></div></div>
                            
                                    <label for="comment">Description:</label>
                                    <textarea class="form-control" name="descr" rows="5" id="comment" cols="30" placeholder="Max 250 characters!"></textarea>
                                                                 
                                 <input type="submit" class="btn btn-primary" value="Submit"><br>
                          </form>
                      </div>
                </div>
         
    </body>
</html>
