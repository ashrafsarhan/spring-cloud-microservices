var stompClient = null;

function connect() {
	var socket = new SockJS('/websocket');
	stompClient = Stomp.over(socket);
	stompClient.connect({}, function(frame) {
		console.log('Connected: ' + frame);
		stompClient.subscribe('/topic/messages', function(message) {
			updateTable(JSON.parse(message.body));
		});
	});
}

function disconnect() {
	if (stompClient != null) {
		stompClient.disconnect();
	}
	console.log("Disconnected");
}

$(window).load(function() {
	connect();
});

$(window).unload(function() {
	disconnect();
});

function updateTable(json) {
	$("#hotTopics > tbody").html("");
	for(var i = 0; i < json.length; i++) {
	    var obj = json[i];
	    $("#hits").append("<tr><td>" + obj.value + "</td><td>" + obj.valueCount + "</td></tr>");
	}
}