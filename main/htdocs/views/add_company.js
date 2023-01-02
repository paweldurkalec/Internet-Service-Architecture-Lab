function add_company(){
		let xhttp = new XMLHttpRequest();
		let company = {name: document.getElementById('name').value, value: document.getElementById('val').value, type: document.getElementById('type').value};
		xhttp.open("POST", "http://localhost:8001/api/companies", true);
		xhttp.setRequestHeader("Content-type", "application/json");
		console.log(JSON.stringify(company));
		xhttp.send(JSON.stringify(company));

}