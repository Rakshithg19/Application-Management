<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Testing</title>
<meta charset="utf-8">
<meta http-equiv='X-UA-Compatible' content='IE=edge'>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

<link href="css/appInfo.css" rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-dark bg-dark"> <span
		class="navbar-brand mb-0 h1"><h2>
			<b>X-workz</b>
		</h2> </span></nav>
	<div class="body-class">
		<div class="container mt-5 mb-5">
			<div class="mt-3 mb-4 row justify-content-center">
				<div class="row col-sm-12 justify-content-center">
					<h4>${msg}</h4>
				</div>.
				<div class="row col-md-12">
					<div class="col-md-3"></div>
					<div class="col-md-6">
						<div class="card card-2">
							<form class="col-md-12" action="saveAppInfo" method="post">
								<div class="row justify-content-center mt-4 mb-4">
									<h3>
										<u>App Info</u>
									</h3>
								</div>
								<div class="form-group">
									<label for="projectname">Project Name:</label> <input
										type="text" class="form-control" id="projectname"
										placeholder="Enter Project Name" name="projectName">
								</div>

								<div class="form-group">
									<label for="teammanager">Team Manager:</label> <input
										type="text" class="form-control" id="teammanager"
										placeholder="Enter Team Manager Name" name="teamManagerName">
								</div>

								<div class="form-group">
									<label for="teamcontactemail">Team Contact Email:</label> <input
										type="email" class="form-control" id="teamcontactemail"
										placeholder="Enter Team Contact email" name="teamContactEmail">
								</div>

								<div class="form-group">
									<label> De-Commissioned: </label> <label class="radio-inline">
										<input type="radio" name="isDeCommissioned" value="true">
										Yes
									</label> <label class="radio-inline"> <input type="radio"
										name="isDeCommissioned" value="false"> No
									</label>
								</div>

								<div>
									<button type="button" class="btn btn-primary mb-4"
										data-toggle="modal" data-target="#myModal">Add
										Environment</button>

									<div id="showEnvironment"></div>

									<div class="modal fade" id="myModal">
										<div class="modal-dialog modal-sm">
											<div class="modal-content">
												<div class="modal-header">
													<h5 class="modal-title">Environment Details:</h5>
													<button type="button" class="close" data-dismiss="modal">&times;</button>
												</div>
												<div class="modal-body">
													<div class="form-group">
														<label for="environment">----Select Environment---</label>
														<select class="form-control" id="environment"
															name="environmentType">
															<option>Development</option>
															<option>UAT</option>
															<option>SIT</option>
															<option>Production</option>
															<option>Others</option>
														</select>
													</div>

													<div class="form-group">
														<label for="url">URL:</label> <input type="text"
															class="form-control" id="url" placeholder="Enter url"
															name="url">
													</div>


													<div class="form-group">
														<label>Accessible: </label> <label class="radio-inline">
															<input type="radio" name="isAccessible" value="true" checked="checked">
															Yes
														</label> <label class="radio-inline"> <input type="radio"
															name="isAccessible" value="false"> No
														</label>
													</div>

													<div>
														<button type="button" class="btn btn-success btn-block"
															onclick="addEnvironment()">save</button>
													</div>


												</div>

												<div class="modal-footer">
													<button type="button" class="btn btn-danger"
														data-dismiss="modal" id="closeModal">close</button>
												</div>
											</div>
										</div>
									</div>
								</div>

								<div class="form-group">
									<label>Developed Date:</label> <input type="date"
										id="developeddate" class="form-control" name="developedDate">
								</div>

								<div class="form-group">
									<label for="version">Version:</label> <input type="text"
										class="form-control" id="version" placeholder="Enter version"
										name="version">
								</div>

								<div class="form-group">
									<label>Last Release:</label> <input type="date"
										id="lastrelease" class="form-control" name="lastRelease">
								</div>

								<div class="form-group">
									<label>Next Release:</label> <input type="date"
										id="nextrelease" class="form-control" name="nextRelease">
								</div>

								<div class="row justify-content-center mt-3 mb-3">
									<button type="submit" class="btn col-md-6 btn-success">Add</button>
								</div>
							</form>
						</div>
					</div>
				</div>
				<div class="col-md-3"></div>
			</div>
		</div>
	</div>
	<div>
		<footer id="sticky-footer" class="py-4 bg-dark text-white-50">
		<div class="container text-center">
			<small>@ 2020 Copyright &copy; xworkz.com</small>
		</div>
		</footer>
	</div>

	<script>
		var detailsOfEnv = [];
		function addEnvironment() {
			var env = document.getElementById("environment");
			var result = env.options[env.selectedIndex].text;
			var url = document.getElementById("url").value;
			console.log(result);
			console.log(url);
		
			var isAccessibleData=document.getElementsByName("isAccessible");
			console.log(isAccessibleData);
			console.log("isAccessibleData:>>> ",isAccessibleData[0].checked);
			var environmentDetails = {
				'environment' : result,
				'url' : url,
				'accessible' :isAccessibleData[0].checked
			};
			console.log(environmentDetails);
			detailsOfEnv.push(environmentDetails);
			displayTable();
		}
		function displayTable() {
			var environmentData = " "
			environmentData = "<table border='1' class='table table-striped'><tr> <th>Environment</th> <th>URL</th> <th>IsAccessible</th> </tr>";
			for (var i = 0; i < detailsOfEnv.length; i++) {
				environmentData = environmentData+ "<tr> <td><input type='hidden' name='environmentList["+i+"].environment' value='"+detailsOfEnv[i].environment+"' /> "+detailsOfEnv[i].environment+"</td>	<td><input  type='hidden' name='environmentList["+i+"].url' value='"+detailsOfEnv[i].url+"' />"+detailsOfEnv[i].url+"</td> <td><input  type='hidden' name='environmentList["+i+"].isAccessible' value='"+detailsOfEnv[i].accessible+"' /> "+detailsOfEnv[i].accessible+"</td> </tr>";
			}
			environmentData =environmentData+ "</table>";
			console.log(environmentData);
			document.getElementById("showEnvironment").innerHTML = environmentData
			document.getElementById("closeModal").click();
		}
	</script>

</body>
</html>