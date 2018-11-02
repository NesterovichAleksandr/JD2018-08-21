<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<html>
    <%@ include file="include/head.htm" %>
    <body>
        <div class="container">
            <%@ include file="include/menu.htm" %>
			<c:forEach items="${resumes}" var="resume">
				 <form class="update-resume-${resume.id}" action="do?command=UserListResumes" method=POST>
				 <fieldset>

					 <!-- Form Name -->
					 <legend>Resume</legend>

					 <!-- Text input-->
					 <div class="form-group">
					   <label class="col-md-4 control-label" for="fullName">Full name</label>
					   <div class="col-md-6">
					   <input id="fullName" name="fullName" type="text" placeholder="" class="form-control input-md" required="" value="${resume.fullName}">

					   </div>
					 </div>

					 <!-- Text input-->
					 <div class="form-group">
					   <label class="col-md-4 control-label" for="dob">Date of birth</label>
					   <div class="col-md-4">
					   <input id="dob" name="dob" type="text" placeholder="YYYY-MM-DD" class="form-control input-md" required="" value="${resume.dob}">
					   <span class="help-block">date format YYYY-MM-DD</span>
					   </div>
					 </div>

					 <!-- Text input-->
					 <div class="form-group">
					   <label class="col-md-4 control-label" for="country">Country</label>
					   <div class="col-md-4">
					   <input id="country" name="country" type="text" placeholder="" class="form-control input-md" required="" value="${resume.country}">

					   </div>
					 </div>

					 <!-- Text input-->
					 <div class="form-group">
					   <label class="col-md-4 control-label" for="city">City</label>
					   <div class="col-md-4">
					   <input id="city" name="city" type="text" placeholder="" class="form-control input-md" required="" value="${resume.city}">

					   </div>
					 </div>

					 <!-- Text input-->
					 <div class="form-group">
					   <label class="col-md-4 control-label" for="education">Education</label>
					   <div class="col-md-4">
					   <input id="education" name="education" type="text" placeholder="" class="form-control input-md" required="" value="${resume.education}">

					   </div>
					 </div>

					 <!-- Text input-->
					 <div class="form-group">
					   <label class="col-md-4 control-label" for="degree">Degree</label>
					   <div class="col-md-4">
					   <input id="degree" name="degree" type="text" placeholder="" class="form-control input-md" required="" value="${resume.degree}">

					   </div>
					 </div>

					 <!-- Text input-->
					 <div class="form-group">
					   <label class="col-md-4 control-label" for="graduateYear">Graduate year</label>
					   <div class="col-md-4">
					   <input id="graduateYear" name="graduateYear" type="text" placeholder="YYYY" class="form-control input-md" required="" value="${resume.graduateYear}">
					   <span class="help-block">date format YYYY</span>
					   </div>
					 </div>

					 <!-- Text input-->
					 <div class="form-group">
					   <label class="col-md-4 control-label" for="experience">Experience</label>
					   <div class="col-md-4">
					   <input id="experience" name="experience" type="text" placeholder="" class="form-control input-md" required="" value="${resume.experience}">

					   </div>
					 </div>

					 <!-- Text input-->
					 <div class="form-group">
					   <label class="col-md-4 control-label" for="post">Post</label>
					   <div class="col-md-4">
					   <input id="post" name="post" type="text" placeholder="" class="form-control input-md" required="" value="${resume.post}">

					   </div>
					 </div>

					 <!-- Text input-->
					 <div class="form-group">
					   <label class="col-md-4 control-label" for="worktime">Work time</label>
					   <div class="col-md-4">
					   <input id="worktime" name="worktime" type="text" placeholder="years" class="form-control input-md" required="" value="${resume.worktime}">
					   <span class="help-block">years</span>
					   </div>
					 </div>

					 <!-- Text input-->
					 <div class="form-group">
					   <label class="col-md-4 control-label" for="resumeId"></label>
					   <div class="col-md-4">
					   <input id="resumeId" name="resumeId" type="hidden" placeholder="" class="form-control input-md" value="${resume.id}">

					   </div>
					 </div>

					 <!-- Text input-->
					 <div class="form-group">
					   <label class="col-md-4 control-label" for="resumeUsersId"></label>
					   <div class="col-md-4">
					   <input id="resumeUsersId" name="resumeUsersId" type="hidden" placeholder="" class="form-control input-md" value="${resume.usersId}">

					   </div>
					 </div>
					 <button id="Update" value="Update" name="Update" class="btn btn-success col-md-1">
                        Update
                    </button>

                    <button id="Delete" value="Delete" name="Delete" class="btn btn-danger col-md-1">
                        Delete
                    </button>

				 </fieldset>
				 </form>
			 </c:forEach>
        </div>
    </body>
</html>
