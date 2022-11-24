import {clearElementChildren, createLinkCell, createButtonCell, createTextCell} from '../js/dom_utils.js';
import {getBackendUrl} from '../js/configuration.js';

window.addEventListener('load', () => {
    fetchAndDisplayCompanies();
});

/**
 * Fetches all Companies and modifies the DOM tree in order to display them.
 */
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

/**
 * Updates the DOM tree in order to display Companies.
 *
 * @param {{Companies: string[]}} Companies
 */
function displayCompanies(Companies) {
    let tableBody = document.getElementById('tableBody');
    clearElementChildren(tableBody);
    Companies.companies.forEach(company => {
        tableBody.appendChild(createTableRow(company.name));
    })
}

/**
 * Creates single table row for entity.
 *
 * @param {string} Company
 * @returns {HTMLTableRowElement}
 */
function createTableRow(company) {
    let tr = document.createElement('tr');
    tr.appendChild(createTextCell(company));
    tr.appendChild(createLinkCell('Details', 'update_company.html?company=' + company));
	tr.appendChild(createLinkCell('Edit', 'update_company.html?company=' + company));
    tr.appendChild(createButtonCell('Delete', () => deleteCompany(company)));
    return tr;
}

/**
 * Deletes entity from backend and reloads table.
 *
 * @param {string } Company to be deleted
 */
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
