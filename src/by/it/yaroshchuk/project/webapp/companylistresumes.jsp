<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<html>
	<%@ include file="include/head.htm" %>
	<body>
		<div class="container">
			<%@ include file="include/menu.htm" %>

        <c:forEach items="${resumes}" var="resume">
		 
			
			<form class="send-request-${resume.id}" action="do?command=ListResumes" method="post">
				<fieldset>
					<p> <c:out value="${resume.fullName}"/>
					<c:out value="${resume.dob}"/>
					<c:out value="${resume.country}"/>
					<c:out value="${resume.city}"/>
					<input name="resumeId" type="hidden" value="${resume.id}"/>

					<div>
						<c:if test="${user.rolesId==3}">
						<c:if test="${requests==null}">
						    <legend>Request Form</legend>

                            <!-- Text input-->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="message">Message</label>
                                <textarea class="form-control" id="message" name="message" rows="3"></textarea>
                            </div>

                            <!-- Button -->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="requestbtn"></label>
                                <div class="col-md-4">
                                    <button id="requestbtn" name="requestbtn" class="btn btn-success">Create request</button>
                                </div>
                            </div>
						</c:if>
					
							<c:forEach items="${requests}" var="request">
								<c:if test="${request.resumesId==resume.id}">
									<p class="text-success">Request is sended</p>
								</c:if>
								<c:if test="${request.resumesId!=resume.id}">
									<legend>Request Form</legend>

									<!-- Text input-->
									<div class="form-group">
										<label class="col-md-4 control-label" for="message">Message</label>
										<textarea class="form-control" id="message" name="message" rows="3"></textarea>
									</div>

									<!-- Button -->
									<div class="form-group">
										<label class="col-md-4 control-label" for="requestbtn"></label>
										<div class="col-md-4">
											<button id="requestbtn" name="requestbtn" class="btn btn-success">Create request</button>
										</div>
									</div>
								</c:if>
							</c:forEach>
						
						</c:if>
					</div>
				</fieldset>
			</form>
			
        </c:forEach>

		</div>
	</body>
</html>