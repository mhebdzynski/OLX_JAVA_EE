<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 01.06.2020
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Registration</title>

    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>
<%--<jsp:include page="header_footer/header.html"/>--%>
<div class="container">
    <hr>
    <div class="row col-md-10 col-md-offset-3">

        <div class="card card-body">

            <h2 style="color:tomato;">User Register Form</h2>
            <div class="col-md-8 col-md-offset-3">

                <form action="<%=request.getContextPath()%>/Register" method="post">

                    <div class="form-group">
                        <label for="nick">Nick:</label> <input type="text"
                                                               class="form-control" id="nick" placeholder="nick"
                                                               name="nick" required>
                    </div>

                    <div class="form-group">
                        <label for="password">Password:</label> <input type="password"
                                                                       class="form-control" id="password" placeholder="password"
                                                                       name="password" required>
                    </div>

                    <div class="form-group">
                        <label for="name">Name:</label> <input type="text"
                                                               class="form-control" id="name" placeholder="name"
                                                               name="name" required>
                    </div>

                    <div class="form-group">
                        <label for="surname">Surname:</label> <input type="text"
                                                                     class="form-control" id="surname" placeholder="surname"
                                                                     name="surname" required>
                    </div>

                    <div class="form-group">
                        <label for="age">Age:</label> <input type="number"
                                                             class="form-control" id="age" placeholder="age"
                                                             name="age" required>
                    </div>

                    <div class="form-group">
                        <label for="money">Money:</label> <input type="number"
                                                                 class="form-control" id="money" placeholder="money"
                                                                 name="money" required>
                    </div>

                    <button type="submit" class="btn btn-primary">Submit</button>

                </form>
            </div>
        </div>
    </div>
</div>
<%--<jsp:include page="header_footer/footer.jsp"/>--%>
</body>
</html>
