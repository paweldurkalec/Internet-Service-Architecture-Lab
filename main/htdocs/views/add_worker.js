function show_add_worker_view(){
	const urlParams = new URLSearchParams(window.location.search);
	let company_name = urlParams.get('company');
	window.location.href = 'http://localhost:8000/views/add_worker.html?company=' + company_name;
}



function add_worker(){
		const urlParams = new URLSearchParams(window.location.search);
		let company_name = urlParams.get('company');
		let xhttp = new XMLHttpRequest();
		let worker = {name: document.getElementById('name').value, age: document.getElementById('age').value, company: company_name};
		xhttp.open("POST", "http://localhost:8001/api/workers", true);
		xhttp.setRequestHeader("Content-type", "application/json");
		console.log(JSON.stringify(worker));
		xhttp.send(JSON.stringify(worker));

}