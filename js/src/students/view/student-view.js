import {
    getParameterByName,
    setTextNode
} from '../../js/dom_utils.js';
import {getBackendUrl} from '../../js/configuration.js';

window.addEventListener('load', () => {
    fetchAndDisplayStudent();
});

function fetchAndDisplayStudent() {
    const xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            displayStudent(JSON.parse(this.responseText))
        }
    };
    xhttp.open("GET", getBackendUrl() + '/api/students/' + getParameterByName('student'), true);
    xhttp.send();
}

function displayStudent(student) {
    setTextNode('name', student.name);
    setTextNode('surname', student.surname);
    setTextNode('indexNumber', student.indexNumber);
    setTextNode('fieldOfStudies', student.fieldOfStudies);
    setTextNode('faculty', student.faculty)
}
