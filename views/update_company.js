function getBackendUrl() {
    return "http://localhost:8080"
}

function update_company(){
		const urlParams = new URLSearchParams(window.location.search);
		let company_name = urlParams.get('company');
		let xhttp = new XMLHttpRequest();
		let company = {value: document.getElementById('val').value, type: document.getElementById('type').value};
		xhttp.open("PUT", "http://localhost:8080/api/companies/"+company_name, true);
		xhttp.setRequestHeader("Content-type", "application/json");
		console.log(JSON.stringify(company));
		xhttp.send(JSON.stringify(company));
		window.location.href = 'http://localhost:100/views/update_company.html?company=' + company_name;
}