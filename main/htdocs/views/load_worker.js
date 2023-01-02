import {clearElementChildren, createLinkCell, createButtonCell, createTextCell} from '../js/dom_utils.js';
import {getBackendUrl} from '../js/configuration.js';

window.addEventListener('load', () => {
    const urlParams = new URLSearchParams(window.location.search);
	let worker_name = urlParams.get('worker');
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
	if (this.readyState == 4 && this.status == 200) {
			let worker = JSON.parse(this.responseText);
			console.log(company);
			document.getElementById('name').innerHTML = worker.name;
			document.getElementById('age').value = worker.age;
			document.getElementById('company').value = worker.companyName;
		}
	};
	xhttp.open("GET", getBackendUrl() + '/api/workers/' + worker_name, true);
	xhttp.send();
	
});

