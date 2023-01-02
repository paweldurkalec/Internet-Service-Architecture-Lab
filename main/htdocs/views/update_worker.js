function getBackendUrl() {
    return "http://localhost:8001"
}

function update_worker(){
		const urlParams = new URLSearchParams(window.location.search);
		let worker_name = urlParams.get('worker');
		let xhttp = new XMLHttpRequest();
		let worker = {age: document.getElementById('age').value, company: document.getElementById('company').value};
		xhttp.open("PUT", "http://localhost:8001/api/workers/"+ worker_name, true);
		xhttp.setRequestHeader("Content-type", "application/json");
		console.log(JSON.stringify(worker));
		xhttp.send(JSON.stringify(worker));
		window.location.href = 'http://localhost:8000/views/update_worker.html?worker=' + worker_name;
}