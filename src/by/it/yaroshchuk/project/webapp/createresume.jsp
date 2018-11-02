<html>
<%@ include file="include/head.htm" %>
	<body>
	<%@ include file="include/menu.htm" %>
		<div class="container">
			<form class="form-horizontal" action="do?command=CreateResume" method="post">
				<fieldset>
					<p>${user}<br></p>

					<!-- Form Name -->
					<legend>Form Create Resume</legend>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="fullname">Full name</label>
						<div class="col-md-4">
							<input id="fullname" name="fullname" value="user1" type="text" placeholder="" class="form-control input-md" required="">
						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="dob">Date of birth</label>
						<div class="col-md-4">
							<input id="dob" name="dob" value="user1" type="text" placeholder="" class="form-control input-md" required="">
						</div>
					</div>
					
					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="country">Country</label>
						<div class="col-md-4">
							<input id="country" name="country" value="user1" type="text" placeholder="" class="form-control input-md" required="">
						</div>
					</div>
					
					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="city">City</label>
						<div class="col-md-4">
							<input id="city" name="city" value="user1" type="text" placeholder="" class="form-control input-md" required="">
						</div>
					</div>
					
					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="education">Education</label>
						<div class="col-md-4">
							<input id="education" name="education" value="user1" type="text" placeholder="" class="form-control input-md" required="">
						</div>
					</div>
					
					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="degree">Degree</label>
						<div class="col-md-4">
							<input id="degree" name="degree" value="user1" type="text" placeholder="" class="form-control input-md" required="">
						</div>
					</div>
					
					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="graduateYear">Graduate year</label>
						<div class="col-md-4">
							<input id="graduateYear" name="graduateYear" value="user1" type="text" placeholder="" class="form-control input-md" required="">
						</div>
					</div>
					
					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="experience">Experience</label>
						<div class="col-md-4">
							<input id="experience" name="experience" value="user1" type="text" placeholder="" class="form-control input-md" required="">
						</div>
					</div>
					
					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="post">Post</label>
						<div class="col-md-4">
							<input id="post" name="post" value="user1" type="text" placeholder="" class="form-control input-md" required="">
						</div>
					</div>
					
					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="worktime">Work time</label>
						<div class="col-md-4">
							<input id="worktime" name="worktime" value="user1" type="text" placeholder="" class="form-control input-md" required="">
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

