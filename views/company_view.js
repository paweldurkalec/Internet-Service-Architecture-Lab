import {clearElementChildren, createLinkCell, createButtonCell, createTextCell} from '../js/dom_utils.js';
import {getBackendUrl} from '../js/configuration.js';

window.addEventListener('load', () => {
    load_details_table();	
	fetch_and_display_workers();
});

function load_details_table(){
	const urlParams = new URLSearchParams(window.location.search);
	let company_name = urlParams.get('company');
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
	if (this.readyState == 4 && this.status == 200) {
			let company = JSON.parse(this.responseText);
			console.log(company);
			document.getElementById('company_name').innerHTML = company.name;
			document.getElementById('val').innerHTML = company.value;
			document.getElementById('type').innerHTML = company.type;
		}
	};
	xhttp.open("GET", getBackendUrl() + '/api/companies/' + company_name, true);
	xhttp.send();
}

function fetch_and_display_workers() {
    const xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            displayWorkers(JSON.parse(this.responseText))
        }
    };
    xhttp.open("GET", getBackendUrl() + '/api/workers', true);
    xhttp.send();
}

function displayWorkers(workers) {
	const urlParams = new URLSearchParams(window.location.search);
    let tableBody = document.getElementById('tableBody');
    clearElementChildren(tableBody);
    workers.workers.forEach(worker => {
		worker = getWorker(worker.name);
		if (worker.companyName == urlParams.get('company')){
			tableBody.appendChild(createTableRow(worker.name));
		}
    })
}

function createTableRow(worker) {
    let tr = document.createElement('tr');
    tr.appendChild(createTextCell(worker));
    tr.appendChild(createLinkCell('Details', 'worker_view.html?worker=' + worker));
	tr.appendChild(createLinkCell('Edit', 'update_worker.html?worker=' + worker));
    tr.appendChild(createButtonCell('Delete', () => deleteWorker(worker)));
    return tr;
}

function getWorker(name){
	let xhttp = new XMLHttpRequest();
	xhttp.open("GET", getBackendUrl() + '/api/workers/' + name, false);
	console.log(getBackendUrl() + '/api/workers/' + name);
	xhttp.send();
	if(xhttp.status == 200){
		return JSON.parse(xhttp.responseText);
	}
}

function deleteWorker(worker) {
    const xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 202) {
            fetchAndDisplayCompanies();
        }
    };
    xhttp.open("DELETE", getBackendUrl() + '/api/workers/' + worker, false);
    xhttp.send();
}

