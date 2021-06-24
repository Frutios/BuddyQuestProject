<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Buddy Quest</title>

    <meta charset="utf-8">
    <!--[if IE]>
    <meta http-equiv='X-UA-Compatible' content='IE=edge,chrome=1'><![endif]-->
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"/>
    <meta name="description" content="">

   
</head>

<body>

<!-- Navigation -->
<jsp:include page="../header.jsp"/>

<main class="main oh">

    <section id="contact">
        <div class="container">

            <div >
                <h2 class="heading">Login Page</h2>
            </div>

            <div class="row">
                <div class="col-md-8 col-md-offset-2">
                    <form id="form" method="post" action="${pageContext.request.contextPath}/auth/login" class="text-center">

                        <div class="row">
                            <div class="col-md-6 col-lg-offset-3">
                                <input name="username" id="username" type="text" placeholder="Username" value="admin">
                            </div>

                            <div class="col-md-6 col-lg-offset-3">
                                <input name="password" id="password" type="password" placeholder="Password" value="admin">
                            </div>

                        </div>
                        <input type="submit" class="btn btn-lg btn-color btn-button" value="Login">
                    </form>
                </div>
                <div class="col-md-8 col-md-offset-2 mt-20">
                    <c:if test="${!empty messages}">
                        <c:forEach items="${messages}" var="m">
                            <div id="msg" class="form-message error text-center white-text">
                                <p><strong>${m.key}</strong> : ${m.value}</p>
                            </div>
                        </c:forEach>
                    </c:if>
                </div>
            </div>
        </div>
        </div>
    </section>

    <section class="section-wrap bg-light pb-90">
        <div class="container">

            <div class="heading-row text-center">
                <h2 class="heading">FEATURES</h2>
            </div>

            <div class="row">
                <div class="col-md-4 wow bounceInUp" data-wow-duration="1s" data-wow-delay="0.3s">
                    <div class="feature-1 feature-1--sm-padding box-shadow">
                        <i class="feature__icon icon icon-mobile"></i>
                        <h3 class="feature__title">Responsive</h3>
                    </div>
                </div>

                <div class="col-md-4 wow bounceInUp" data-wow-duration="1s" data-wow-delay="0.3s">
                    <div class="feature-1 feature-1--sm-padding box-shadow">
                        <i class="feature__icon icon icon-layers"></i>
                        <h3 class="feature__title">Multi-platform</h3>
                        </p>
                    </div>
                </div>

                <div class="col-md-4 wow bounceInUp" data-wow-duration="1s" data-wow-delay="0.3s">
                    <div class="feature-1 feature-1--sm-padding box-shadow">
                        <i class="feature__icon icon icon-speedometer"></i>
                        <h3 class="feature__title">Efficient</h3>
                    </div>
                </div>

            </div>
        </div>
    </section>

    <!-- Footer -->
    <jsp:include page="../footer.jsp"/>
</main>

</body>
</html>










