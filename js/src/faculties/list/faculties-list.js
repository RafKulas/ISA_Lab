import {clearElementChildren, createLinkCell, createButtonCell, createTextCell} from '../../js/dom_utils.js';
import {getBackendUrl} from '../../js/configuration.js';

window.addEventListener('load', () => {
    fetchAndDisplayFaculties();
});

/**
 * Fetches all users and modifies the DOM tree in order to display them.
 */
function fetchAndDisplayFaculties() {
    const xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            displayUsers(JSON.parse(this.responseText))
        }
    };
    xhttp.open("GET", getBackendUrl() + '/api/faculties', true);
    xhttp.send();
}

/**
 * Updates the DOM tree in order to display faculties.
 *
 * @param {{faculties: string[]}} faculties
 */
function displayUsers(faculties) {
    let tableBody = document.getElementById('tableBody');
    clearElementChildren(tableBody);
    faculties.facultiesResponse.forEach(faculty => {
        tableBody.appendChild(createTableRow(faculty));
    })
}

/**
 * Creates single table row for entity.
 *
 * @param {string} faculty
 * @returns {HTMLTableRowElement}
 */
function createTableRow(faculty) {
    let tr = document.createElement('tr');
    tr.appendChild(createTextCell(faculty.name));
    tr.appendChild(createLinkCell('view', '../view/faculty-view.html?faculty=' + faculty.name));
    tr.appendChild(createLinkCell('edit', '../edit/faculty-edit.html?faculty=' + faculty.name));
    tr.appendChild(createButtonCell('delete', () => deleteFaculty(faculty.name)));
    return tr;
}

function deleteFaculty(faculty) {
    const xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 202) {
            fetchAndDisplayFaculties();
            window.alert("Faculty removed!")
        }
    };
    xhttp.open("DELETE", getBackendUrl() + '/api/faculties/' + faculty, true);
    xhttp.send();
}
