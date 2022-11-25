import {clearElementChildren, createLinkCell, createButtonCell, createTextCell} from '../js/dom_utils.js';
import {getBackendUrl} from '../js/configuration.js';

window.addEventListener('load', () => {
    const urlParams = new URLSearchParams(window.location.search);
	let company_name = urlParams.get('company');
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
	if (this.readyState == 4 && this.status == 200) {
			let company = JSON.parse(this.responseText);
			console.log(company);
			document.getElementById('company_name').innerHTML = company.name;
			document.getElementById('val').value = company.value;
			document.getElementById('type').value = company.type;
		}
	};
	xhttp.open("GET", getBackendUrl() + '/api/companies/' + company_name, true);
	xhttp.send();
	
});

