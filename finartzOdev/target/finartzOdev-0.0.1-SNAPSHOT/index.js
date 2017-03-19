$(document).ready(function() {
	showUsers();
	
	$("#showUsersButton").click(function() {
		showUsers();
	});
});

$(document).on("click", "#save-button", function () {
	save();
});

$(document).on("click", "#update-button", function () {
	update();
});

$(document).on("click", "#addUserButton", function () {
	showAddUserModal();
});

function showLoading() {
	$(".loader").show();
}

function hideLoading() {
	$(".loader").hide();
}

function showUsers() {

	showLoading();
	
	$("#userTable").remove();

	$.ajax({
		url : "/userList",
		context : document.body
	}).done(
			function(response) {

				hideLoading();
				
				var table = "";

				// we say class='table' to bootstrap !
				table += "<table id='userTable' class='table'>";
				table += "<thead>";
				table += "<tr>";

				table += "<th>" + "Name" + "</th>";
				table += "<th>" + "Phone" + "</th>";
				table += "</tr>";
				table += "</thead>";

				console.log(response);

				// I get the exception here !.
				response.forEach(function(user) {
					table += "<tr id='" + user.id + "'>";
					table += "<td style='display:none;'>" + user.id + "</td>";
					table += "<td>" + user.name + "</td>";
					table += "<td>" + user.phone + "</td>";
					table += "<td><button onclick='showUpdateModal(\""
							+ user.id + "\")'  class='guncelleButton'>Güncelle"		
							+ "</button><button onclick='deleteUser(\""
							+ user.id
							+ "\")' class='silButton'>Sil</button> </td>";
				});

				table += "<table>";

				$(".userListDiv").html(table);

			});
}

function showUpdateModal(id) {

	var e = $("#" + id + " td").get();

	var id = e[0].innerHTML;
	var name = e[1].innerHTML;
	var phone = e[2].innerHTML;

	$('#userModal').modal('show');

	
	$('#updateid').val(id);
	$('#updatename').val(name);
	$('#updatephone').val(phone);
	
	$(".error-message").addClass("hidden");

}

function update() {
	var user = {
		id : $('#updateid').val(),
		name : $('#updatename').val(),
		phone : $('#updatephone').val()
	};

	var json = JSON.stringify(user);
	
	
	if (user.name == "" || user.phone == "" ){
		
	$('.error-message').removeClass("hidden");
		
	return;
		
	}else{
		
		showLoading();
		
		$.ajax({
			url : "/addNewUser",
			method : 'POST',
			data : json,
			contentType : 'application/json'
		}).done(function(response) {
			hideLoading();
			$("#userModal").modal("hide");
			showUsers();
		});
		
	}
	


}

function deleteUser(id) {
	
	var confirmationResult = confirm("Bu islemi gerceklestirmek istediginizden emin misiniz?");
	
	if (confirmationResult) {
		var tds = $("#" + id + " td").get();

		var user = {
			id : tds[0].innerHTML,
			name : tds[1].innerHTML,
			phone : tds[2].innerHTML
		};

		var json = JSON.stringify(user);
		
		//kullanıcıya uyarı vermemiz lazım gerçekten silmek istiyor mu kullanıcıyı falan diye.

		showLoading();
		
		$.ajax({
			url : "/deleteUser",
			method : 'DELETE',
			data : json,
			contentType : 'application/json'
		}).done(function(response) {
			hideLoading();
			showUsers();
		});
	}
	
}

function showAddUserModal(){

	$('#addNewUserModal').modal('show');

	$("#saveUserButton").css("display","inline-block");
	$("#updateUserButton").css("display","none");

	$('#saveid').val("");
	$('#savename').val("");
	$('#savephone').val("");
	
	$(".error-message").addClass("hidden");

}

function save(){
	
	var user = {
			name : $('#savename').val(),
			phone : $('#savephone').val()
	};
	
	var json = JSON.stringify(user);
	
	if (user.name == "" || user.phone == "" ){
		
		$('.error-message').removeClass("hidden");
		
		return;
		
	}
	
	else {
		
		showLoading();
		
		$.ajax({
			  url: "/addNewUser",
			  context: document.body,
			  type: 'POST',
			  data: json,
			  contentType: "application/json"
			}).done(function(response) {
				
				hideLoading();
				showUsers();	
				$("#addNewUserModal").modal("hide");
				
			});
	}
}