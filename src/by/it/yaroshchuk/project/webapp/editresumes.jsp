<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<html>
    <%@ include file="include/head.htm" %>
    <body>
        <div class="container">
            <%@ include file="include/menu.htm" %>
             <div class="container">
                <c:forEach items="${resumes}" var="resume">
                <form class="update-resume-${resume.id}" action="do?command=EditResumes" method=POST>

                        <div class="d-print-block" style="text-align: left; margin-right: 10%; margin-right: 10%">
                            <h4>${resume.resumeName}</h4>
                            <h6>id: ${resume.id}</h6>
                            <h6>${resume.fullName}</h6>
                            <h6>Date of birth: ${resume.dob}</h6>
                            <h6>Country: ${resume.country}</h6>
                            <h6>City: ${resume.city}</h6>
                            <h6>    Education: ${resume.education}</h6>
                            <h6> Degree: ${resume.degree}</h6>
                            <h6>Graduate year: ${resume.graduateYear}</h6>
                            <h6>   Experience: ${resume.experience}</h6>
                            <h6>Post: ${resume.post}</h6>
                            <h6>    Work time: ${resume.worktime}</h6>
                            <h6>        About: ${resume.about}</h6>
                        <button id="Delete" value="Delete" name="Delete" class="btn btn-danger ">
                            Delete
                        </button>
                        </div>

                    </form>
                </c:forEach>
            </div>
        </div>
    </body>
</html>
