import {clearElementChildren, createLinkCell, createButtonCell, createTextCell} from '../js/dom_utils.js';
import {getBackendUrl} from '../js/configuration.js';

window.addEventListener('load', () => {
    fetchAndDisplayCompanies();
});

function fetchAndDisplayCompanies() {
    const xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            displayCompanies(JSON.parse(this.responseText))
        }
    };
    xhttp.open("GET", getBackendUrl() + '/api/companies', true);
    xhttp.send();
}

function displayCompanies(Companies) {
    let tableBody = document.getElementById('tableBody');
    clearElementChildren(tableBody);
    Companies.companies.forEach(company => {
        tableBody.appendChild(createTableRow(company.name));
    })
}

function createTableRow(company) {
    let tr = document.createElement('tr');
    tr.appendChild(createTextCell(company));
    tr.appendChild(createLinkCell('Details', 'company_view.html?company=' + company));
	tr.appendChild(createLinkCell('Edit', 'update_company.html?company=' + company));
    tr.appendChild(createButtonCell('Delete', () => deleteCompany(company)));
    return tr;
}

function deleteCompany(Company) {
    const xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 202) {
            fetchAndDisplayCompanies();
        }
    };
    xhttp.open("DELETE", getBackendUrl() + '/api/companies/' + Company, true);
    xhttp.send();
}
