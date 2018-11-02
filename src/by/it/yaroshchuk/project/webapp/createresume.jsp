<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
	<body>
	<%@ include file="include/menu.htm" %>
		<div class="container">
			<form class="form-horizontal" action="do?command=CreateResume" method="post">
				<fieldset>

					<!-- Form Name -->
					<legend>Form Create Resume</legend>

					 <!-- Text input-->
             <div class="form-group">
               <label class="col-md-4 control-label" for="textinput">Full name</label>
               <div class="col-md-6">
               <input id="fullname" name="fullname" type="text" placeholder="" class="form-control input-md" required="" >

               </div>
             </div>

             <!-- Text input-->
             <div class="form-group">
               <label class="col-md-4 control-label" for="dob">Date of birth</label>
               <div class="col-md-4">
               <input id="dob" name="dob" type="text" placeholder="YYYY-MM-DD" class="form-control input-md" required="">
               <span class="help-block">date format YYYY-MM-DD</span>
               </div>
             </div>

             <!-- Text input-->
             <div class="form-group">
               <label class="col-md-4 control-label" for="country">Country</label>
               <div class="col-md-4">
               <input id="country" name="country" type="text" placeholder="" class="form-control input-md" required="">

               </div>
             </div>

             <!-- Text input-->
             <div class="form-group">
               <label class="col-md-4 control-label" for="city">City</label>
               <div class="col-md-4">
               <input id="city" name="city" type="text" placeholder="" class="form-control input-md" required="" >

               </div>
             </div>

             <!-- Text input-->
             <div class="form-group">
               <label class="col-md-4 control-label" for="education">Education</label>
               <div class="col-md-4">
               <input id="education" name="education" type="text" placeholder="" class="form-control input-md" required="" >

               </div>
             </div>

             <!-- Text input-->
             <div class="form-group">
               <label class="col-md-4 control-label" for="degree">Degree</label>
               <div class="col-md-4">
               <input id="degree" name="degree" type="text" placeholder="" class="form-control input-md" required="" >

               </div>
             </div>

             <!-- Text input-->
             <div class="form-group">
               <label class="col-md-4 control-label" for="graduateYear">Graduate year</label>
               <div class="col-md-4">
               <input id="graduateYear" name="graduateYear" type="text" placeholder="YYYY" class="form-control input-md" required="">
               <span class="help-block">date format YYYY</span>
               </div>
             </div>

             <!-- Text input-->
             <div class="form-group">
               <label class="col-md-4 control-label" for="experience">Experience</label>
               <div class="col-md-4">
               <input id="experience" name="experience" type="text" placeholder="" class="form-control input-md" required="" >

               </div>
             </div>

             <!-- Text input-->
             <div class="form-group">
               <label class="col-md-4 control-label" for="post">Post</label>
               <div class="col-md-4">
               <input id="post" name="post" type="text" placeholder="" class="form-control input-md" required="" >

               </div>
             </div>

             <!-- Text input-->
             <div class="form-group">
               <label class="col-md-4 control-label" for="worktime">Work time</label>
               <div class="col-md-4">
               <input id="worktime" name="worktime" type="text" placeholder="years" class="form-control input-md" required="">
               <span class="help-block">years</span>
               </div>
             </div>


					<!-- Button -->
					<div class="form-group">
						<label class="col-md-4 control-label" for="signupsubmit"></label>
						<div class="col-md-4">
							<button id="signupsubmit" name="signupsubmit" class="btn btn-success">Create</button>
						</div>
					</div>
				</fieldset>
			</form>
		</div>
	</body>
</html>

