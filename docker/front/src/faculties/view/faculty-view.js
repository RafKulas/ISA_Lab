import {
    getParameterByName,
    clearElementChildren,
    createLinkCell,
    createButtonCell,
    createTextCell,
    setTextNode
} from '../../js/dom_utils.js';
import {getBackendUrl} from '../../js/configuration.js';

window.addEventListener('load', () => {
    fetchAndDisplayFaculty();
    fetchAndDisplayStudents();
    createAddStudentLink();
});

function createAddStudentLink() {
    const a = document.getElementById('add');
    a.href = `../../students/add/student-add.html?faculty=${getParameterByName("faculty")}`
}

function fetchAndDisplayStudents() {
    const xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            displayStudents(JSON.parse(this.responseText))
        }
    };
    xhttp.open("GET", getBackendUrl() + '/api/students?faculty=' + getParameterByName("faculty"), true);
    xhttp.send();
}

function displayStudents(students) {
    let tableBody = document.getElementById('tableBody');
    clearElementChildren(tableBody);
    students.studentsResponse.forEach(student => {
        tableBody.appendChild(createTableRow(student));
    })
}

/**
 * Creates single table row for entity.
 *
 * @param {{id: number, name: string}} student
 * @returns {HTMLTableRowElement}
 */
function createTableRow(student) {
    let tr = document.createElement('tr');
    tr.appendChild(createTextCell(student.name));
    tr.appendChild(createTextCell(student.surname));
    tr.appendChild(createTextCell(student.indexNumber));
    tr.appendChild(createLinkCell('view', '../../students/view/student-view.html?student=' + student.indexNumber));
    tr.appendChild(createLinkCell('edit', '../../students/edit/student-edit.html?student=' + student.indexNumber));
    tr.appendChild(createButtonCell('delete', () => deleteStudent(student.indexNumber)));
    return tr;
}

function deleteStudent(indexNumber) {
    const xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 202) {
            fetchAndDisplayStudents();
            window.alert("Student removed!")
        }
    };
    xhttp.open("DELETE", getBackendUrl() + '/api/students/' + indexNumber, true);
    xhttp.send();
}

function fetchAndDisplayFaculty() {
    const xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            displayFaculty(JSON.parse(this.responseText))
        }
    };
    xhttp.open("GET", getBackendUrl() + '/api/faculties/' + getParameterByName('faculty'), true);
    xhttp.send();
}

function displayFaculty(faculty) {
    setTextNode('name', faculty.name);
    setTextNode('dean', faculty.dean);
    setTextNode('numberOfStudents', faculty.numberOfStudents);
}
