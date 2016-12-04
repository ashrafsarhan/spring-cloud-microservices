$(document).ready(function () {
	
  $('#submit').click(function () {
	  
	  var searchTerm = $('#search').val();
	  
	  $.ajax({
	      url: '/search?userId=12345&searchTerm='+searchTerm,
	      async: true,
	      dataType: 'json',
	      success: function(response) {
	          console.log(response);
			  showResult(JSON.parse(response));
	      }
	});
  });
  
  function showResult(data) {
	    $("#results").append("<tr><td>" + message + "</td></tr>");
	}
  
});
